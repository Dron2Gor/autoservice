package net.dron.avtoservice.controllers;

import net.dron.avtoservice.entyties.Car;
import net.dron.avtoservice.repositoties.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class AutoDBController {

    String number;

    @Autowired
    private CarsRepository carsRepository;


    @RequestMapping("/all")
    public List<Car> getAllCars() {
        return carsRepository.findAll();
    }

    @RequestMapping("/{country}")
    public List<Car> findByCountry(@PathVariable String country) {
        return carsRepository.findCarsByCountry(country);
    }

    @RequestMapping("/{model}")
    public List<Car> findByModel(@PathVariable String model) {
        return carsRepository.findCarsByModel(model);
    }

    @RequestMapping("/{mark}")
    public List<Car> findByMark(@PathVariable String mark) {

        return carsRepository.findCarsByMark(mark);
    }

    @RequestMapping("/{color}")
    public List<Car> findByColor(@PathVariable String color) {
        return carsRepository.findCarsByColor(color);
    }
    @RequestMapping("/{year}")
    public List<Car> findByYearMade(@PathVariable Integer year) {
        return carsRepository.findCarsByYearMade(year);
    }

    @RequestMapping(value = "/{id}")
    public Car findById(@PathVariable("id") int id ) {
        return carsRepository.findById(id).get();

    }
    @RequestMapping("/new/{mark}/{model}/{color}/{year}/{country}")
    public Car addNewCar(@PathVariable String mark, @PathVariable String model, @PathVariable String color,
                         @PathVariable int year, @PathVariable String country) {

        Car car = new Car();
        car.setModel(model);
        car.setMark(mark);
        car.setColor(color);
        car.setYearMade(year);
        car.setCountry(country);

        carsRepository.save(car);

        return car;
    }

    @RequestMapping("/delete/{id}")
    public Car deleteById(@PathVariable int id) {
        Car car = carsRepository.findById(id).get();
        carsRepository.deleteById(id);
        return car;
    }
    @RequestMapping("/update")
    public Car updateCarById (@RequestParam int id,
                              @RequestParam (required = false) String mark,
                              @RequestParam (required = false) String model,
                              @RequestParam (required = false) String color,
                              @RequestParam (required = false) Integer year,
                              @RequestParam (required = false) String country) {
        Car car = carsRepository.findById(id).get();

        if (model!=null)
        car.setModel(model);
        if (mark!=null)
        car.setMark(mark);
        if(color!=null)
        car.setColor(color);
        if (year!=null)
        car.setYearMade(year);
        if (country!=null)
        car.setCountry(country);

        carsRepository.save(car);

        return car;
    }

    @RequestMapping("/test")
    public Car findTest() {
        Car car = new Car(1, "lada", "06", "green", 2010, "russia");
        return car;
    }


}
