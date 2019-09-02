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
import fr.solutec.entities.GroupeInscription;

@RestController
@CrossOrigin("*")
public class BattleGroupeRest {
	@Autowired
	private BattleGroupeRepository battleGroupRepos;

	@RequestMapping(value = "/battlegroupe", method = RequestMethod.POST)
	public BattleGroupe save(@RequestBody BattleGroupe p) {
		return battleGroupRepos.save(p);
	}

	@RequestMapping(value = "/battlegroupes", method = RequestMethod.GET)
	public List<BattleGroupe> getBattleGroupe() {
		return battleGroupRepos.findAll();
	}

	@RequestMapping(value = "/battlegroupes/{id}", method = RequestMethod.GET)
	public BattleGroupe getBattleGroupeById(@PathVariable Long id) {
		return battleGroupRepos.findOne(id);
	}

	@RequestMapping(value = "/battlegroupesfutur", method = RequestMethod.GET)
	public List<BattleGroupe> getFutureBattlegroup() {
		Date d = new Date();
		return battleGroupRepos.findByDateEventAfter(d);
	}

	// BY GROUPE
	@RequestMapping(value = "/battlegroupes/bybar/{id}", method = RequestMethod.GET)
	public List<BattleGroupe> EventDescByIdBar(@PathVariable Long id) {
		return battleGroupRepos.getBattleGroupeByBarId_Desc(id);
	}

	@RequestMapping(value = "/battlegroupes/old{id}", method = RequestMethod.GET)
	public List<BattleGroupe> MyOldEvents(@PathVariable Long id) {
		Date d = new Date();
		List<BattleGroupe> myallEvents = battleGroupRepos.getBattleGroupeByBarId_Desc(id);
		List<BattleGroupe> myOldEvents = new ArrayList<BattleGroupe>();
		for (BattleGroupe bg : myallEvents) {
			if (bg.getDateEvent().before(d)) {
				myOldEvents.add(bg);
			}
		}
		return myOldEvents;

	}

	@RequestMapping(value = "/battlegroupes/futur{id}", method = RequestMethod.GET)
	public List<BattleGroupe> MyFuturEvents(@PathVariable Long id) {
		Date d = new Date();
		List<BattleGroupe> myEvents = battleGroupRepos.getBattleGroupeByBarId_ASC(id);
		List<BattleGroupe> myFuturEvents = new ArrayList<BattleGroupe>();
		int nbEvent = 100;

		for (BattleGroupe bg : myEvents) {
			if (myFuturEvents.size() >= nbEvent) {
				break;

			} else if (bg.getDateEvent().after(d)) {
				myFuturEvents.add(bg);
			}
		}

		return myFuturEvents;

	}

	@RequestMapping(value = "/battlegroupes/old/{name}", method = RequestMethod.GET)
	public List<BattleGroupe> OldEventsBar(@PathVariable String name) {
		Date d = new Date();
		List<BattleGroupe> allEvents = battleGroupRepos.getBattleGroupeByBarName_Desc(name);
		List<BattleGroupe> OldEvents = new ArrayList<BattleGroupe>();
		for (BattleGroupe bg : allEvents) {
			if (bg.getDateEvent().before(d)) {
				OldEvents.add(bg);
			}
		}
		return OldEvents;
	}

	@RequestMapping(value = "/battlegroupes/futur/{name}", method = RequestMethod.GET)
	public List<BattleGroupe> FuturEventsBar(@PathVariable String name) {
		Date d = new Date();
		List<BattleGroupe> allEvents = battleGroupRepos.getBattleGroupeByBarName_ASC(name);
		List<BattleGroupe> futurEvents = new ArrayList<BattleGroupe>();
		for (BattleGroupe bg : allEvents) {
			if (bg.getDateEvent().after(d)) {
				futurEvents.add(bg);
			}
		}
		return futurEvents;
	}

	// BY GENRE
	@RequestMapping(value = "/battlegroupe/{name}", method = RequestMethod.GET)
	public List<BattleGroupe> EventDescByGenre(@PathVariable String name) {
		return battleGroupRepos.getBattleGroupeByGenreNom_Desc(name);
	}

	@RequestMapping(value = "/battlegroupe/old/{name}", method = RequestMethod.GET)
	public List<BattleGroupe> OldEventsGenre(@PathVariable String name) {
		Date d = new Date();
		List<BattleGroupe> allEvents = battleGroupRepos.getBattleGroupeByGenreNom_Desc(name);
		List<BattleGroupe> OldEvents = new ArrayList<BattleGroupe>();
		for (BattleGroupe bg : allEvents) {
			if (bg.getDateEvent().before(d)) {
				OldEvents.add(bg);
			}
		}
		return OldEvents;
	}

	@RequestMapping(value = "/battlegroupe/futur/{name}", method = RequestMethod.GET)
	public List<BattleGroupe> FuturEventsGenre(@PathVariable String name) {
		Date d = new Date();
		List<BattleGroupe> allEvents = battleGroupRepos.getBattleGroupeByGenreNom_ASC(name);
		List<BattleGroupe> futurEvents = new ArrayList<BattleGroupe>();
		for (BattleGroupe bg : allEvents) {
			if (bg.getDateEvent().after(d)) {
				futurEvents.add(bg);
			}
		}
		return futurEvents;
	}

	@RequestMapping(value = "/battlegroupeedit", method = RequestMethod.POST)
	public BattleGroupe updateevent(@RequestBody BattleGroupe battleGroupe) {
		Long i = battleGroupe.getId();
		BattleGroupe b = battleGroupRepos.findById(i);
		b = battleGroupRepos.save(battleGroupe);
		return b;
	}

	// rendre visible pour un client
	@RequestMapping(value="/battleGroupesVisibleClient/{id}", method=RequestMethod.PUT)
	public BattleGroupe rendreVisibleClient(@PathVariable Long id) {
	BattleGroupe bg = battleGroupRepos.findById(id);
	bg.setVisibleClient(true);
	return battleGroupRepos.save(bg);
}

	
	// Voir event futurs dispo pour client	
	@RequestMapping(value = "/battlegroupes/client", method = RequestMethod.GET)
	public List<BattleGroupe> getBattleGroupeClientFutur() {
		Date d = new Date();
		List<BattleGroupe> allEvents = battleGroupRepos.getBattleGroupeClient(true);
		List<BattleGroupe> futurEvents = new ArrayList<BattleGroupe>();
		for (BattleGroupe bg : allEvents) {
			if (bg.getDateEvent().after(d)) {
				futurEvents.add(bg);
			}
		}
		return futurEvents;
	}
	
	@RequestMapping(value = "/battlegroupes/clientall", method = RequestMethod.GET)
	public List<BattleGroupe> getBattleGroupeClient() {
		return battleGroupRepos.getBattleGroupeClient(true);
	}
	
	@RequestMapping(value = "/battlegroupes/{id}", method = RequestMethod.DELETE)
	public void deleteBattleGroup(@PathVariable Long id) {
		battleGroupRepos.delete(id);
	}
	

}
