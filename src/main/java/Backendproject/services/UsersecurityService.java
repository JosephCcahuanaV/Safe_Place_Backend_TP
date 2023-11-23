package Backendproject.services;


import Backendproject.dtos.UserSecurityDTO;
import Backendproject.entities.Local;
import Backendproject.entities.UserSecurity;

import java.util.List;

public interface UsersecurityService {

    public UserSecurity findById(Long id);

    public UserSecurity register(UserSecurityDTO user);

    public UserSecurity changePassword(UserSecurityDTO user);

    public List<UserSecurity> listAll();


}
