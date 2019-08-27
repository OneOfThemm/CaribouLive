package fr.solutec.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
public abstract class Event {
	
	@Id @GeneratedValue
	protected Long id;
	@Temporal (TemporalType.DATE)
	protected Date dateEvent;
	
	protected String nom;
	protected String description;
	protected boolean visibleClient;
	
	public Event() {

	}
	
	public Event(Date dateEvent, String nom, String description) {
		super();
		this.dateEvent = dateEvent;
		this.nom = nom;
		this.description = description;
		this.visibleClient =false;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isVisibleClient() {
		return visibleClient;
	}
	public void setVisibleClient(boolean visibleClient) {
		this.visibleClient = visibleClient;
	}
	
	
}
