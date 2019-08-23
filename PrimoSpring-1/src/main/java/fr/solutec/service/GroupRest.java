package fr.solutec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.GroupeRepository;
import fr.solutec.entities.Groupe;

@RestController
@CrossOrigin("*")
public class GroupRest {
	
	@Autowired
	private GroupeRepository groupeRepos;
	
	public List<Groupe> getGroupe(){
		return groupeRepos.findAll();
	}
	
	public Groupe getGroupe (String name) {
		return groupeRepos.findByNom(name);
	}
	
	public Groupe save (@RequestBody Groupe g) {
		return groupeRepos.save(g);
	}
	
	public boolean deleteGroupe (@PathVariable Long id) {
		groupeRepos.deleteById(id);
		return true;
	}

}
