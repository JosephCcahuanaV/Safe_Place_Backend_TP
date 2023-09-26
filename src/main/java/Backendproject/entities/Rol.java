package Backendproject.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="rols")



public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //autoincrementado en SQL
    private long id;

    private String name;

    @ManyToMany(mappedBy = "rols", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> users;



    //@OneToMany(mappedBy = "rol")
    //private List<RolUser> rolUsers;


}
