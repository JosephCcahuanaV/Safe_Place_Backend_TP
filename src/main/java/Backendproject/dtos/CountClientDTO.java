package Backendproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountClientDTO {
    private String nationality;
    private Long cantidadClientes;
}