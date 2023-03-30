package de.picsheep.sevices;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import de.picsheep.domain.Album;
import de.picsheep.domain.Image;

public interface IImageService {
	public void deleteById(long ID);
	public List<Image> findByAlbum(Album a);
	public List<Image> findAll();
	public Optional<Image> findById(Long imageId);
	public Image save(Image i2);
}
