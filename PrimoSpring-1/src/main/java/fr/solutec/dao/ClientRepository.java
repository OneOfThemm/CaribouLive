package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import fr.solutec.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

	public List<Client> findByMail(String mail);
	public List<Client> findByNom (String nom);
	public Client deleteById (@PathVariable Long id);
	
}
