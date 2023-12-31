package Backendproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="bookings")

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateStart;
    private Date dateFinish;
    private Double price;

    @ToString.Exclude
    @ManyToOne //viene de cliente
    @JoinColumn(name = "client_Id")
    private Client client;

    @ManyToOne //viene de local
    @JoinColumn(name = "local_Id")
    private Local local;

    @OneToOne //viene de metodo de pago
    @JoinColumn(name = "payment_Id")
    private Payment payment;

    @ManyToOne //viene de metodo de pago
    @JoinColumn(name = "contract_Id")
    private Contract contract;

}


