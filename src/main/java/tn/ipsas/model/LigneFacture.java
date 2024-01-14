package tn.ipsas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LigneFacture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long produitID;
    private long quantity;
    private double price;
    @Transient
    private Product produit;

    @ManyToOne
    private Facture facture;
}
