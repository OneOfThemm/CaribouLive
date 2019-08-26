package fr.solutec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.BarRepository;
import fr.solutec.entities.Bar;
import fr.solutec.entities.User;


@RestController
@CrossOrigin("*")
public class BarRest {
	@Autowired
	private BarRepository barRepos;
	
	@RequestMapping(value = "/bars", method = RequestMethod.GET)
	public List<User> getPersonnes(){
		return barRepos.findAll();
	}
}
