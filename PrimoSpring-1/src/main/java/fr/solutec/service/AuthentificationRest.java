package fr.solutec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.BarRepository;
import fr.solutec.dao.ClientRepository;
import fr.solutec.dao.GroupeRepository;
import fr.solutec.entities.Client;

@RestController
@CrossOrigin("*")

public class AuthentificationRest {
	@Autowired
	private ClientRepository clientRepo;
	private BarRepository barRepo;
	private GroupeRepository groupeRepo;
	
/*	@RequestMapping(value = "/connexion/type", method = RequestMethod.GET)
	public String getTypeUser(String mail) {
		String type ="";
		
		if (clientRepo.findByMail(mail)!=null);
		
		return type;
		
		
	}*/
}
