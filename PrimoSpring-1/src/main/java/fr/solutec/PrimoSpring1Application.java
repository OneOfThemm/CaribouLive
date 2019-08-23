package fr.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.dao.ClientRepository;
import fr.solutec.dao.GroupeRepository;
import fr.solutec.entities.Client;
import fr.solutec.entities.Groupe;

@SpringBootApplication
public class PrimoSpring1Application implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private GroupeRepository groupeRepo;

	public static void main(String[] args) {
		SpringApplication.run(PrimoSpring1Application.class, args);

	}
	
	@Override
	public void run(String... args) throws Exception {
		//new Client (String nom,String mdp,String mail)
		clientRepo.save(new Client("Thomas Shelby", "peaky", "thomas@peakyBlinder.com" ));
		clientRepo.save(new Client("Arthur Shelby Junior", "blinder", "arthur.jr@peakyBlinder.com" ));
		clientRepo.save(new Client("Olivia Pope", "scandal", "olivia.pope@pope.com" ));
		clientRepo.save(new Client("Fitzgerald Grant", "president", "fitz.grant@maisonblanche.com" ));
		//clientRepo.save(new Client("Fitzgerald Grant", "president", "fitz.grant@maisonblanche.com" ));
		
		
		groupeRepo.save(new Groupe("Super Caribou", "caribou", "Le meilleur groupe de tous les temps",200,"caribou@caribou.fr"));
		groupeRepo.save(new Groupe("Marc Lavoine", "mlavoine", "les yeux revolver",185,"marcL@yahoo.fr"));
		groupeRepo.save(new Groupe("Gerard Lenorman", "ballade", "La ballade des gens heureux 1976",197.6,"maitre@gims.fr"));
		groupeRepo.save(new Groupe("MPokora", "mathieu", "Vive Robin des bois",1500,"mathieuPokora@hotmail.fr"));
		groupeRepo.save(new Groupe("Bigflo & Oli", "mdp", "Bigflo & Oli remportent le prix Album de musiques urbaines (La vie de rêve) & Artiste masculin",800,"bigflo.Oli@hotmail.fr"));
		groupeRepo.save(new Groupe("Les enfoires", "coluche", "Les Enfoirés est un regroupement d'artistes et personnalités publiques (principalement francophones) créé en 1985 pour chanter au profit de l'association caritative des Restos du Cœur, créé par Coluche.",1705.95,"enfoires@restocoeur.fr"));

	
	}
	
	

}
