package com.gamux.website_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.service.ImageService;

@RestController
@RequestMapping("/img")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/{imgName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imgName) {
        try {
            Resource file = imageService.getImage(imgName);
            ContentDisposition contentDisposition = ContentDisposition.builder("inline")
                    .filename(file.getFilename())
                    .build();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(contentDisposition);
            headers.setContentType(MediaType.IMAGE_GIF);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(file);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
