package github.lukaszwlod.rental.service;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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
    public void saveCar(Car car) {
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
    public List<Car> getAvailableCars() {
        return carRepository.findAllByAvailableTrue();
    }

    @Override
    public Car getOne(Long id) {
        return carRepository.findById(id).orElseThrow(()-> new RuntimeException("Car doesn't exist"));
    }


}
