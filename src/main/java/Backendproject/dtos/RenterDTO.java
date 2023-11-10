package Backendproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RenterDTO {

    private String nationality;
    private Long count;
}
