package fr.solutec.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import fr.solutec.dao.ClientRepository;
import fr.solutec.dao.ImageRepository;
import fr.solutec.entities.Client;
import fr.solutec.entities.ImageModel;
import fr.solutec.entities.User;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping
public class ImageRest {

	@Autowired
    ImageRepository imageRepository;
	@Autowired 
	ClientRepository clientrepo;
    @PostMapping("/uploadimage")
    public ImageModel uploadImage(@RequestBody Long id, @ModelAttribute("myFile") MultipartFile file) throws IOException {
    Client c = new Client();
    c=clientrepo.findById(id);
    
System.out.println(c.toString());
        ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes(), c );


        final ImageModel savedImage = imageRepository.save(img);


        System.out.println("Image saved");


        return savedImage;


    }
}
