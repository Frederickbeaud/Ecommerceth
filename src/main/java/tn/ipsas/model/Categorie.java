package tn.ipsas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Entity

//Annotations Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    @OneToMany (mappedBy = "categorie" ,cascade = {CascadeType.REMOVE,
            CascadeType.MERGE, CascadeType.PERSIST} )
    private Collection<Product> products;
}
