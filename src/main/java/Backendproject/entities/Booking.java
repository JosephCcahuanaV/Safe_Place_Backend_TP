package Backendproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne //viene de cliente
    @JoinColumn(name = "client_Id")
    private Client client;

    @ManyToOne //viene de local
    @JoinColumn(name = "local_Id")
    private Local local;

    @ManyToOne //viene de metodo de pago
    @JoinColumn(name = "payment_Id")
    private Payment payment;

    @ManyToOne //viene de metodo de pago
    @JoinColumn(name = "contract_Id")
    private Contract contract;


}


