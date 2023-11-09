package Backendproject.serviceImpl;

import Backendproject.dtos.UserSecurityDTO;
import Backendproject.entities.AuthorityName;
import Backendproject.entities.UserSecurity;
import Backendproject.exceptions.IncompleteDataException;
import Backendproject.exceptions.KeyRepeatedDataException;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.AuthorityRepository;
import Backendproject.repositories.UserSecurityRepository;
import Backendproject.services.UsersecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserSecurityServiceImpl implements UsersecurityService {

    @Autowired
    UserSecurityRepository userSecurityRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Override
    public UserSecurity findById(Long id) {
        UserSecurity userFound = userSecurityRepository.findById(id).orElse(null);
        if (userFound == null) {
            throw new ResourceNotFoundException("There are no User with the id: "+String.valueOf(id));
        }
        return userFound;
    }
    @Override
    public UserSecurity register(UserSecurityDTO user) {

        if (user.getUserName().length()>4 && user.getPassword().length()>4) {

            UserSecurity userFound = userSecurityRepository.findByUserName(user.getUserName());
            if (userFound != null) {
                throw new KeyRepeatedDataException("User name can not be duplicated");
            };

            UserSecurity newUser = new UserSecurity();
            newUser.setUserName(user.getUserName());
            newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            newUser.setEnabled(true);
            newUser.setPasswordLastUpdate(new Date());
            AuthorityName authorityName=AuthorityName.ROLE_CLIENT;
            if (user.getType().equals("ROLE_CLIENT")) authorityName= AuthorityName.ROLE_CLIENT;
            if (user.getType().equals("ROLE_PRINCIPAL")) authorityName= AuthorityName.ROLE_PRINCIPAL;
            newUser.setAuthorities(
                    List.of(
                            authorityRepository.findByName(authorityName)
                    )
            );

            return userSecurityRepository.save(newUser);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }

    @Override
    public UserSecurity changePassword(UserSecurityDTO user) {
        if (user.getUserName().length()>4 && user.getPassword().length()>4) {

            UserSecurity userFound = userSecurityRepository.findByUserName(user.getUserName());
            if (userFound == null) {
                throw new ResourceNotFoundException("User name can not be found");
            };

            userFound.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userFound.setPasswordLastUpdate(new Date());
            return userSecurityRepository.save(userFound);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }


}
