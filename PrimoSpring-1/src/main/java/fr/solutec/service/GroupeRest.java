package fr.solutec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.GroupeRepository;
import fr.solutec.entities.Client;
import fr.solutec.entities.Groupe;

@RestController
@CrossOrigin("*")
public class GroupeRest {
	
	@Autowired
	private GroupeRepository groupeRepos;
	
	@RequestMapping(value = "/groupes", method = RequestMethod.GET)
	public List<Groupe> getGroupe(){
		return groupeRepos.findAll();
	}
	
	public Groupe getGroupe (String name) {
		return groupeRepos.findByNom(name);
	}
	
	@RequestMapping(value = "/addgroupe", method = RequestMethod.POST)
	public Groupe save (@RequestBody Groupe g) {
		return groupeRepos.save(g);
	}
	
	@RequestMapping(value = "/groupe/mail/{email:.+}", method = RequestMethod.GET)
	public Groupe getGroupebyMail(@PathVariable String email) {
		return groupeRepos.findByMail(email);
	} 	
		
	
	public boolean deleteGroupe (@PathVariable Long id) {
		groupeRepos.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/groupeedit", method = RequestMethod.POST)
	public Groupe updateClient(@RequestBody Groupe groupe) {
		Long i = groupe.getId();
		Groupe g = groupeRepos.findById(i);
		g = groupeRepos.save(groupe);
		return g;
	}

}