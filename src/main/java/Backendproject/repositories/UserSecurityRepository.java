package Backendproject.repositories;

import Backendproject.entities.UserSecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {

    public UserSecurity findByUserName(String userName);

    @Query(value = "SELECT * FROM users WHERE userName=?1", nativeQuery = true)
    UserSecurity findByUserSQL(String userName);


    @Query(value = "SELECT * FROM users WHERE userType=?1", nativeQuery = true)
    List<UserSecurity> findByUserTypeSQL(String userType);

}
