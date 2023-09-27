package Backendproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="users")


public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;
    private String password;
    private Date expirityDay;
    private Boolean is_active;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "rol_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Rol> rols;

   // @OneToMany(mappedBy = "user") // relacion con la tabla rol_user
    //private List<RolUser> rolUsers;


    @OneToOne(mappedBy = "user")  // relacion uno a uno con la tabla client
    private Client client;

    @OneToOne(mappedBy = "user")  // relacion uno a uno con la tabla renter
    private Renter renter;

}
