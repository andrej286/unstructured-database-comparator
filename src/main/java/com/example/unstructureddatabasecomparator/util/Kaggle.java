package com.example.unstructureddatabasecomparator.util;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

//@Service
public class Kaggle {
    public static void downloadDataset() {
        FilenameFilter csvFilter = (dir, name) -> name.toLowerCase().endsWith(".csv");
        File folder = new File("dataset"); // Replace with your folder path
        File[] files = folder.listFiles(csvFilter);

        if (files == null || files.length < 7) {
            System.out.println("Downloading and extracting dataset...");
            try {
                String datasetUrl = "https://www.kaggle.com/api/v1/datasets/download/rounakbanik/the-movies-dataset";
                KaggleDatasetDownloader.downloadDataset(datasetUrl); // Downloads .zip file to the root of the project
                UnzipUtility.unzip("result.zip", "dataset"); // Extracts the .zip file to a new directory called dataset, also in the root folder
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else System.out.println("Files already downloaded. Skipping...");

        fixFiles();
    }

    private static void fixFiles() {
        FilenameFilter csvFilter = (dir, name) -> name.toLowerCase().endsWith(".csv");
        File folder = new File("dataset");
        File[] files = folder.listFiles(csvFilter);

        if (files == null) {
            return;
        }

        for (File inputFile : files) {
            String tempOutputFilePath = inputFile.getPath().replace(".csv", "_temp.csv");
            File tempOutputFile = new File(tempOutputFilePath);

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempOutputFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String modifiedLine = line.replace("None", "null").replace(",,", ",null,");
                    writer.write(modifiedLine);
                    writer.newLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            File backupOriginalFile = new File(inputFile.getPath() + ".bak");
            boolean backupSuccess = inputFile.renameTo(backupOriginalFile);

            if (backupSuccess) {
                boolean renameSuccess = tempOutputFile.renameTo(inputFile);
                if (!renameSuccess) {
                    System.err.println("Failed to rename: " + tempOutputFile);
                }

                 if (!backupOriginalFile.delete()) {
                     System.out.println("Failed to delete backup file: " + backupOriginalFile.getPath());
                 }
            } else {
                System.err.println("Failed to backup the original file: " + inputFile);
            }
        }
    }
}


class KaggleDatasetDownloader {

    private static final String API_KEY = "e9dbfc51a090ac995cdb83bfcff678aa";

    public static void downloadDataset(String urlString) throws IOException, InterruptedException {
        String credentials = Base64.getEncoder().encodeToString(("sekuloski" + ":" + API_KEY).getBytes());
        HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .header("Authorization", "Basic " + credentials) // Set the authorization header
                .build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of("result.zip")));
        if (response.statusCode() == 200) {
            System.out.println("File downloaded successfully.");
        } else {
            System.out.println("Failed to download file: " + response.statusCode());
        }
    }
}

class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;

    public static void unzip(String zipFilePath, String destDirectory) throws Exception {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            if (!destDir.mkdir()) {
                System.out.println("Failed to make directory!");
                return;
            }
        }

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                } else {
                    File dir = new File(filePath);
                    if (!dir.mkdir()) {
                        System.out.println("Failed to create directory: " + dir.getPath());
                    }
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws Exception {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }
}
