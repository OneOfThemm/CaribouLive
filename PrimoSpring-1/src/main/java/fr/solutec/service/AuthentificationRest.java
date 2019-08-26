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
	private BarRepository barRepoS;
	private GroupeRepository groupeRepoS;

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
			b = barRepoS.findByMail(mail);	
			c = clientRepo.findByMail(mail);
					
			g = groupeRepoS.findByMail(mail);

		} catch (Exception e) {
			System.err.println("erreur : " + e);
		}
		if (b != null) {
			type = "bar";
		} else {
			if (c != null) {
				type = "client";

			} else {
				if (g != null) {
					type = "groupe";
				} else {
					type = "unknown";
				}
			}
		}
		/*
		 * if (groupeRepo.findByMail(mail) != null) { type = "groupe"; } else { if
		 * (barRepo.findByMail(mail) != null) { type = "bar"; } else { if
		 * (clientRepo.findByMail(mail) != null) { type = "client"; } else { type =
		 * "unknown"; } } }
		 */
		return type;
	}
}
