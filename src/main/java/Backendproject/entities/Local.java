package Backendproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="locals")

public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ubication;
    private String description;
    private Long capacity;
    private Double price;
    private String image;


    @ToString.Exclude
    @ManyToOne   // viene de renter
    @JoinColumn(name = "renter_Id")
    private Renter renter;

    @ManyToOne //viene de typeLocal
    @JoinColumn(name = "typelocal_Id")
    private TypeLocal typeLocal;

    @ToString.Exclude
    @OneToMany(mappedBy = "local") // va hacia la tabla reviews, uno a muchos
    private List<Review> reviews;


    @ToString.Exclude
    @OneToMany(mappedBy = "local") // va hacia la tabla bookings, uno a muchos
    private List<Booking> bookings;


}
