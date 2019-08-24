package fr.solutec.entities;

import java.util.Arrays;

import javax.persistence.Entity;

//La classe des clients découle de User et a juste un mail en plus. 

@Entity
public class Client extends User {

	private String mail;

// un user peut avoir plusieurs clients et un client découle d'un seul user.

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String mdp, String mail) {
		super(nom, mdp);
		this.mail = mail;
	}

	public Client(String mail) {
		super();
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Client [mail=" + mail + ", id=" + id + ", nom=" + nom + ", mdp=" + mdp + ", photo="
				+ Arrays.toString(photo) + ", getMail()=" + getMail() + ", getId()=" + getId() + ", getNom()="
				+ getNom() + ", getMdp()=" + getMdp() + ", getPhoto()=" + Arrays.toString(getPhoto()) + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
