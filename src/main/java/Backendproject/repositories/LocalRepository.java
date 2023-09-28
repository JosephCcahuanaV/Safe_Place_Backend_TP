package Backendproject.repositories;

import Backendproject.entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalRepository extends JpaRepository<Local, Long> {

    //List<Local> findByNameContaining(String name);
}
