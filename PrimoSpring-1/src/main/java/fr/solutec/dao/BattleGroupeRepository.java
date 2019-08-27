package fr.solutec.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;


import fr.solutec.entities.BattleGroupe;


public interface BattleGroupeRepository extends JpaRepository<BattleGroupe, Long>{
	public List<BattleGroupe> findByNom (String nom);
	
	public List<BattleGroupe> findByDateEventBefore (Date date); 
	public List<BattleGroupe> findByDateEventAfter (Date date);
	
	// BY BAR 
	@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.bar b  WHERE b.id = ?1 ORDER BY bg.dateEvent DESC")
	public List<BattleGroupe> getBattleGroupeByBarId_Desc (@PathVariable Long id);
	@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.bar b  WHERE b.id = ?1 ORDER BY bg.dateEvent ASC")
	public List<BattleGroupe> getBattleGroupeByBarId_ASC (@PathVariable Long id);
	
	@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.bar b  WHERE b.nom = ?1 ORDER BY bg.dateEvent DESC")
	public List<BattleGroupe> getBattleGroupeByBarName_Desc (@PathVariable String nom);
	@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.bar b  WHERE b.nom = ?1 ORDER BY bg.dateEvent ASC")
	public List<BattleGroupe> getBattleGroupeByBarName_ASC (@PathVariable String nom);
	
	// BY Groupe 
	//@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.groupe g  WHERE g.id = ?1 ORDER BY bg.dateEvent DESC")
	//public List<BattleGroupe> getBattleGroupeByGroupeId_Desc (@PathVariable Long id);
	//@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.groupe g  WHERE g.id = ?1 ORDER BY bg.dateEvent ASC")
	//public List<BattleGroupe> getBattleGroupeByGroupeId_ASC (@PathVariable Long id);
	
	//@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.groupe g  WHERE g.nom = ?1 ORDER BY bg.dateEvent DESC")
	//public List<BattleGroupe> getBattleGroupeByGroupeName_Desc (@PathVariable String nom);
	//@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.groupe g  WHERE g.nom = ?1 ORDER BY bg.dateEvent ASC")
	//public List<BattleGroupe> getBattleGroupeByGroupeName_ASC (@PathVariable String nom);
	
	// BY GENRE
	@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.genre g  WHERE g.nom = ?1 ORDER BY bg.dateEvent DESC")
	public List<BattleGroupe> getBattleGroupeByGenreNom_Desc (@PathVariable String nom);
	@Query ("SELECT bg FROM BattleGroupe bg INNER JOIN bg.genre g  WHERE g.nom = ?1 ORDER BY bg.dateEvent ASC")
	public List<BattleGroupe> getBattleGroupeByGenreNom_ASC (@PathVariable String nom);
	
	


	
}
