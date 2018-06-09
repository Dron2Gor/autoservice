package net.dron.controllers;

import net.dron.domain.Car;
import net.dron.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsDBController {

    @Autowired
    private CarsRepository carsRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Car> getAllCars() {
        return carsRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/country/{country}")
    public List<Car> findByCountry(@PathVariable String country) {

        return carsRepository.findCarsByCountry(country);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/model/{model}")
    public List<Car> findByModel(@PathVariable String model) {
        return carsRepository.findCarsByModel(model);
    }

    @RequestMapping("/mark/{mark}")
    public List<Car> findByMark(@PathVariable String mark) {

        return carsRepository.findCarsByMark(mark);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/color/{color}")
    public List<Car> findByColor(@PathVariable String color) {
        return carsRepository.findCarsByColor(color);
    }

    @RequestMapping("/year/{year}")
    public List<Car> findByYearMade(@PathVariable Integer year) {
        return carsRepository.findCarsByYearMade(year);
    }

    @RequestMapping(method =RequestMethod.GET, value = "/{id}")

    public Car findById(@PathVariable Integer id) {

        Car car=null;

        if (carsRepository.findById(id).isPresent())
            car=carsRepository.findById(id).get();
        return car;
    }

    @RequestMapping(method = RequestMethod.POST, value= "/new")
    @ResponseBody
    public Car addNewCar(@RequestBody Car car){

        carsRepository.save(car);
        return  car;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    @ResponseBody
    public Car updateCar(@RequestBody Car car){

        carsRepository.save(car);
        return  car;

    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteCar(@PathVariable int id){
        carsRepository.deleteById(id);
        return ResponseEntity.ok().body("Car №"+id+" was deleted.");
    }





}
