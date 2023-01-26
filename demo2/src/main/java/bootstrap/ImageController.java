package bootstrap;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;


import domain.Image;
import jakarta.servlet.http.HttpServletResponse;
import repositories.ImageDbRepository;

@Controller
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
	@GetMapping("/images")
	public String getHomePage(Model model,HttpServletResponse response) throws IOException {
		List<Image> images = imageDbRepository.findAll();
		//Image image = imageDbRepository.findById((long) 1).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		response.setContentType("image/jpeg"); // Or whatever format you wanna use
List<InputStream> isList=new ArrayList<InputStream>();
		for(int i = 1;i<images.size()+1;i++)
		{InputStream temp = new ByteArrayInputStream(images.get(i).getContent());
		 isList.set(i, temp) ;
		 IOUtils.copy(isList.get(i), response.getOutputStream());
		 }

		
	    model.addAttribute("images", imageDbRepository.findAll());
	    return "home";
	}
	
	
}
