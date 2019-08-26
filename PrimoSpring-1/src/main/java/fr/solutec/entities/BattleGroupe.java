package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class BattleGroupe extends Event {
	
	private int cahchetmax;
	private int nbgroupes;
	private int prix;
	
	@ManyToOne
	private Bar bar;
	
	@ManyToOne
	private Genre genre;
	
	public BattleGroupe() {
		super();
	}
	
	public BattleGroupe(int cahchetmax, int nbgroupes, int prix, Bar bar, Genre genre) {
		super();
		this.cahchetmax = cahchetmax;
		this.nbgroupes = nbgroupes;
		this.prix = prix;
		this.bar = bar;
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
