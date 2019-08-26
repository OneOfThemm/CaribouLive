package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
