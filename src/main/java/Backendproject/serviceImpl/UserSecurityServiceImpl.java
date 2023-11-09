package Backendproject.serviceImpl;

import Backendproject.dtos.UserDTO;
import Backendproject.entities.AuthorityName;
import Backendproject.entities.User;
import Backendproject.entities.UserSecurity;
import Backendproject.exceptions.IncompleteDataException;
import Backendproject.exceptions.KeyRepeatedDataException;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.AuthorityRepository;
import Backendproject.repositories.UserRepository;
import Backendproject.repositories.UserSecurityRepository;
import Backendproject.services.UsersecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserSecurityServiceImpl implements UsersecurityService {

    @Autowired
    UserSecurityRepository userSecurityRepository;
    AuthorityRepository authorityRepository;
    @Override
    public List<UserSecurity> listAll() {
        List<UserSecurity> users=userSecurityRepository.findAll();
        return users;
    }
    @Override
    public UserSecurity findById(Long id){
        UserSecurity userFound = userSecurityRepository.findById(id).orElse(null);
        if (userFound == null) {
            throw new ResourceNotFoundException("There are no user with the id: "+String.valueOf(id));
        }

        return userFound;
    }


    @Override
    public UserSecurity registerUser(UserDTO user) {

        if(user.getUserName().length()>4 && user.getPassword().length()>4){

            UserSecurity userFound=userSecurityRepository.findByUserName(user.getUserName());

            if (user.getUserName()==null || user.getUserName().isEmpty()) {
                throw new IncompleteDataException("Name can not be null or empty");

            } else if(userFound!=null){
                throw new KeyRepeatedDataException("User can not be duplicated");
            };

            UserSecurity newUser=new UserSecurity();
            newUser.setUserName(user.getUserName());
            newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            newUser.setEnabled(true);
            newUser.setPasswordLastUpdate(new Date());
            AuthorityName authorityName=AuthorityName.ROLE_CLIENT;
            if(user.getType().equals("ROLE_CLIENT")) authorityName=AuthorityName.ROLE_CLIENT;
            if(user.getType().equals("ROLE_RENDER")) authorityName=AuthorityName.ROLE_RENDER;
            if(user.getType().equals("ROLE_PRINCIPAL")) authorityName=AuthorityName.ROLE_PRINCIPAL;
            newUser.setAuthorities(
                    List.of(
                            authorityRepository.findByName(authorityName)
                    )
            );

            return userSecurityRepository.save(newUser);

        } else{
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }


    }

    @Override
    public UserSecurity changePassword(UserDTO user) {
        if(user.getUserName().length()>4 && user.getPassword().length()>4){

            UserSecurity userFound=userSecurityRepository.findByUserName(user.getUserName());

            if(userFound==null){
                throw new ResourceNotFoundException("User name can not be found");
            };
            userFound.setPassword(new SCryptPasswordEncoder().encode(user.getPassword()));
            userFound.setPasswordLastUpdate(new Date());
            return userSecurityRepository.save(userFound);

        } else{
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }

    @Override
    public void delete(Long id){
        UserSecurity user=findById(id);
        userSecurityRepository.delete(user);
    }






}
