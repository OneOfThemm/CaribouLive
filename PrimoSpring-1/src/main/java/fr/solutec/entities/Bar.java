package fr.solutec.entities;

import javax.persistence.Entity;

@Entity
public class Bar extends User{

	private String nomGerant;
	private String tel;
	private String mail;
	private int capacitemax;

	
	
	public Bar() {
		super();
	}

	public Bar(String nom, String mdp,String nomGerant, String tel, String mail, int capacitemax) {
		super(nom, mdp);
		this.nomGerant = nomGerant;
		this.tel = tel;
		this.mail = mail;
		this.capacitemax = capacitemax;
	}
	
	public String getNomGerant() {
		return nomGerant;
	}
	public void setNomGerant(String nomGerant) {
		this.nomGerant = nomGerant;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getCapacitemax() {
		return capacitemax;
	}
	public void setCapacitemax(int capacitemax) {
		this.capacitemax = capacitemax;
	}
	
	
}
