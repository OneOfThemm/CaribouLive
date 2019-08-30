package fr.solutec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;


@AllArgsConstructor@Data@NoArgsConstructor@ToString@Entity
public class ImageModel {
	
    @Id@GeneratedValue
    private Long id;
    
    private String name;
    private String type;
    @Lob
    private byte[] pic;
    
    @OneToOne
    private Client client;
    

//Custom Constructor
    public ImageModel(String name, String type, byte[] pic, Client client) {
        this.name = name;
        this.type = type;
        this.pic = pic;
        this.client = client;
        
    }
    public ImageModel() {
       
        
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}