package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import fr.solutec.entities.BattleGroupe;
import fr.solutec.entities.Client;
import fr.solutec.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long>{
	public Vote findByClient (@PathVariable Client c);
	public List<Vote> findByBattlegroupe (@PathVariable BattleGroupe b);	

}
