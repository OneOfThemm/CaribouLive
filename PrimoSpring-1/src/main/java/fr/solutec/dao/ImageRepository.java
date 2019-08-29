package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

}
