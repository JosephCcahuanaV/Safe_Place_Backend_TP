package Backendproject.services;


import Backendproject.dtos.UserSecurityDTO;
import Backendproject.entities.UserSecurity;

public interface UsersecurityService {

    public UserSecurity findById(Long id);

    public UserSecurity register(UserSecurityDTO user);

    public UserSecurity changePassword(UserSecurityDTO user);


}
