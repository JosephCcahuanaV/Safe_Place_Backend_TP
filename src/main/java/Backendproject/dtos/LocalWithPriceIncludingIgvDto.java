package Backendproject.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocalWithPriceIncludingIgvDto {

    private Long id;
    private String name;
    private Double priceWithIgv;

}
