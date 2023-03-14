package com.example.photozclone.web;

import com.example.photozclone.model.Photo;
import com.example.photozclone.service.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotozCloneController {

    private final PhotozService photozService;

    public PhotozCloneController(@Autowired PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String HelloWorld(){
        System.out.println("Hello World!");
        return "Hello World!";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get(){
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id){
        Photo photo = photozService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Photo found");
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id){
        Photo photo = photozService.get(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Photo found");
        photozService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photozService.save(file.getOriginalFilename(), file.getContentType(),file.getBytes());

    }

}
