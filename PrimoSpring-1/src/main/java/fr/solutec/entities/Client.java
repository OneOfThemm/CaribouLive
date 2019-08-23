package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



//La classe des clients découle de User et a juste un mail en plus. 

@Entity
public class Client extends User{
	private String mail;
	
// un user peut avoir plusieurs clients et un client découle d'un seul user.
	
	
		public Client() {
	super();
}

	public Client(String nom,String mdp,String mail) {
	super(nom, mdp);
	this.mail = mail;
	
}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}	
}
