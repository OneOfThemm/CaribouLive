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
import fr.solutec.entities.BattleGroupe;
import fr.solutec.entities.Event;

@RestController
@CrossOrigin("*")
public class BattleGroupeRest {
	@Autowired
	private BattleGroupeRepository battleGroupRepos;
	
	@RequestMapping(value = "/battlegroupe", method = RequestMethod.POST)
	public BattleGroupe save(@RequestBody BattleGroupe p){
		return battleGroupRepos.save(p);
	}
	
	@RequestMapping(value = "/battlegroupes", method = RequestMethod.GET)
	public List<BattleGroupe> getBattleGroupe(){
		return battleGroupRepos.findAll();
	}
	
	
	@RequestMapping(value = "/battlegroupes/{id}", method = RequestMethod.GET)
	public List<BattleGroupe> MyEvents (@PathVariable Long id){
		return battleGroupRepos.getBattleGroupeByBarId(id);
	}
	


	@RequestMapping(value = "/battlegroupes/old/{id}", method = RequestMethod.GET)
	public List<BattleGroupe> MyOldEvents (@PathVariable Long id){
		Date d = new Date();
		//Date yesterday = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L);
		List<BattleGroupe> myEvents = battleGroupRepos.getBattleGroupeByBarId(id);
		List<BattleGroupe> myOldEvents = new ArrayList<BattleGroupe>();
		int nbEvent = 3;		
				
		for (BattleGroupe bg : myEvents) {
			if (myOldEvents.size()  >= nbEvent) {
				break;
				
			} else if (bg.getDateEvent().before(d)) {
				myOldEvents.add(bg);
			}
		}
		return myOldEvents;

	}

	
	@RequestMapping(value = "/battlegroupes/futur/{id}", method = RequestMethod.GET)
	public List<BattleGroupe> MyFuturEvents (@PathVariable Long id){
		Date d = new Date();
		List<BattleGroupe> myEvents = battleGroupRepos.getBattleGroupeByBarId(id);
		List<BattleGroupe> myFuturEvents = new ArrayList<BattleGroupe>();
		int nbEvent = 3;		
				
		for (BattleGroupe bg : myEvents) {
			if (myFuturEvents.size()  >= nbEvent) {
				break;
				
			} else if (bg.getDateEvent().after(d)) {
				myFuturEvents.add(bg);
			}
		}
		
		return myFuturEvents;

	}
	

}
