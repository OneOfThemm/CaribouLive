package fr.solutec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.GroupeInscriptionRepository;
import fr.solutec.entities.BattleGroupe;
import fr.solutec.entities.GroupeInscription;

@RestController
@CrossOrigin("*")
public class GroupeInscriptionRest {
	@Autowired
	private GroupeInscriptionRepository groupeInscriptionRepos;

	@RequestMapping(value = "/groupeinscri", method = RequestMethod.POST)
	public GroupeInscription save(@RequestBody GroupeInscription i){
		return groupeInscriptionRepos.save(i);
	}
	
	@RequestMapping(value = "/inscrig/{id}", method = RequestMethod.GET)
	public List<GroupeInscription> getInscriBybEvent(@PathVariable Long id){
		return groupeInscriptionRepos.findByEventId(id);
	}
	
	@RequestMapping(value = "/refusegroupe", method = RequestMethod.POST)
	public GroupeInscription refuse(@RequestBody GroupeInscription i){
		i.setRefused(true);	
		return i=groupeInscriptionRepos.save(i);
	}
}
