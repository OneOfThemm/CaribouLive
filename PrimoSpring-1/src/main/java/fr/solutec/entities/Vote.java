package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	@Id @GeneratedValue
	protected Long id;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Groupe groupe;
	
	@ManyToOne 
	private BattleGroupe battlegroupe;

	public Vote() {
		super();
	}

	public Vote(Client client, Groupe groupe, BattleGroupe battlgroupe) {
		super();
		this.client = client;
		this.groupe = groupe;
		this.battlegroupe = battlgroupe;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public BattleGroupe getBattlgroupe() {
		return battlegroupe;
	}

	public void setBattlgroupe(BattleGroupe battlgroupe) {
		this.battlegroupe = battlgroupe;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", client=" + client + ", groupe=" + groupe + ", battlgroupe=" + battlegroupe
				+ ", getClient()=" + getClient() + ", getGroupe()=" + getGroupe() + ", getBattlgroupe()="
				+ getBattlgroupe() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BattleGroupe getBattlegroupe() {
		return battlegroupe;
	}

	public void setBattlegroupe(BattleGroupe battlegroupe) {
		this.battlegroupe = battlegroupe;
	}	
	
	
}
