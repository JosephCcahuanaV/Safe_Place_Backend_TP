package Backendproject.serviceImpl;

import Backendproject.entities.User;
import Backendproject.repositories.ContractRepository;
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
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
