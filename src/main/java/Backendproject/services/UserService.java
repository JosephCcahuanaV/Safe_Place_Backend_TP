package Backendproject.services;



import Backendproject.entities.TypeLocal;
import Backendproject.entities.User;

import java.util.List;

public interface UserService {


    public List<User> listAll();
    public User save(User user);
    public void delete(Long id);
    public User findById(Long id);


}
