package Backendproject.services;


import Backendproject.dtos.UserDTO;
import Backendproject.entities.User;
import Backendproject.entities.UserSecurity;

import java.util.List;

public interface UsersecurityService {

    public UserSecurity findById(Long id);

    public UserSecurity registerUser(UserDTO user);

    public UserSecurity changePassword(UserDTO user);
    public void delete(Long id);
    public List<UserSecurity> listAll();
}
