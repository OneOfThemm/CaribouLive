package fr.solutec.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClientToClient {
	
	@Id @GeneratedValue
	protected Long id;
	
	@ManyToOne
	private Client clientEnvoi;
	
	@ManyToOne
	private Client clientRecu;
	
	
	private boolean accepted;	
	

	public ClientToClient() {
		super();
	}

	public ClientToClient(Client clientEnvoi, Client clientRecu, boolean accepted) {
		super();
		this.clientEnvoi = clientEnvoi;
		this.clientRecu = clientRecu;
		this.accepted = accepted;
	}

	public Client getClientEnvoi() {
		return clientEnvoi;
	}

	public void setClientEnvoi(Client clientEnvoi) {
		this.clientEnvoi = clientEnvoi;
	}

	public Client getClientRecu() {
		return clientRecu;
	}

	public void setClientRecu(Client clientRecu) {
		this.clientRecu = clientRecu;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	
	
	
	
	
	
}
