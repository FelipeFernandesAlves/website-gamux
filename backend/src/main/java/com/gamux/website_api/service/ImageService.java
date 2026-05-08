package com.gamux.website_api.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
    
    private Path storagePath;

    public ImageService(@Value("${file.upload-dir}") String uploadDir) throws IOException {
        this.storagePath = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(storagePath);
    }

    public String uploadImage(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("File is empty");
        }

        String name = file.getOriginalFilename();
        if (name == null || !name.toLowerCase().matches(".*\\.(jpg|jpeg|png|gif)$")) {
            throw new Exception("Only image files are allowed (jpg, jpeg, png, gif)");
        }

        String storageName = UUID.randomUUID() + "-" + Paths.get(name).getFileName().toString();
        Path targetPath = storagePath.resolve(storageName).normalize();
        if (!targetPath.startsWith(storagePath)) {
            throw new Exception("Invalid file path");
        }

        try (InputStream inputStream = file.getInputStream()) {
            java.nio.file.Files.copy(inputStream, targetPath);
            return storageName;
        } catch (IOException e) {
            throw new Exception("Failed to store file", e);
        }
    }

    public Resource getImage(String imgName) throws Exception {
        try {
            Path filepath = storagePath.resolve(imgName).normalize();
            Resource resource = new UrlResource(filepath.toUri());

            if (resource.exists() && resource.isReadable())
                return resource;
            
            throw new Exception("File not found or not readable");
        } catch (Exception e) {
            throw new Exception("Failed to retrieve file", e);
        }
    }

    public void deleteImage(String imgName) throws Exception {
        try {
            Path filepath = storagePath.resolve(imgName).normalize();
            Files.deleteIfExists(filepath);
        } catch (IOException e) {
            throw new Exception("Failed to delete file", e);
        }
    }
}
