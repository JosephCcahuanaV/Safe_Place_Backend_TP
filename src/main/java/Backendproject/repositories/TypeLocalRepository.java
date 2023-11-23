package Backendproject.repositories;


import Backendproject.entities.TypeLocal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeLocalRepository extends JpaRepository<TypeLocal, Long> {

    //<TypeLocal> findByNameContaining(String name);
}
