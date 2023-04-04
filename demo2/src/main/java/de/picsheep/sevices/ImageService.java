package de.picsheep.sevices;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.picsheep.domain.Album;
import de.picsheep.domain.Image;
import de.picsheep.repositories.ImageDbRepository;

@Service
public class ImageService implements IImageService{
	
	@Autowired
	private ImageDbRepository repository;
	
	public List<Image> findByAlbum(Album a)
	{
	return repository.findByAlbum(a.getId());
}
	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		repository.deleteById(ID);
	}
	
	public List<Image> findAll()
	{
		return repository.findAll();
	}
	
	public Optional<Image> findById(Long imageId)
	{
		return repository.findById(imageId);
	}
	@Override
	public Image save(Image i2) {
		// TODO Auto-generated method stub
		return repository.save(i2);
	}
	
	
}	
