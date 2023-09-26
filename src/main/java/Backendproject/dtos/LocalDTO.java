package Backendproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocalDTO {

    private String name;
    private String ubication;
    private String description;
    private Long aforo;
    private Double tarifaxdia;
    private Boolean is_active;
}
