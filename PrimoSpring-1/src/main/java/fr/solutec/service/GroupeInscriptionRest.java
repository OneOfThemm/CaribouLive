package fr.solutec.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.BattleGroupeRepository;
import fr.solutec.dao.GroupeInscriptionRepository;
import fr.solutec.entities.BattleGroupe;
import fr.solutec.entities.GroupeInscription;

@RestController
@CrossOrigin("*")
public class GroupeInscriptionRest {
	@Autowired
	private GroupeInscriptionRepository groupeInscriptionRepos;
	@Autowired
	private BattleGroupeRepository battleGroupeRepos;

	@RequestMapping(value = "/groupeinscri", method = RequestMethod.POST)
	public GroupeInscription save(@RequestBody GroupeInscription i){
		return groupeInscriptionRepos.save(i);
	}
	
	//@RequestMapping(value = "/inscrig/event/{id}", method = RequestMethod.GET)
	//public List<GroupeInscription> getInscriByEvent(@PathVariable Long id){
	//	return groupeInscriptionRepos.findByGroupeId(id);
	//}
	
	@RequestMapping(value = "/inscrig/groupe/{id}", method = RequestMethod.GET)
	public List<GroupeInscription> getInscriByEvent(@PathVariable Long id){
		return groupeInscriptionRepos.findByEventId(id);
	}
	
	@RequestMapping(value = "/inscrig/event/{id}", method = RequestMethod.GET)
	public List<BattleGroupe> getnonInscriByGroupe(@PathVariable Long id){
		List<GroupeInscription> inscri=groupeInscriptionRepos.findByGroupeId(id);
		List<BattleGroupe> events= new ArrayList<BattleGroupe>();
		Date d = new Date();
		for (GroupeInscription groupeInscription : inscri) {
			if(groupeInscription.getEvent().getDateEvent().after(d)) {
				events.add(groupeInscription.getEvent());
			}
		}
		return events;
	}
	
	@RequestMapping(value = "/noninscrig/event/{id}", method = RequestMethod.GET)
	public List<BattleGroupe> getNonInscriByGroupe(@PathVariable Long id){
		Date d = new Date();
		//Recupère les évènements où le groupe est inscrit
		List<GroupeInscription> inscri=groupeInscriptionRepos.findByGroupeId(id);
		//Récupère les futurs évènements
		List<BattleGroupe> events= battleGroupeRepos.findByDateEventAfter(d);
		List<BattleGroupe> eventsnoninscrit= new ArrayList<BattleGroupe>();
		//Parcours les futurs évènements
		for (BattleGroupe battleGroupe : events) {
			boolean sub=false;
			//Parcours les évènements où le groupe est inscrit: si ils sont dans les évènements futurs passe sub à true
			for (GroupeInscription groupeInscription : inscri) {
				if (battleGroupe.getId()==groupeInscription.getEvent().getId()) {
					sub=true;
				}
			}
			//Si l'évènement futur n'est pas dans les évènements où le groupe est inscrit(sub false): le mets dans eventsnoninscrit
			if(!sub) {
				eventsnoninscrit.add(battleGroupe);
			}
		}
		return eventsnoninscrit;
	}
	
	@RequestMapping(value = "/refusegroupe", method = RequestMethod.POST)
	public GroupeInscription refuse(@RequestBody GroupeInscription i){
		i.setRefused(true);	
		return i=groupeInscriptionRepos.save(i);
	}
}
