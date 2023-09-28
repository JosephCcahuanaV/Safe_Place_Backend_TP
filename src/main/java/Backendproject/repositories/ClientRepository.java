package Backendproject.repositories;

import Backendproject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNameContaining(String name);
}
