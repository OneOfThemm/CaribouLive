package fr.solutec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.BattleGroupeRepository;
import fr.solutec.entities.BattleGroupe;

@RestController
@CrossOrigin("*")
public class BattleGroupeRest {
	@Autowired
	private BattleGroupeRepository battleGroupRepos;
	
	@RequestMapping(value = "/battlegroupe", method = RequestMethod.POST)
	public BattleGroupe save(@RequestBody BattleGroupe p){
		return battleGroupRepos.save(p);
	}

}