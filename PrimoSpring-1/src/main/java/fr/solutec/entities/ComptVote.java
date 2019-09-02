package fr.solutec.entities;

import javax.persistence.Entity;

public class ComptVote {
	
	private String nom;
	private int count;
	
	public ComptVote() {

	}
	public ComptVote(String nom, int count) {
		super();
		this.nom = nom;
		this.count = count;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ComptVote [nom=" + nom + ", count=" + count + "]";
	}
	

}
