package Backendproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="payments")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typePay;
    private String NameonCard;
    private String FullName;
    private String EmailAddress;
    private Date FechaNacimiento;
    private String CardNumber;
    private String CardCvc;
    private String ExpMonth;
    private String ExpYear;

    @ToString.Exclude
    @OneToMany(mappedBy = "payment") // va hacia la tabla bookings, uno a muchos
    private List<Booking> bookings;

}
