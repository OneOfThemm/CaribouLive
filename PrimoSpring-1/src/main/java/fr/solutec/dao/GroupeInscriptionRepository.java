package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.BattleGroupe;
import fr.solutec.entities.GroupeInscription;


public interface GroupeInscriptionRepository extends JpaRepository<GroupeInscription, Long>{
	public GroupeInscription findById(Long id);
	public List<GroupeInscription> findByEventId(Long id);
	public List<GroupeInscription> findByGroupeId(Long id);
}
