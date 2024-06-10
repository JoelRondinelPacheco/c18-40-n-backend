package com.example.demo.services.image;

import com.example.demo.persistence.entities.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Image save(MultipartFile image);
}
