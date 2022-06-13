package github.lukaszwlod.rental.Controller;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.model.Order;
import github.lukaszwlod.rental.model.Rental;
import github.lukaszwlod.rental.service.CarService;
import github.lukaszwlod.rental.service.ClientService;
import github.lukaszwlod.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("rentals")
public class RentalController {

    RentalService rentalService;
    CarService carService ;
    ClientService clientService;


   @Autowired
    public RentalController(RentalService rentalService, CarService carService,ClientService clientService) {
        this.rentalService = rentalService;
        this.carService = carService;
        this.clientService = clientService;
    }

    @GetMapping("addRental")
    public String addRental(@ModelAttribute("order")Order order, Model model) {
        Car car = carService.getOne(order.getCarId());
        Client client = clientService.getOne(order.getClientId());
        car.setAvailable(false);
        carService.update(car);

        System.out.println("klient: "  + client.toString());

        model.addAttribute("car",car);
        model.addAttribute("client",client);
        model.addAttribute("order",order);

        System.out.println("Add rental");

        System.out.println(order.toString()+"\n"+
                car.toString()+"\n"+
                client.toString()
        );

        Rental newRental= new Rental(order.getId(),
                order.getRentalDate(),order.getRentalDate(),client,
                car,false
        );

        System.out.println( newRental.toString());


        rentalService.saveRental(newRental);



        return "redirect:/rentals/showRentals";
    }


    @GetMapping("/showRentals")
    public String showCars(Model model){
        model.addAttribute("rental",new Car());
        List<Rental> rentals = rentalService.getRentals();
        model.addAttribute("rentalList",rentals);
        return "rentals";
    }
}
