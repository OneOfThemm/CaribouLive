package fr.solutec.service;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.ClientRepository;
import fr.solutec.dao.ClientToClientRepository;
import fr.solutec.entities.Client;
import fr.solutec.entities.ClientToClient;

@RestController
@CrossOrigin("*")

public class ClientToClientRest {
	@Autowired
	private ClientToClientRepository clientToClientRepo;
	@Autowired
	private ClientRepository clientRepo;

	@RequestMapping(value = "/amis", method = RequestMethod.GET)
	public List<ClientToClient> getAll() {
		return clientToClientRepo.findAll();
	}

	@RequestMapping(value = "/mesamis/{id}", method = RequestMethod.GET)
	public List<Client> getMesAmis(@PathVariable Long id) {
		List<ClientToClient> listAmities = clientToClientRepo.findByClientEnvoiId(id);
		List<Client> amis = new ArrayList<Client>();

		for (ClientToClient amitie : listAmities) {
			if (amitie.isAccepted()) {
				amis.add(amitie.getClientRecu());
			}
		}

		listAmities = clientToClientRepo.findByClientRecuId(id);
		for (ClientToClient amitie : listAmities) {
			if (amitie.isAccepted()) {
				amis.add(amitie.getClientEnvoi());
			}
		}

		for (Client client : amis) {
			client.setMdp(null);
		}

		return amis;
	}
	
	
	@RequestMapping(value = "/mesamis/attente/{id}", method = RequestMethod.GET)
	public List<Client> getMesAmisEnAttente(@PathVariable Long id) {
		List<ClientToClient> listAmities = clientToClientRepo.findByClientEnvoiId(id);
		List<Client> amis = new ArrayList<Client>();

		for (ClientToClient amitie : listAmities) {
			if (!amitie.isAccepted()) {
				amis.add(amitie.getClientRecu());
			}
		}

		listAmities = clientToClientRepo.findByClientRecuId(id);
		for (ClientToClient amitie : listAmities) {
			if (!amitie.isAccepted()) {
				amis.add(amitie.getClientEnvoi());
			}
		}

		for (Client client : amis) {
			client.setMdp(null);
		}

		return amis;
	}

	
	//cette fonction récupere deux id client et supprime l'amitié qui existe entre eux si elle existe.
	
	@RequestMapping(value = "/friend/delete/{id1}/{id2}", method = RequestMethod.DELETE)
	public void deleteThisFriend(@PathVariable Long id1, @PathVariable Long id2) {
		ClientToClient amitie = new ClientToClient();

		List<ClientToClient> amities = clientToClientRepo.findAll();

		for (ClientToClient amis : amities) {

			if ((amis.getClientEnvoi().getId() == id1) && (amis.getClientRecu().getId() == id2)
					|| (amis.getClientEnvoi().getId() == id2) && (amis.getClientRecu().getId() == id1)) {
				amitie = amis;
			}
		}
		
		
		clientToClientRepo.deleteById(amitie.getId());
	}
}
