package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import fr.solutec.entities.Client;
import fr.solutec.entities.ClientToClient;

public interface ClientToClientRepository extends JpaRepository<ClientToClient, Long>  {
	public ClientToClient findClientToClientById (@PathVariable Long id);
	public ClientToClient findClientToClientByClientEnvoi (@PathVariable Client c);
	public ClientToClient findClientToClientByClientRecu (@PathVariable Client c);
	
	
}
