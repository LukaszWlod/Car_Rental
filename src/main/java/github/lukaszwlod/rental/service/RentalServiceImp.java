package github.lukaszwlod.rental.service;

import github.lukaszwlod.rental.model.Rental;
import github.lukaszwlod.rental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentalServiceImp  implements RentalService{
    RentalRepository rentalRepository;

   @Autowired
    public RentalServiceImp(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<Rental> getRentals() {
        return rentalRepository.findAllByIsOutOfDateFalse();
    }
    @Override
    public List<Rental> getArchive() {
        return rentalRepository.findAllByIsOutOfDateTrue();
    }

    @Override
    public Rental getOne(Long id) {
        return rentalRepository.findById(id).orElseThrow(()-> new RuntimeException("Record doesn't exist"));
    }


    @Override
    public void saveRental(Rental rental) {
        rentalRepository.save(rental);
    }

    @Override
    public void deleteRentalById(Long id) {
        rentalRepository.deleteById(id);
    }


}
