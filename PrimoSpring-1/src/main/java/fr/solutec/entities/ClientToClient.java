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
	private Client ClientEnvoi;
	
	@ManyToOne
	private Client ClientRecu;
	
	
	private boolean accepted;	
	

	public ClientToClient() {
		super();
	}

	public ClientToClient(Client clientEnvoi, Client clientRecu, boolean accepted) {
		super();
		ClientEnvoi = clientEnvoi;
		ClientRecu = clientRecu;
		this.accepted = accepted;
	}

	public Client getClientEnvoi() {
		return ClientEnvoi;
	}

	public void setClientEnvoi(Client clientEnvoi) {
		ClientEnvoi = clientEnvoi;
	}

	public Client getClientRecu() {
		return ClientRecu;
	}

	public void setClientRecu(Client clientRecu) {
		ClientRecu = clientRecu;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	
	
	
	
	
	
}
