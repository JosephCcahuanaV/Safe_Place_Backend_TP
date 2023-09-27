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
@Table(name ="clients")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private String email;
    private String numberPhone;
    private String Dni;
    private String ruc;

    @OneToOne
    @JoinColumn(name = "user_Id") // viene de la tabla USER
    private User user;

    @OneToMany(mappedBy = "client") // va hacia la tabla reviews, uno a muchos
    private List<Review> reviews;

    @OneToMany(mappedBy = "client") // va hacia la tabla bookings, uno a muchos
    private List<Booking> bookings;

}
