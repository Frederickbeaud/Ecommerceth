package tn.ipsas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ipsas.model.LigneFacture;

public interface LigneFactureRepository extends JpaRepository<LigneFacture,Long> {
}
