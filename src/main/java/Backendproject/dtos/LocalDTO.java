package Backendproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocalDTO {

    private Long id;
    private String name;
    private Double price;
}
