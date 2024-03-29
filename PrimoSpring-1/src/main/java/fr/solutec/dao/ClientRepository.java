package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import fr.solutec.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {	
	public List<Client> findByNom (@PathVariable String nom);	
	public Client findByMail(String mail);		
	public Client findById (@PathVariable Long id);	
	public Client deleteById (@PathVariable Long id);
	
	
}
