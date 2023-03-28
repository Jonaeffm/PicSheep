package sevices;

import java.util.List;
import java.util.Optional;

import domain.Album;
import domain.Image;

public interface IAlbumService {
	public void deleteById(long ID);
	public List<Album> findAll();
	public Optional<Album> findById(Long albumId);
}
