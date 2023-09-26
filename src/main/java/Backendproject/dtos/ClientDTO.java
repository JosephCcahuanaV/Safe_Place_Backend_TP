package Backendproject.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {

    private String name;
    private String lastname;
    private String email;
    private String numberPhone;
    private String Dni;
    private String ruc;
}
