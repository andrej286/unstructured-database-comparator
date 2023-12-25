package com.example.unstructureddatabasecomparator.service;

import com.example.unstructureddatabasecomparator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class KaggleService {
    public static void downloadDataset() {
        try {
            String datasetUrl = "https://www.kaggle.com/api/v1/datasets/download/rounakbanik/the-movies-dataset";
            KaggleDatasetDownloader.downloadDataset(datasetUrl); // Downloads .zip file to the root of the project
            UnzipUtility.unzip("result.zip", "dataset"); // Extracts the .zip file to a new directory called dataset, also in the root folder
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
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
            destDir.mkdir();
        }

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            // iterates over entries in the zip file
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    // if the entry is a file, extracts it
                    extractFile(zipIn, filePath);
                } else {
                    // if the entry is a directory, make the directory
                    File dir = new File(filePath);
                    dir.mkdir();
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
