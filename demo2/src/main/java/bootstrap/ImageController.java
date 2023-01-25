package bootstrap;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;


import domain.Image;

import repositories.ImageDbRepository;

@RestController
public class ImageController {

	@Autowired
	ImageDbRepository imageDbRepository;
	
	
	
	byte[] imageJPG(String path) throws IOException
	{
		
		byte[] array = Files.readAllBytes(Paths.get(path));
		return array;
	}
	
	
	
	
	
	@PostMapping
	Long uploadImage(@RequestParam MultipartFile multipartImage) throws Exception
	{
		Image dbImage = new Image();
		dbImage.setName(multipartImage.getName());
		dbImage.setContent(multipartImage.getBytes());
		return imageDbRepository.save(dbImage).getId();
	}
	
	@GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
	Resource downloadImage(@PathVariable Long imageId) {
	    byte[] image = imageDbRepository.findById(imageId)
	      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
	      .getContent();

	    return new ByteArrayResource(image);
	}
	
	@GetMapping(value = "/")
	public String hw() throws IOException{
		testUpload();
		return "hw";
	}
	
	@GetMapping(value = "/test" ,produces = MediaType.IMAGE_JPEG_VALUE)
	public Resource testUpload() throws IOException
	{
		Image i = new Image();
		i.setContent(imageJPG("/home/jon/Bilder/gemischt/a.jpg"));
		i.setName("testImage");
		long testID=  imageDbRepository.save(i).getId();
		//downloadImage(testID);
		//String returnStr = "redirect:/image/"+testID;
		//return returnStr;
		byte[] image = imageDbRepository.findById(testID)
			      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
			      .getContent();

			    return new ByteArrayResource(image);
		
	}
	
}
