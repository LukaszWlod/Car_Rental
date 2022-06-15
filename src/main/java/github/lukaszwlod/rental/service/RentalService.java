package github.lukaszwlod.rental.service;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Rental;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.List;
@Service
public interface RentalService {
    List<Rental> getRentals();
    List<Rental> getArchive();
    void saveRental(Rental rental);
    void deleteRentalById(Long id);
    Rental getOne(Long id);


}
