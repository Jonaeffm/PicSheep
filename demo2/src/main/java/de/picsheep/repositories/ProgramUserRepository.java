package de.picsheep.repositories;

import org.springframework.data.repository.CrudRepository;

import de.picsheep.domain.ProgramUser;


public interface ProgramUserRepository extends CrudRepository<ProgramUser, Long> {
    ProgramUser findByUsername(String username);
}