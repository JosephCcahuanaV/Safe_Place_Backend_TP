package Backendproject.repositories;

import Backendproject.dtos.ClientDTO;
import Backendproject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByName(String name);
    @Query(value = "SELECT * FROM clients ORDER BY age DESC LIMIT 1", nativeQuery = true)
    Client findOldestClient();
    List<Client> findByNameContaining(String name);

    @Query(value = "SELECT c.nationality, COUNT(c.id) as cantidad_clientes FROM clients c GROUP BY c.nationality", nativeQuery = true)
    List<Object[]> countClientsByNationality();
}
