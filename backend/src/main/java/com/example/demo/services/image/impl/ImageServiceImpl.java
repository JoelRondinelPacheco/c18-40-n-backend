package com.example.demo.services.image.impl;

import com.example.demo.persistence.entities.Image;
import com.example.demo.persistence.repository.ImagesRepository;
import com.example.demo.services.image.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImagesRepository imagesRepository;

    public ImageServiceImpl(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    @Override
    public Image save(MultipartFile image) {
        if (image != null) {
            Image img = new Image();
            img.setName(image.getName());
            img.setMime(image.getContentType());
            try {
                img.setContent(image.getBytes());
                return this.imagesRepository.save(img);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
