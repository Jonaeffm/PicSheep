package sevices;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import domain.Album;
import domain.Budget;
import domain.Image;
import repositories.ImageDbRepository;
import repositories.budgetRepository;

public class ImageService {
	
	@Autowired
	private ImageDbRepository repository;
	
	public List<Image> findByAlbum(Album a)
	{
	List<Image> temp = (List<Image>) repository.findAll();
	for(int i=temp.size()-1;i>-1;i--)
	{
		if(temp.get(i).getAlbum() != a)
						temp.remove(i);
	}
	return temp;
}
}	
