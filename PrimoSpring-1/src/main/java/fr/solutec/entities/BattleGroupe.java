package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class BattleGroupe extends Event {
	
	private int cahchetmax;
	private int nbgroupes;
	private int prix;
	
	/*@OneToMany
	private Bar bar;
	
	@OneToMany
	private Event event;
	
	@OneToMany
	private Genre genre;*/
	
	public BattleGroupe() {
		super();
	}
	
	public BattleGroupe(int cahchetmax, int nbgroupes, int prix, Bar bar, Event event, Genre genre) {
		super();
		this.cahchetmax = cahchetmax;
		this.nbgroupes = nbgroupes;
		this.prix = prix;
		/*this.bar = bar;
		this.event = event;
		this.genre = genre;*/
	}

	
	public int getCahchetmax() {
		return cahchetmax;
	}

	public void setCahchetmax(int cahchetmax) {
		this.cahchetmax = cahchetmax;
	}

	public int getNbgroupes() {
		return nbgroupes;
	}

	public void setNbgroupes(int nbgroupes) {
		this.nbgroupes = nbgroupes;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	/*public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}*/
	
	
	
}
