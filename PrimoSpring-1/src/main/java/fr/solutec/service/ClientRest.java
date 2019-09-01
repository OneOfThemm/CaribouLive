package fr.solutec.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.solutec.dao.ClientRepository;
import fr.solutec.entities.Bar;
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
	
	@RequestMapping(value = "/addclient", method = RequestMethod.POST)
	public Client save(@RequestBody Client c){
		return clientRepo.save(c);
	}
	
	@RequestMapping(value = "/clientedit", method = RequestMethod.POST)
	public Client updateClient(@RequestBody Client client) {
		Long i = client.getId();
		Client c = clientRepo.findById(i);
		c = clientRepo.save(client);
		return c;
	}
	
}
