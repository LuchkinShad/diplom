package com.example.diplom.diplom.services;

import com.example.diplom.diplom.models.Image;
import com.example.diplom.diplom.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void saveImage (Image image)
    {
        imageRepository.save(image);
    }

    public Image getByIdImage (Long id)
    {
        return imageRepository.getById(id);
    }

}
