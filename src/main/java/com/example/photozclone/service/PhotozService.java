package com.example.photozclone.service;

import com.example.photozclone.model.Photo;
import com.example.photozclone.repository.PhotozRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotozService {

    private final PhotozRepository photozRepository;

    public PhotozService(@Autowired PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        Photo photo = photozRepository.findById(id).orElse(null);
        if (photo == null) {
            throw new RuntimeException("photo not found");
        }
        return photo;
    }

    public void remove(Integer id) {
        Photo photo = photozRepository.findById(id).orElse(null);
        if (photo == null) {
            throw new RuntimeException("photo not found");
        }
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] file) {
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setFileContent(file);
        photo.setContentType(contentType);
        System.out.println("New photo created: " + photo);
        photozRepository.save(photo);
        return photo;
    }
}
