package github.lukaszwlod.rental.Controller;

import github.lukaszwlod.rental.model.Car;
import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getOne")
    public @ResponseBody Optional<Car> getOne(Long id) {
        return carService.getOne(id);
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
