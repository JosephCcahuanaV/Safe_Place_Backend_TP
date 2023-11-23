package Backendproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import Backendproject.dtos.PaymentDTO;

import java.util.Date;

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
    @OneToOne(mappedBy = "payment")
    private Booking booking;
    
    public void convertDtoToEntity(PaymentDTO paymentDTO) {
        this.typePay = paymentDTO.getTypePay();
        this.NameonCard = paymentDTO.getNameonCard();
        this.FullName = paymentDTO.getFullName();
        this.EmailAddress = paymentDTO.getEmailAddress();
        this.FechaNacimiento = paymentDTO.getFechaNacimiento();
        this.CardNumber = paymentDTO.getCardNumber();
        this.CardCvc = paymentDTO.getCardCvc();
        this.ExpMonth = paymentDTO.getExpMonth();
        this.ExpYear = paymentDTO.getExpYear();
    }
}
