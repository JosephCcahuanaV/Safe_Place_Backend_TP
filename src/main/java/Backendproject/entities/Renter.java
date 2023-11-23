package Backendproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="renters")
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private String Email;
    private String numberphone;
    private String Dni;
    private String ruc;
    private String address;
    private String nacionality;
    private Long bankAccount ;


    @OneToOne
    @JoinColumn(name = "user_Id") // viene de la tabla USER
    private User user;


    @OneToMany (mappedBy = "renter") // de uno a muchos con Local
    private List<Local> locals;


}
