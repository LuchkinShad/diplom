package com.example.diplom.diplom.controllers.restControllers;

import com.example.diplom.diplom.models.Image;
import com.example.diplom.diplom.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/product/img/{id}")
    public ResponseEntity<?> getByIdImg(@PathVariable Long id)
    {
        Image image = imageRepository.getById(id);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
