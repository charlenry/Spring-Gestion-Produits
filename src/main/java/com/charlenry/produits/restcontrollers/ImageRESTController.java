package com.charlenry.produits.restcontrollers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.charlenry.produits.entities.Image;
import com.charlenry.produits.service.ImageService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRESTController {
  
  @Autowired
  ImageService imageService;


  @GetMapping("/getInfo/{id}")
  public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
    return imageService.getImageDetails(id);
  }

  @GetMapping("/load/{id}")
  public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
    return imageService.getImage(id);
  }
  
  @PostMapping("/upload")
  public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
    return imageService.uploadImage(file);
  }
  
  @PutMapping("/update")
  public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
    return imageService.uploadImage(file);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteImage(@PathVariable("id") Long id) {
    imageService.deleteImage(id);
  }

  
  
}
