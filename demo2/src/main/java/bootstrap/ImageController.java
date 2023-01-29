package bootstrap;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
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
import org.thymeleaf.util.ArrayUtils;

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
	
	@GetMapping(value = "/test" )
	public String testUpload() throws IOException
	{
		Image i = new Image();
		i.setContent(imageJPG("/home/jon/Bilder/gemischt/a.jpg"));
		i.setName("testImage");
		long testID=  imageDbRepository.save(i).getId();
		//downloadImage(testID);
		//String returnStr = "redirect:/image/"+testID;
		//return returnStr;
		/*byte[] image = imageDbRepository.findById(testID)
			      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
			      .getContent();*/

			    return "hW";
		
	}
	
	private String imageBase64;

	public String getImageBase64() {
	    return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
	    this.imageBase64 = imageBase64;
	}
	
	@GetMapping("/images")
	public String getHomePage(Model model,HttpServletResponse response) throws IOException {
		
			List<Image> images = imageDbRepository.findAll();
		
	       Map<Long, String> productBase64Images = new HashMap<>();
	        for(Image image: images){               
	            
	        	byte[] encodedCont = Base64.encodeBase64(image.getContent());
	        	String contHeader = "Basic " + new String(encodedCont);
	        	
	        	productBase64Images.put(image.getId(), contHeader);

	        }
	        model.addAttribute("images", productBase64Images);
	    //model.addAttribute("images", imageDbRepository.findAll());
	    return "home";
	}
	
	
}
