package tn.ipsas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ipsas.model.Client;

import java.util.Optional;

public interface ClientReposirory extends JpaRepository<Client,Long> {
    Optional findByEmail(String email);
}
