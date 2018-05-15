package net.dron.controllers;

import net.dron.domain.Car;
import net.dron.repositories.CarsRepository;
import net.dron.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsDBController {

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    CarServices carServices;


    @RequestMapping("/all")
    public List<Car> getAllCars() {
        return  carsRepository.findAll();
    }

    @RequestMapping("/country/{country}")
    public List<Car> findByCountry(@PathVariable String country) {

        return carsRepository.findCarsByCountry(country);
    }

    @RequestMapping("/model/{model}")
    public List<Car> findByModel(@PathVariable String model) {
        return carsRepository.findCarsByModel(model);
    }

    @RequestMapping("/mark/{mark}")
    public List<Car> findByMark(@PathVariable String mark) {

        return carsRepository.findCarsByMark(mark);
    }

    @RequestMapping("/color/{color}")
    public List<Car> findByColor(@PathVariable String color) {
        return carsRepository.findCarsByColor(color);
    }
    @RequestMapping("/year/{year}")
    public List<Car> findByYearMade(@PathVariable Integer year) {
        return carsRepository.findCarsByYearMade(year);
    }

    @RequestMapping(value = "/id/{id}")

    public Car findById(@PathVariable Integer id ) {

        return carServices.getCarById(id);

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
        Car car = carServices.getCarById(id);
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
        Car car = carServices.getCarById(id);

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
        return new Car(1, "lada", "06", "green", 2010, "russia");

    }


}
