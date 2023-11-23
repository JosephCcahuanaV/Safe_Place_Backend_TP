package Backendproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class PaymentDTO {
    private String typePay;
    private String NameonCard;
    private String FullName;
    private String EmailAddress;
    private Date FechaNacimiento;
    private String CardNumber;
    private String CardCvc;
    private String ExpMonth;
    private String ExpYear;

    private Long bookingId;
}
