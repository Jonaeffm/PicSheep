package de.picsheep.sevices;

import java.util.List;
import java.util.Optional;

import de.picsheep.domain.Album;
import de.picsheep.domain.Image;

public interface IAlbumService {
	public void deleteById(long ID);
	public List<Album> findAll();
	public Optional<Album> findById(Long albumId);
	public Album save(Album a);
}
