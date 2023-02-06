package bootstrap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@EnableAutoConfiguration
@Component
public class BootStrapData implements CommandLineRunner{
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//uploadImage(/home/jon/Bilder/gemischt/a.jpg);
		//testUpload();
	}
}