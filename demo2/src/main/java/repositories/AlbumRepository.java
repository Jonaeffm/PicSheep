package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
