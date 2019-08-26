package fr.solutec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import fr.solutec.dao.EventRepository;
import fr.solutec.entities.Event;

public class EventRest {

	
	@Autowired
	private EventRepository eventRepo;
	
	public Event save(@RequestBody Event e){
		return eventRepo.save(e);
	}
	
	public List<Event> getAll() {
		return eventRepo.findAll();
	}
		
	public List<Event> EvenementAnterieur() {
		Date d = new Date();
		return eventRepo.findByDateEventBefore(d);
	}
	
	public List<Event> EvenementPosterieur() {
		Date d = new Date();
		return eventRepo.findByDateEventAfter(d);
	}
		
}
