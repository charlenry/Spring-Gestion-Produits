package com.charlenry.produits.restcontrollers;

import java.io.IOException;
import java.util.List;

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
  
  @GetMapping("/getImagesProd/{idProd}")
  public List<Image> getImagesProd(@PathVariable("idProd") Long idProd)
      throws IOException {
    return imageService.getImagesParProd(idProd);
  }
  
  @PostMapping("/upload")
  public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
    return imageService.uploadImage(file);
  }

  
  @PostMapping("/uploadImageProd/{idProd}")
  public Image uploadMultiImages(@RequestParam("image") MultipartFile file,
      @PathVariable("idProd") Long idProd)
      throws IOException {
    return imageService.uploadImageProd(file, idProd);
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
