package fr.solutec.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.BarRepository;
import fr.solutec.dao.ClientRepository;
import fr.solutec.dao.GroupeRepository;

import fr.solutec.entities.Bar;
import fr.solutec.entities.Client;
import fr.solutec.entities.Groupe;

@RestController
@CrossOrigin("*")

public class AuthentificationRest {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private BarRepository barRepo;
	@Autowired
	private GroupeRepository groupeRepo;
	@RequestMapping(value = "/connexion/type/{mail:.+}", method = RequestMethod.GET)
	public String getTypeUser(@PathVariable String mail) {
		String type = "";
		Client c = new Client();
		c = null;
		Bar b = new Bar();
		b = null;
		Groupe g = new Groupe();
		g = null;
		try {
			c = clientRepo.findByMail(mail);

		} catch (Exception e) {
			System.err.println("erreur : " + e);
		}
		System.out.println("bonsoir");

		try {
			b = barRepo.findByMail(mail);

		} catch (Exception e) {
			System.err.println("erreur : " + e);
		}
		try {
			g = groupeRepo.findByMail(mail);
		} catch (Exception e) {
			System.err.println("erreur : " + e);
		}

		if (c != null) {
			type = "client";
		} else if (b != null) {
			type = "bar";

		} else if (g != null) {
			type = "groupe";
		} else {
			type = "unknown";
		}	
		return type;
	}
}
