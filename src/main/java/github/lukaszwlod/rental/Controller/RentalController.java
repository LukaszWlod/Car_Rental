package github.lukaszwlod.rental.Controller;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.model.Rental;
import github.lukaszwlod.rental.service.CarService;
import github.lukaszwlod.rental.service.ClientService;
import github.lukaszwlod.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("rentals")
public class RentalController {

    RentalService rentalService;
    CarService carService ;
    ClientService clientService;


   @Autowired
    public RentalController(RentalService rentalService, CarService carService) {
        this.rentalService = rentalService;
        this.carService = carService;
    }

    @GetMapping("addRental")
    public String addRental(@ModelAttribute("rental") Rental rental) {
//        Car car = carService.getOne(carId);
//        Client client = clientService.getOne(clientId);
//        car.setAvailable(false);
//        carService.update(car);



        System.out.println("Add rental");
//        System.out.println(car.getId());
//        System.out.println(client.getId());
        System.out.println(rental.toString());


        return "redirect:/cars/showCars";
    }
}
