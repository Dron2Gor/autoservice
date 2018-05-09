package net.dron.avtoservice.controllers;

import net.dron.avtoservice.entyties.Car;
import net.dron.avtoservice.repositoties.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutoDBController {

    @Autowired
    private CarsRepository carsRepository;


    @RequestMapping("/all")
    public List<Car> getAllCars() {
        return carsRepository.findAll();
    }

    @RequestMapping("/country")
    public List<Car> findByCountry(@RequestParam String country) {
        return carsRepository.findCarsByCountry(country);
    }

    @RequestMapping("/model")
    public List<Car> findByModel(@RequestParam String model) {
        return carsRepository.findCarsByModel(model);
    }

    @RequestMapping("/mark")
    public List<Car> findByMark(@RequestParam String mark) {

        return carsRepository.findCarsByMark(mark);
    }

    @RequestMapping("/color")
    public List<Car> findByColor(@RequestParam String color) {
        return carsRepository.findCarsByColor(color);
    }
    @RequestMapping("/year")
    public List<Car> findByYearMade(@RequestParam Integer year) {
        return carsRepository.findCarsByYearMade(year);
    }

    @RequestMapping("/id")
    public Car findById(@RequestParam int id) {
        return carsRepository.findById(id).get();

    }

    @RequestMapping("/new")
    public Car addNewCar(@RequestParam String mark, @RequestParam String model, @RequestParam String color,
                         @RequestParam int year, @RequestParam String country) {
        Car car = new Car();
        car.setModel(model);
        car.setMark(mark);
        car.setColor(color);
        car.setYearMade(year);
        car.setCountry(country);

        carsRepository.save(car);

        return car;
    }

    @RequestMapping("/delete")
    public Car deleteById(@RequestParam int id) {
        Car car = carsRepository.findById(id).get();
        carsRepository.deleteById(id);
        return car;
    }
    @RequestMapping("/update")
    public Car updateCarById (@RequestParam int id, @RequestParam (required = false) String mark, @RequestParam (required = false) String model, @RequestParam (required = false) String color,
                          @RequestParam (required = false) Integer year, @RequestParam (required = false) String country) {
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
