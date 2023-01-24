package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Image;

public interface ImageDbRepository extends JpaRepository<Image, Long>{

}
