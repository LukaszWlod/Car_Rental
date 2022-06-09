package github.lukaszwlod.rental.service;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CarService {
    List<Client> getCars();
    void saveCars(Car car);
    void deleteCarById(Long id);
    void update (Car car);


    Optional<Client> getOne(Long id);
}
