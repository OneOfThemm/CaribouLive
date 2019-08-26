package fr.solutec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
