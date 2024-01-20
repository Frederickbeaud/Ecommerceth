package tn.ipsas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.ipsas.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByLibelleLike(String mc, Pageable pageable);
}
