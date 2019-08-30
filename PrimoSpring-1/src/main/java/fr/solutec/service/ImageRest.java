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
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping
public class ImageRest {

	@Autowired
    ImageRepository imageRepo;
	@Autowired 
	ClientRepository clientrepo;
	
	
	
	  @PostMapping("/uploadimage")
	    public ImageModel uplaodImage(@RequestParam Long id, @RequestParam("myFile") MultipartFile file) throws IOException {

		  Client c = new Client();
		    c=clientrepo.findById(id);
		      
		      	 System.out.println(c.toString());
	        ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes(), c );


	        final ImageModel savedImage = imageRepo.save(img);


	        System.out.println("Image saved");


	        return savedImage;


	    }
   
    @RequestMapping(value = "/addimage", method = RequestMethod.POST)
	public ImageModel save(@RequestBody ImageModel i){
		return imageRepo.save(i);
	}
    
    @RequestMapping(value = "/images", method = RequestMethod.GET)
	public List<ImageModel> getImageModel() {
		return imageRepo.findAll();
	}
	
}
