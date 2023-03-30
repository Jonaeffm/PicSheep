package de.picsheep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.picsheep.domain.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
