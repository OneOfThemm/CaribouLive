package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import fr.solutec.entities.Bar;

public interface BarRepository extends JpaRepository<Bar, Long> {

	public Bar findByNom (String nom);
	public Bar deleteById (@PathVariable Long id);
	public Bar findByMail(String mail);		

}
