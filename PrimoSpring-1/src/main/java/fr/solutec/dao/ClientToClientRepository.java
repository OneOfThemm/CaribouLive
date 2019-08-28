package fr.solutec.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import fr.solutec.entities.Client;
import fr.solutec.entities.ClientToClient;

public interface ClientToClientRepository extends JpaRepository<ClientToClient, Long>  {
	@Transactional
	public void deleteById (@PathVariable Long id);
	
	public ClientToClient findClientToClientById (@PathVariable Long id);
	
	public ClientToClient findClientToClientByClientEnvoi (@PathVariable Client c);
	
	public ClientToClient findClientToClientByClientRecu (@PathVariable Client c);
	
	public List<ClientToClient> findByClientRecuId (@PathVariable Long id);
	
	public List<ClientToClient> findByClientEnvoiId (@PathVariable Long id);
	
	
}
