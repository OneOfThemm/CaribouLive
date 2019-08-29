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
        this.client=client;
    }
}