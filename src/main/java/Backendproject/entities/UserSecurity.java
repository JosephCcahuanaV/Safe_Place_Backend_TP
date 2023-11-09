package Backendproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="users_security")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private boolean enabled;
    private Date passwordLastUpdate;
    /*
    private String name;
    private String lastname;
    private String email;
    private String numberPhone;
    private String dni;*/

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_authorities",
            joinColumns = {
                    @JoinColumn (
                            name="usersecurity_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "authority_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            }
    )
    private List<Authority> authorities;

    public UserSecurity(String userName, String password, boolean enabled, Date passwordLastUpdate, List<Authority> authorities) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.passwordLastUpdate = passwordLastUpdate;
        this.authorities = authorities;
    }

/*
    public UserSecurity(String userName, String password, String name, String lastname, String email, String numberPhone,String dni) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.numberPhone=numberPhone;
        this.dni=dni;
    }*/
}
