package github.lukaszwlod.rental.Controller;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.model.Rental;
import github.lukaszwlod.rental.service.CarService;
import github.lukaszwlod.rental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;
    private ClientService clientService;

   @Autowired
    public CarController(CarService carService,ClientService clientService) {
        this.carService = carService;
        this.clientService = clientService;
    }

    @GetMapping("/getOne")
    public @ResponseBody Car getOne(Long id) {
        return carService.getOne(id);
    }

   @GetMapping("/showCars")
    public String showCars(Model model){
       model.addAttribute("car",new Car());
       List<Car> cars = carService.getCars();
       model.addAttribute("carList",cars);
        return "car";
    }
    @GetMapping("/showCarsToRent/{clientId}")
    public String showCarsToRent(@PathVariable("clientId") Long clientId ,Model model){

        List<Car> cars = carService.getAvailableCars();
        Client client = clientService.getOne(clientId);



       model.addAttribute("rental",new Rental());
        model.addAttribute("car",new Car());
        model.addAttribute("carList",cars);
        model.addAttribute("client",client);
        return "carsToRent";
    }

   @PostMapping("/addNew")
    public String addNewCar(@ModelAttribute("car") Car car){
        carService.saveCar(car);
       System.out.println(car.getBrand());
        return "redirect:/cars/showCars";
    }

    @RequestMapping(value="/edit",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editEntry(@ModelAttribute Car car){
        carService.update(car);
        return "redirect:/cars/showCars";
    }


    @RequestMapping(value="/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEntry(@PathVariable("id") Long id ){
        carService.deleteCarById(id);
        return "redirect:/cars/showCars";
    }







}
