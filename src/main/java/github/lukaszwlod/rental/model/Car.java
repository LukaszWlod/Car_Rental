package github.lukaszwlod.rental.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String brand;
        private String model;
        private String yearOfProduction;
        private double price;

        private  boolean isAvailable;

        public Car(Long id, String brand, String model, String yearOfProduction, double price, boolean isAvailable) {
                this.id = id;
                this.brand = brand;
                this.model = model;
                this.yearOfProduction = yearOfProduction;
                this.price = price;
                this.isAvailable = isAvailable;
        }

        public boolean isAvailable() {
                return isAvailable;
        }

        public void setAvailable(boolean available) {
                isAvailable = available;
        }
}
