package github.lukaszwlod.rental.model;



import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate rentalDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate returnDate;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Car car;




}
