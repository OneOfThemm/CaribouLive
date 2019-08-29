package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class BattleGroupe extends Event {
	
	private int cachetmax;
	private int nbgroupes;
	private int prix;
	
	@ManyToOne
	private Bar bar;
	
	@ManyToOne
	private Genre genre;
	
	public BattleGroupe() {
		super();
	}
	
	public BattleGroupe(Date dateEvent, String nom, String description,int cahchetmax, int nbgroupes, int prix) {
		super(dateEvent,nom,description);
		this.cachetmax = cahchetmax;
		this.nbgroupes = nbgroupes;
		this.prix = prix;
	}

	
	public int getCachetmax() {
		return cachetmax;
	}

	public void setCachetmax(int cahchetmax) {
		this.cachetmax = cahchetmax;
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

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}	
	
}
