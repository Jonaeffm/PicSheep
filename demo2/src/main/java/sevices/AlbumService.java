package sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import domain.Album;
import domain.Image;
import repositories.AlbumRepository;
import repositories.ImageDbRepository;
@Service
public class AlbumService implements IAlbumService{
	@Autowired
	private AlbumRepository repository;

	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		repository.deleteById(ID);
	}
	
	public List<Album> findAll()
	{
		return repository.findAll();
	}
	
	public Optional<Album> findById(Long albumId)
	{
		return repository.findById(albumId);
	}
}
