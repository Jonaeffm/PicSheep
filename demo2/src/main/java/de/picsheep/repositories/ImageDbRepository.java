package de.picsheep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.picsheep.domain.Image;

public interface ImageDbRepository extends JpaRepository<Image, Long>{

}
