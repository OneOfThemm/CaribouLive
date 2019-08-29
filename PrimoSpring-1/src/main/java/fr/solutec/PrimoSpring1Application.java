package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.dao.BarRepository;
import fr.solutec.dao.BattleGroupeRepository;
import fr.solutec.dao.ClientRepository;
import fr.solutec.dao.ClientToClientRepository;
import fr.solutec.dao.GenreRepository;
import fr.solutec.dao.GroupeInscriptionRepository;
import fr.solutec.dao.GroupeRepository;
import fr.solutec.dao.VoteRepository;
import fr.solutec.entities.Bar;
import fr.solutec.entities.BattleGroupe;
import fr.solutec.entities.Client;
import fr.solutec.entities.ClientToClient;
import fr.solutec.entities.Genre;
import fr.solutec.entities.Groupe;
import fr.solutec.entities.GroupeInscription;
import fr.solutec.entities.Vote;

@SpringBootApplication
public class PrimoSpring1Application implements CommandLineRunner {
	@Autowired
	private BarRepository barRepo;	
	@Autowired
	private ClientRepository clientRepo;	
	@Autowired
	private GroupeRepository groupeRepo;	
	@Autowired
	private GenreRepository genreRepo;	
	@Autowired
	private BattleGroupeRepository battleGroupRepo;	
	@Autowired
	private ClientToClientRepository clientToClientRepo;	
	@Autowired
	private VoteRepository voteRepo;
	@Autowired GroupeInscriptionRepository groupeInscRepo;


	public static void main(String[] args) {
		SpringApplication.run(PrimoSpring1Application.class, args);

	}
	
