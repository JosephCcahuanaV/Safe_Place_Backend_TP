package Backendproject.serviceImpl;

import Backendproject.entities.UserSecurity;
import Backendproject.repositories.UserSecurityRepository;
import Backendproject.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserSecurityRepository userSecurityRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSecurity user = userSecurityRepository.findByUserName(username);
        if (user !=null) {
            return new SecurityUser(user);
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
