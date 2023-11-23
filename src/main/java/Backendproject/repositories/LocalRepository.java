package Backendproject.repositories;

import Backendproject.entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface LocalRepository extends JpaRepository<Local, Long> {

    @Query(value = "SELECT COUNT(*) FROM locals", nativeQuery = true)
    Integer countAllLocals();

    @Query("SELECT l FROM Local l WHERE l.price = (SELECT MAX(l2.price) FROM Local l2)")
    Local findLocalWithHighestPrice();


    @Query(value = "SELECT price FROM local WHERE id = :id", nativeQuery = true)
    Double findPriceOfWeeklyRentalById(Long id);

    @Query(value = "SELECT id, name, price * 1.18 as priceWithIgv FROM locals WHERE id = ?1", nativeQuery = true)
    Map<String, Object> findLocalByIdWithPriceIncludingIgv(Long id);
}
