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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

   @OneToOne
   @JoinColumn(name = "client_id",referencedColumnName = "id")
    private  Client client;
   @OneToOne
   @JoinColumn(name = "car_id",referencedColumnName = "id")
    private  Car car;
    private  double charge;
    private boolean isOutOfDate;


    public Rental(LocalDate rentalDate, LocalDate returnDate, Client client, Car car, boolean isOutOfDate) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.client = client;
        this.car = car;
        this.isOutOfDate = isOutOfDate;
    }
}
