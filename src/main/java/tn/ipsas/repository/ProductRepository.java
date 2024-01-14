package tn.ipsas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ipsas.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
