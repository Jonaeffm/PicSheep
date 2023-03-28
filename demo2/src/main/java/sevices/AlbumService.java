package sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
