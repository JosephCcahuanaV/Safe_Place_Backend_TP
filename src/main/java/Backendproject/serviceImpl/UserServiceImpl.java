package Backendproject.serviceImpl;

import Backendproject.entities.TypeLocal;
import Backendproject.entities.User;
import Backendproject.repositories.UserRepository;
import Backendproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> listAll() {
        List<User> users=userRepository.findAll();
        return users;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id){
        User user=findById(id);
        userRepository.delete(user);
    }

    @Override
    public User findById(Long id){
        User userFound = userRepository.findById(id).orElse(null);
        return userFound;
    }


}
