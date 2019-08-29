package fr.solutec.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.BattleGroupeRepository;
import fr.solutec.dao.ClientRepository;
import fr.solutec.dao.GroupeInscriptionRepository;
import fr.solutec.dao.GroupeRepository;
import fr.solutec.dao.VoteRepository;
import fr.solutec.entities.BattleGroupe;
import fr.solutec.entities.Client;
import fr.solutec.entities.ClientToClient;
import fr.solutec.entities.Groupe;
import fr.solutec.entities.GroupeInscription;
import fr.solutec.entities.Vote;

@RestController
@CrossOrigin("*")
public class VoteRest {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private GroupeRepository groupeRepo;	
	@Autowired
	private GroupeInscriptionRepository groupeInscRepos;
	@Autowired
	private BattleGroupeRepository bgRepos;
	@Autowired 
	private VoteRepository voteRepo;
	

	//Fonction qui récupère tous les votes d'un évennement BATTLEGROUPE via son ID
	
	@RequestMapping(value = "/votes/battlegroupe/{id}", method = RequestMethod.GET)	
	public List<Vote> getAllVoteOfBattleGroupe(@PathVariable Long id) {		
		//On récupère la battlegroupe grâce à l'ID de la requette
		BattleGroupe bg;
		bg =  bgRepos.findOne(id);
		List<Vote> votesBG = new ArrayList<Vote>(voteRepo.findByBattlegroupe(bg));
		return votesBG;		
	}
	
	
	//Fonction qui crée un vote à partir de trois IDs :IDCLIENT/IDGROUPE/IDBATTLEGROUPE
	
	@RequestMapping(value = "/votes/battlegroupe/{idClient}/{idGroupe}/{idBg}", method = RequestMethod.POST)	
	public void SetVote(@PathVariable Long idClient ,@PathVariable Long idGroupe,@PathVariable Long idBg) {
		boolean doublon = false;
		BattleGroupe bg;
		Client c;
		Groupe g;
				
		//On récupère Le client, le groupe et l'évennement concerné grâces aux repos.
		c = clientRepo.findById(idClient);
		bg =  bgRepos.findOne(idBg);
		g = groupeRepo.findOne(idGroupe);
		
		// On associe les infos précédentes au vote 
		Vote v = new Vote(c, g, bg);
		
		//On va chercher à savoir si le client à déjà voté pour cet évennement, auquel cas on doit refuser le vote
		//On récupère les votes déjà existants pour cet évennement
		List<Vote> votesBG = new ArrayList<Vote>(voteRepo.findByBattlegroupe(bg));
		
		//On parcourt la liste de ces votes et si on trouve l'id du client qui à voté => on annule le vote
		for (Vote vote : votesBG) {
			if(v.getClient().getId() == vote.getClient().getId()) {
				doublon = true;
			}
		}			
		if(doublon == false)	{
			voteRepo.save(v);
		}
	}
	
	
	// FONCTION QUI CHANGE LE VOTE D'UN USER POUR UN NOUVEAUGROUPE A UN EVENT DONNÉ
	@RequestMapping(value = "/votes/modifier/battlegroupe/{idClient}/{idGroupe}/{idBg}", method = RequestMethod.PUT)	
	public void ChangeVote(@PathVariable Long idClient ,@PathVariable Long idGroupe,@PathVariable Long idBg) {
		BattleGroupe bg;
		Client c;
		Groupe g;
				
		//On récupère Le client, le groupe et l'évennement concerné grâces aux repos.
		c = clientRepo.findById(idClient);
		bg =  bgRepos.findOne(idBg);
		g = groupeRepo.findOne(idGroupe);
		
		// On associe les infos précédentes au vote 
		Vote v = new Vote(c, g, bg);
		
		//On va chercher à savoir si le client à déjà voté pour cet évennement, auquel cas on doit refuser le vote
		//On récupère les votes déjà existants pour cet évennement
		List<Vote> votesBG = new ArrayList<Vote>(voteRepo.findByBattlegroupe(bg));
		
		//On parcourt la liste de ces votes et si on trouve l'id du client qui à voté => on annule le vote
		for (Vote vote : votesBG) {
			if(v.getClient().getId() == vote.getClient().getId()) {
				v = vote;
				v.setGroupe(g);
				voteRepo.save(v);				
			}
		}			
	
	}
	
	// FONCTION QUI CHANGE LE VOTE D'UN USER POUR UN NOUVEAUGROUPE A UN EVENT DONNÉ
		@RequestMapping(value = "/votes/delete/battlegroupe/{idClient}/{idBg}", method = RequestMethod.DELETE)	
		public void DeleteVote(@PathVariable Long idClient, @PathVariable Long idBg) {			
			BattleGroupe bg;
			Client c;
					
			//On récupère Le client, le groupe et l'évennement concerné grâces aux repos.
			c = clientRepo.findById(idClient);
			bg =  bgRepos.findOne(idBg);	
			
			// On associe les infos précédentes au vote 
			Vote v = new Vote();
			v.setClient(c);
			v.setBattlgroupe(bg);
			
			//On va chercher à savoir si le client à déjà voté pour cet évennement, auquel cas on doit refuser le vote
			//On récupère les votes déjà existants pour cet évennement
			List<Vote> votesBG = new ArrayList<Vote>(voteRepo.findByBattlegroupe(bg));			
			//On parcourt la liste de ces votes et si on trouve l'id du client qui à voté => on annule le vote
			for (Vote vote : votesBG) {
				if(v.getClient().getId() == vote.getClient().getId()) {				
					voteRepo.delete(vote.getId());		
				}
			}		
		}
	
	//Fonction qui récupère le nombre de vote d'un groupe en fonction du groupe et de l'event
	
		@RequestMapping(value = "/votes/battlegroupe/{idBG}/groupe/{idGroupe}", method = RequestMethod.GET)	
		public int nbVoteByGroup(@PathVariable Long idGroupe,@PathVariable Long idBG) {		
			//On récupère la battlegroupe grâce à l'ID de la requette
			BattleGroupe bg;
			bg =  bgRepos.findOne(idBG);
			Groupe g;
			g = groupeRepo.findOne(idGroupe);			
			int nbVotes = 0;			
			List<Vote> votesBG = new ArrayList<Vote>(voteRepo.findByBattlegroupe(bg));
			for (Vote vote : votesBG) {
				if(vote.getGroupe().getId() == g.getId()) {
					nbVotes ++;
				}
			}			
			return nbVotes;		
		}	
}
	