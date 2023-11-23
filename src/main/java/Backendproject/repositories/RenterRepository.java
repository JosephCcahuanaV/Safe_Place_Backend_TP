package Backendproject.repositories;

import Backendproject.entities.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RenterRepository extends JpaRepository<Renter, Long> {

    Renter findByName(String name);
    @Query("SELECT r.nacionality as nacionality, COUNT(r) as count FROM Renter r GROUP BY r.nacionality")
    List<Object[]> countRentersByNationality();
}
