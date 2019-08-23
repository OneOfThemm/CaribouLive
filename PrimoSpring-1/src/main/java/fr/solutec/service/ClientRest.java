package fr.solutec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.solutec.dao.ClientRepository;

import fr.solutec.entities.Client;

@RestController
@CrossOrigin("*")

public class ClientRest {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@RequestMapping(value = "/clients", method= RequestMethod.GET)
	public List<Client> getAll(){		
		return clientRepo.findAll();
	}
	
	@RequestMapping(value = "/client", method= RequestMethod.GET)
	public List<Client> getClient (String name) {
		return clientRepo.findByNom(name);
	}
	
}
