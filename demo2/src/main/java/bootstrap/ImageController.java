package bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import domain.Image;
import repositories.ImageDbRepository;

@RestController
public class ImageController {

	@Autowired
	ImageDbRepository imageDbRepository;
	
	@PostMapping
	Long uploadImage(@RequestParam MultipartFile multipartImage) throws Exception
	{
		Image dbImage = new Image();
		dbImage.setName(multipartImage.getName());
		dbImage.setContent(multipartImage.getBytes());
		return imageDbRepository.save(dbImage).getId();
	}
}
