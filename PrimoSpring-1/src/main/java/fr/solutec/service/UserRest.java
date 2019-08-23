package fr.solutec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.UserRepository;



@RestController
@CrossOrigin("*")
public class UserRest {
	@Autowired
	private UserRepository userRepos;

}
