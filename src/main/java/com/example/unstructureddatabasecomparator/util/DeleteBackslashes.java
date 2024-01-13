package com.example.unstructureddatabasecomparator.util;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class DeleteBackslashes {
    public static void deleteBackslashes(){
        String filePath = "dataset/movies_metadata.csv";

        try {
            // Read the content of the file
            Path path = Paths.get(filePath);
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

            String modifiedContent = content.replace("\\\\", "");

            Files.write(path, modifiedContent.getBytes(StandardCharsets.UTF_8));

            System.out.println("Backslashes removed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
