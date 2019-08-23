package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;



//La classe des clients découle de User et a juste un mail en plus. 

@Entity
public class Client extends User{
	private String mail;
	
// un user peut avoir plusieurs clients et un client découle d'un seul user.
	
	@ManyToOne
	private User user;	
	

	public Client() {
	super();
}

	public Client(String mail, User user) {
	super();
	this.mail = mail;
	this.user = user;
}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
