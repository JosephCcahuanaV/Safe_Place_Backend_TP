package Backendproject.serviceImpl;

import Backendproject.entities.UserSecurity;
import Backendproject.repositories.UserSecurityRepository;
import Backendproject.services.UsersecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityServiceImpl implements UsersecurityService {

    @Autowired
    UserSecurityRepository userSecurityRepository;

    @Override
    public UserSecurity save(UserSecurity user) {
        return userSecurityRepository.save(user);
    }
}
