package Backendproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDTO {


    private String recomendation;
    private Long calification;
    private Boolean positive;


}
