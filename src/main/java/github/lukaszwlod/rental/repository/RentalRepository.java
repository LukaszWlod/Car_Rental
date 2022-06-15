package github.lukaszwlod.rental.repository;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Long> {
    List<Rental> findAllByIsOutOfDateFalse();
    List<Rental> findAllByIsOutOfDateTrue();
}
