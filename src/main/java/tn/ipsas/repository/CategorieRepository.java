package tn.ipsas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ipsas.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
