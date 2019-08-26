package fr.solutec.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import fr.solutec.entities.BattleGroupe;
import fr.solutec.entities.Event;

public interface BattleGroupeRepository extends JpaRepository<BattleGroupe, Long>{
	public List<BattleGroupe> findByNom (String nom);
	
	public List<BattleGroupe> findByDateEventBefore (Date date); 
	public List<BattleGroupe> findByDateEventAfter (Date date);
	
	public List<BattleGroupe> getBattleGroupeByBarId (@PathVariable Long id);
	public List<BattleGroupe> getBattleGroupeByGenreNom (@PathVariable String nom);
	
	
	// public int length ();
	
}
