package Backendproject.repositories;

import Backendproject.entities.UserSecurity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {

    public UserSecurity findByUserName(String userName);

}
