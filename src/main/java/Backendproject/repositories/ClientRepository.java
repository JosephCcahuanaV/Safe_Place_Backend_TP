package Backendproject.repositories;

import Backendproject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT * FROM clients ORDER BY age DESC LIMIT 1", nativeQuery = true)
    Client findOldestClient();
    List<Client> findByNameContaining(String name);
}
