package sevices;

import java.sql.Date;
import java.util.List;

import domain.Album;

import domain.Image;

public interface IImageService {
	public void deleteById(long ID);
	public List<Image> findByAlbum(Album a);
	public List<Image> findAll();
}
