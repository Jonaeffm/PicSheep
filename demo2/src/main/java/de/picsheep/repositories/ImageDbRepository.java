package de.picsheep.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.picsheep.domain.Album;
import de.picsheep.domain.Image;

public interface ImageDbRepository extends JpaRepository<Image, Long>{
@Query (value= "SELECT * FROM Image LEFT JOIN Album ON Image.Album.ALBUM_ID=ALBUM_ID WHERE ALBUM_ID=?")
public List<Image> findByAlbum(long id);
}
