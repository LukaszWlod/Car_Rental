package github.lukaszwlod.rental.repository;

import github.lukaszwlod.rental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Long> {
}
