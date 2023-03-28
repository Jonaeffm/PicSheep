package sevices;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Album;

import domain.Image;
import repositories.ImageDbRepository;

@Service
public class ImageService implements IImageService{
	
	@Autowired
	private ImageDbRepository repository;
	
	public List<Image> findByAlbum(Album a)
	{
	List<Image> temp = (List<Image>) repository.findAll();
	for(int i=temp.size()-1;i>-1;i--)
	{
		if(!temp.get(i).getAlbum().equals(a))
						temp.remove(i);
	}
	return temp;
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
}	
