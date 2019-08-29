package fr.solutec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.BarRepository;
import fr.solutec.entities.Bar;
import fr.solutec.entities.Client;
import fr.solutec.entities.Groupe;


@RestController
@CrossOrigin("*")
public class BarRest {
	
	@Autowired
	private BarRepository barRepos;
	
	@RequestMapping(value = "/bars", method = RequestMethod.GET)
	public List<Bar> getPersonnes(){
		return barRepos.findAll();
	}
	
	@RequestMapping(value = "/bar/mail/{email:.+}", method = RequestMethod.GET)
	public Bar getBarByMail(@PathVariable String email) {
		return barRepos.findByMail(email);
	} 	
	
	@RequestMapping(value = "/addbar", method = RequestMethod.POST)
	public Bar save(@RequestBody Bar b){
		return barRepos.save(b);
	}

}
