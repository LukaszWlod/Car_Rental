package github.lukaszwlod.rental.Controller;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

   @GetMapping("/showCars")
    public String showCars(Model model){
        this.addAttributes(model);
        return "car";
    }

    public void addAttributes(Model model){
        model.addAttribute("car",new Car());
        model.addAttribute("clientsList",carService.getCars());
    }


}
