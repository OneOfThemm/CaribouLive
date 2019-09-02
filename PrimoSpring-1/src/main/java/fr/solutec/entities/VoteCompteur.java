package fr.solutec.entities;

import java.util.List;

public class VoteCompteur {
	
	private String nom;
	private int nb;
	
	public VoteCompteur(List<Object[]> columns){
		//this.id = (columns[0] != null)?((BigDecimal)columns[0]).intValue():0;
       // this.nom = (String) columns.get(1);
     //   this.nb = (Integer) columns[1];
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}
	
	

}
