package fr.solutec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.ClientRepository;
import fr.solutec.dao.ClientToClientRepository;

@RestController
@CrossOrigin("*")

public class ClientToClientRest {	
	@Autowired
	private ClientToClientRepository clientToClientRepo;	
	@Autowired
	private ClientRepository clientRepo;
	
	
}
