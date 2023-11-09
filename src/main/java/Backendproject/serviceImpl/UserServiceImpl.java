package Backendproject.serviceImpl;

import Backendproject.dtos.UserDTO;
import Backendproject.entities.*;
import Backendproject.exceptions.IncompleteDataException;
import Backendproject.exceptions.KeyRepeatedDataException;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.AuthorityRepository;
import Backendproject.repositories.UserRepository;
import Backendproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    AuthorityRepository authorityRepository;
    @Override
    public List<User> listAll() {
        List<User> users=userRepository.findAll();
        return users;
    }
    @Override
    public User findById(Long id){
        User userFound = userRepository.findById(id).orElse(null);
        if (userFound == null) {
            throw new ResourceNotFoundException("There are no user with the id: "+String.valueOf(id));
        }

        return userFound;
    }


    @Override
    public User registerUser(UserDTO user) {

        if(user.getUserName().length()>4 && user.getPassword().length()>4){

            User userFound=userRepository.findByUserName(user.getUserName());

            if (user.getUserName()==null || user.getUserName().isEmpty()) {
                throw new IncompleteDataException("Name can not be null or empty");

            } else if(userFound!=null){
                throw new KeyRepeatedDataException("User can not be duplicated");
            };

            User newUser=new User();
            newUser.setUsername(user.getUserName());
            newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            newUser.setIs_active(true);
            newUser.setExpirityDay(new Date());
            AuthorityName authorityName=AuthorityName.ROLE_CLIENT;
            if(user.getType().equals("ROLE_CLIENT")) authorityName=AuthorityName.ROLE_CLIENT;
            if(user.getType().equals("ROLE_RENDER")) authorityName=AuthorityName.ROLE_RENDER;
            if(user.getType().equals("ROLE_PRINCIPAL")) authorityName=AuthorityName.ROLE_PRINCIPAL;
            newUser.setAuthorities(
                    List.of(
                            authorityRepository.findByName(authorityName)
                    )
            );

            return userRepository.save(newUser);

        } else{
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }


    }

    @Override
    public User changePassword(UserDTO user) {
        if(user.getUserName().length()>4 && user.getPassword().length()>4){

            User userFound=userRepository.findByUserName(user.getUserName());

            if(userFound==null){
                throw new ResourceNotFoundException("User name can not be found");
            };
            userFound.setPassword(new SCryptPasswordEncoder().encode(user.getPassword()));
            userFound.setExpirityDay(new Date());
            return userRepository.save(userFound);

        } else{
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }

    @Override
    public void delete(Long id){
        User user=findById(id);
        userRepository.delete(user);
    }




}
