package fr.solutec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.GenreRepository;
import fr.solutec.entities.Genre;

@RestController
@CrossOrigin("*")
public class GenreRest {
	@Autowired
	private GenreRepository genreGroupRepos;
	
	@RequestMapping(value = "/genresnoms", method = RequestMethod.GET)
	public List<Genre> getGenre(){
		return genreGroupRepos.findAll();
	}
}
