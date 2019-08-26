package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import fr.solutec.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

	public Groupe findByNom (String nom);
	public Groupe deleteById (@PathVariable Long id);
	public Groupe findByMail(String mail);		

}
