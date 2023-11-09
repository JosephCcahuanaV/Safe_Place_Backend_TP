package Backendproject.services;



import Backendproject.dtos.UserDTO;
import Backendproject.entities.TypeLocal;
import Backendproject.entities.User;

import java.util.List;

public interface UserService {


    public List<User> listAll();
    public User registerUser(UserDTO user);
    public User changePassword(UserDTO user);
    public void delete(Long id);
    public User findById(Long id);


}
