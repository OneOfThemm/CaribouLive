package fr.solutec.entities;

import javax.persistence.Entity;


@Entity
public class Groupe extends User{


		
	private String description;
	private double cachet;
	private String mail;
	private byte[] son;
	
	
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Groupe(String nom,String mdp, String description, double cachet, String mail, byte[] son) {
		super(nom, mdp);		
		this.description = description;
		this.cachet = cachet;
		this.mail = mail;
		this.son = son;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getCachet() {
		return cachet;
	}


	public void setCachet(double cachet) {
		this.cachet = cachet;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public byte[] getSon() {
		return son;
	}


	public void setSon(byte[] son) {
		this.son = son;
	}



	@Override
	public String toString() {
		return "Groupe [id=" + id + ", nom=" + nom + ", description=" + description + ", cachet=" + cachet + ", mail=" + mail +" ]";
	}
	
	

	
	
}
