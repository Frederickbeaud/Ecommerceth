package tn.ipsas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ipsas.model.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
