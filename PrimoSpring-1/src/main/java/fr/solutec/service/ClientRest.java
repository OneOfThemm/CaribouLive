package fr.solutec.service;

import java.io.Console;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import fr.solutec.dao.ClientRepository;
import fr.solutec.entities.Client;


@RestController
@CrossOrigin("*")

public class ClientRest {
	@Autowired
	private ClientRepository clientRepo;

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> getAll() {
		return clientRepo.findAll();
	}

	@RequestMapping(value = "/client/id/{id}", method = RequestMethod.GET)
	public Client getClientById(@PathVariable Long id) {
		return clientRepo.findById(id);
	}
	
	@RequestMapping(value = "/client/name/{name}", method = RequestMethod.GET)
	public List<Client> getClientByName(@PathVariable String name) {
		return clientRepo.findByNom(name);
	}

	@RequestMapping(value = "/client/mail/{email:.+}", method = RequestMethod.GET)
	public Client getClientByMail(@PathVariable String email) {
		return clientRepo.findByMail(email);
	} 	
	
	@RequestMapping(value="/mail/{mail}", method=RequestMethod.GET) // Methode à l'arrache
	public Client getRappelsNew(String mail) throws ParseException{
		
		Client c= new Client();
		c= null;	
		
		List<Client> listcli = new ArrayList<Client>();
		listcli = clientRepo.findAll();			
		
		for (Client client : listcli) {
			if (client.getMail().equals(mail)) {
				c=client;
			
				System.out.println(c.toString());
			}
	
		}
		return c;
	}
	
	

}
