package Backendproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="review")

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recomendation;
    private Long calification;
    private Boolean positive;


    @ManyToOne //viene de Client
    @JoinColumn(name = "client_Id")
    private Client client;

    @ManyToOne //viene de Local
    @JoinColumn(name = "local_Id")
    private Local local;
}
