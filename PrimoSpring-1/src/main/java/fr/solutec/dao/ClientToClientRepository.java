package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.ClientToClient;

public interface ClientToClientRepository extends JpaRepository<ClientToClient, Long>  {

}
