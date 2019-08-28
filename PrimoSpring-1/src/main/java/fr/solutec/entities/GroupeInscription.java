package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GroupeInscription {
	@Id@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Groupe groupe;
	
	@ManyToOne
	private BattleGroupe event;
	
	private boolean refused;

	public GroupeInscription() {
	}

	public GroupeInscription(Groupe groupe, BattleGroupe event, boolean refused) {
		super();
		this.groupe = groupe;
		this.event = event;
		this.refused=refused;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public BattleGroupe getEvent() {
		return event;
	}

	public void setEvent(BattleGroupe event) {
		this.event = event;
	}
	
	public boolean isRefused() {
		return refused;
	}

	public void setRefused(boolean refused) {
		this.refused = refused;
	}
	
	
	
	
}