	@Override
	public void run(String... args) throws Exception {
		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		// new Bar (String nom, String mdp,String nomGerant, String tel, String mail, int capacitemax)
		
		Bar bar1 = new Bar("Esic", "paris550", "Joel B", "0153901520", "info@esic.fr", 50);
		Bar bar2 = new Bar("BREIZH CAFÉ", "bzh", "Les bretons", "0142339778", "breihcafe@bar.bzh", 200);
		Bar bar3 = new Bar("Olympia", "capucines", "Vivendi", "06 44 64 90 21", "olympia@bar.fr", 1772);
		
		barRepo.save(bar1);
		barRepo.save(bar2);
		barRepo.save(bar3);	
		
		//new Client (String nom,String mdp,String mail)
		Client c1 = new Client("Thomas Shelby", "peaky", "thomaspeakyBlindercom" );
		Client c2 =new Client("Arthur Shelby Junior", "blinder", "arthur.jr@peakyBlinder.com" );
		Client c3 =new Client("Olivia Pope", "scandal", "olivia.pope@pope.com" );
		Client c4 =new Client("Fitzgerald Grant", "president", "fitz.grant@maisonblanche.com" );
		Client c5 =new Client("Abby Whelan", "redhair", "awhelan@pope.com" );
		Client c6 =new Client("David Rosen", "justice", "dr.procureur@justice.com" );
		Client c7 =new Client("Cyrus Beene", "power", "cyrusBeene@maisonblanche.com" );
		
		clientRepo.save(c1);
		clientRepo.save(c2);
		clientRepo.save(c3);
		clientRepo.save(c4);
		clientRepo.save(c5);
		clientRepo.save(c6);
		clientRepo.save(c7);
		
		
		
		
		//new Relation d'amitié (Client, Clien, boolean)
		clientToClientRepo.save(new ClientToClient(c1,c2,true));
		clientToClientRepo.save(new ClientToClient(c1,c3,true));
		clientToClientRepo.save(new ClientToClient(c1,c4,true));	
		clientToClientRepo.save(new ClientToClient(c1,c5,false));
		clientToClientRepo.save(new ClientToClient(c3,c5,false));
		clientToClientRepo.save(new ClientToClient(c4,c5,false));
		clientToClientRepo.save(new ClientToClient(c6,c5,false));
		clientToClientRepo.save(new ClientToClient(c7,c5,false));		
		clientToClientRepo.save(new ClientToClient(c5,c2,true));
	
		
		
		// Genre(String nom)
		genreRepo.save(new Genre ("blues"));
		genreRepo.save(new Genre ("disco"));
		genreRepo.save(new Genre ("funck"));
		genreRepo.save(new Genre ("rap"));
		genreRepo.save(new Genre ("country"));
		genreRepo.save(new Genre ("folk"));
		genreRepo.save(new Genre ("jazz"));
		genreRepo.save(new Genre ("soul"));
		genreRepo.save(new Genre ("raï"));
		genreRepo.save(new Genre ("reggae"));
		genreRepo.save(new Genre ("salsa"));
		genreRepo.save(new Genre ("techno"));
		
		
		Groupe g1 = new Groupe ("Super Caribou", "caribou", "Le meilleur groupe de tous les temps",200,"caribou@caribou.fr");
		Groupe g2 = new Groupe ("Marc Lavoine", "mlavoine", "les yeux revolver",185,"marcL@yahoo.fr");
		Groupe g3 = new Groupe ("Gerard Lenorman", "ballade", "La ballade des gens heureux 1976",197.6,"maitre@gims.fr");
		Groupe g4 = new Groupe ("MPokora", "mathieu", "Vive Robin des bois",1500,"mathieuPokora@hotmail.fr");
		Groupe g5 = new Groupe ("Bigflo & Oli", "mdp", "Bigflo & Oli remportent le prix Album de musiques urbaines (La vie de rêve) & Artiste masculin",800,"bigflo.Oli@hotmail.fr");
		Groupe g6 = new Groupe ("Les enfoires", "coluche", "Les Enfoirés est un regroupement d'artistes et personnalités publiques (principalement francophones) créé en 1985 pour chanter au profit de l'association caritative des Restos du Cœur, créé par Coluche.",1705.95,"enfoires@restocoeur.fr");
		
		
		groupeRepo.save(g1);
		groupeRepo.save(g2);
		groupeRepo.save(g3);
		groupeRepo.save(g4);
		groupeRepo.save(g5);
		groupeRepo.save(g6);

		
		
		
		Genre genre1 = new Genre("rock");
		genreRepo.save(genre1);
		
	//	Date date = new Date();
		
		BattleGroupe b = new BattleGroupe(d.parse("14/07/2019"),"test","testtesttesttesttest",1000,10,5);
		b.setBar(bar1);
		b.setGenre(genre1);
		
		battleGroupRepo.save(b);
		
		BattleGroupe b2 = new BattleGroupe(d.parse("20/09/2019"),"aaa","aaaaaaaaaaaaaa",300,8,5);
		b2.setBar(bar1);
		b2.setGenre(genre1);
		
		battleGroupRepo.save(b2);
		
		BattleGroupe b3 = new BattleGroupe(d.parse("20/12/2019"),"bbb","bbbbbbbbbb",900,15,10);
		b3.setBar(bar1);
		b3.setGenre(genre1);
		
		battleGroupRepo.save(b3);	
		
		BattleGroupe b4 = new BattleGroupe(d.parse("20/01/2019"),"Rock'Esic","Dernier concert pour retourner l'esic",700,5,12);
		b4.setBar(bar1);
		b4.setGenre(genre1);	
		b4.setVisibleClient(true);		
		battleGroupRepo.save(b4);		
		
		
		GroupeInscription groupeInsc1 = new GroupeInscription(g1,b4,false);
		GroupeInscription groupeInsc2 = new GroupeInscription(g2,b4,false);
		GroupeInscription groupeInsc3 = new GroupeInscription(g6,b4,false);
		
		groupeInscRepo.save(groupeInsc1);
		groupeInscRepo.save(groupeInsc2);
		groupeInscRepo.save(groupeInsc3);
		
		Vote v1 = new Vote(c1, g1, b4 );
		Vote v2 = new Vote(c2, g1, b4 );
		Vote v3 = new Vote(c3, g1, b4 );
		Vote v4 = new Vote(c4, g2, b4 );
		Vote v5 = new Vote(c5, g2, b4 );
		Vote v6 = new Vote(c6, g6, b4 );
		Vote v7 = new Vote(c7, g6, b4 );

		voteRepo.save(v1);	
		voteRepo.save(v2);	
		voteRepo.save(v3);	
		voteRepo.save(v4);	
		voteRepo.save(v5);	
		voteRepo.save(v6);	
		voteRepo.save(v7);	
		}
}
