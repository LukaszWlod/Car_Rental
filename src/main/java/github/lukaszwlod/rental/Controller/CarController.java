package github.lukaszwlod.rental.Controller;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

   @GetMapping("/showCars")
    public String showCars(Model model){
       model.addAttribute("car",new Car());
       List<Car> cars = carService.getCars();
       model.addAttribute("carList",cars);
        return "car";
    }

   @PostMapping("/addNew")
    public String addNewCar(@ModelAttribute("car") Car car){
        carService.saveCar(car);
       System.out.println(car.getBrand());
        return "redirect:/cars/showCars";
    }


    public void addAttributes(Model model){
        model.addAttribute("car",new Car());
        model.addAttribute("clientsList",carService.getCars());
    }




}
