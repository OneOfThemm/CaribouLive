package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import fr.solutec.entities.BattleGroupe;
import fr.solutec.entities.Client;
import fr.solutec.entities.ComptVote;
import fr.solutec.entities.Vote;



public interface VoteRepository extends JpaRepository<Vote, Long>{
	public Vote findByClient (@PathVariable Client c);
	public List<Vote> findByBattlegroupe (@PathVariable BattleGroupe b);
	
	
	 @Query(value = "SELECT g.nom,count(v.groupe_id) FROM vote v INNER JOIN battle_groupe b ON v.battlegroupe_id = b.id INNER JOIN  groupe g ON g.id = v.groupe_id INNER JOIN groupe_inscription gi ON g.id = gi.groupe_id where b.id = ?1  GROUP BY v.groupe_id", nativeQuery = true)
	public List<Object> retourVote (Long id);
	
	// count(v.Groupe_id)

	//INNER JOIN g.GroupeInscription gi 
	// WHERE bg.id =?1
	//GROUP BY v.groupe_id
}
