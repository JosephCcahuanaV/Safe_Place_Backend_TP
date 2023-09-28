package Backendproject.repositories;

import Backendproject.entities.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RenterRepository extends JpaRepository<Renter, Long> {

    //List<Renter> findByNameContaining(String name);
}
