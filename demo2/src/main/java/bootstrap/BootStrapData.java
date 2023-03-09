package bootstrap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import domain.ProgramUser;
import repositories.ProgramUserRepository;


@EnableAutoConfiguration
@Component
public class BootStrapData implements CommandLineRunner{
	@Autowired
	private ProgramUserRepository uR;
	@Override
	public void run(String... args) throws Exception {
		ProgramUser a = new ProgramUser("a","a");
		ProgramUser b = new ProgramUser("b","b");
		uR.save(a);
		uR.save(b);
		// TODO Auto-generated method stub
		//uploadImage(/home/jon/Bilder/gemischt/a.jpg);
		//testUpload();
	}
}