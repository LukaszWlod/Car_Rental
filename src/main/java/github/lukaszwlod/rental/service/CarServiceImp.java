package github.lukaszwlod.rental.service;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CarServiceImp  implements CarService{

    private  CarRepository carRepository;

    @Autowired
     public CarServiceImp(CarRepository carRepository){
         this.carRepository = carRepository;
     }


    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public void saveCars(Car car) {
        carRepository.save(car);

    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void update(Car car) {
        carRepository.save(car);
    }

    @Override
    public Optional<Client> getOne(Long id) {
        return Optional.empty();
    }
}
