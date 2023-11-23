package Backendproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class BookingDTO
{
    private Date dateStart;
    private Date dateFinish;
    private Double price;
}
