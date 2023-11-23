package Backendproject.repositories;


import Backendproject.entities.Authority;
import Backendproject.entities.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    public Authority findByName(AuthorityName name);
}
