package fr.solutec.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.solutec.entities.Event;


public interface EventRepository extends JpaRepository<Event, Long>{
	public List<Event> findByNom (String nom);
	
	public List<Event> findByDateEventBefore (Date date); 
	public List<Event> findByDateEventAfter (Date date); 

	//public List<Event> findByVisibleClient (Boolean );

}
