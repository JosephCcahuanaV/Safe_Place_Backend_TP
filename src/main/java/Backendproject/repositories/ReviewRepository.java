package Backendproject.repositories;


import Backendproject.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    /*NUEVOO




    @Query(value="SELECT * FROM reviews WHERE client_Id=?1", nativeQuery = true)
    List<Review> findByUsuario_Id (Long id);
*/
    //NI IDEA List<Review> deleteAllByInmueble_Id (Long id);

}
