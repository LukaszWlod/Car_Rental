package github.lukaszwlod.rental.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    private Long clientId;

    private Long carId;
}
