package Backendproject.repositories;

import Backendproject.entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalRepository extends JpaRepository<Local, Long> {

    //List<Local> findByNameContaining(String name);

    @Query(value = "SELECT COUNT(*) FROM locals", nativeQuery = true)
    Integer countAllLocals();

    @Query(value = "SELECT * FROM local ORDER BY price DESC LIMIT 1", nativeQuery = true)
    Local findMostExpensiveLocal();


    @Query(value = "SELECT price FROM local WHERE id = :id", nativeQuery = true)
    Double findPriceOfWeeklyRentalById(Long id);
}
