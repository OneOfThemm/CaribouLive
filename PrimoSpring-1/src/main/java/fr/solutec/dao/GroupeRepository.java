package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

	public Groupe findByNom (String nom);
}
