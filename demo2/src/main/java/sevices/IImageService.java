package sevices;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import domain.Album;

import domain.Image;

public interface IImageService {
	public void deleteById(long ID);
	public List<Image> findByAlbum(Album a);
	public List<Image> findAll();
	public Optional<Image> findById(Long imageId);
	public Image save(Image i2);
}
