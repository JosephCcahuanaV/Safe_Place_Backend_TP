package Backendproject.repositories;

import Backendproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    //List<User> findByNameContaining(String username);
    public User findByUserName(String userName);
}
