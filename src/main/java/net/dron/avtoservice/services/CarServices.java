package net.dron.avtoservice.services;

import net.dron.avtoservice.entyties.Car;
import net.dron.avtoservice.repositoties.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServices {

    @Autowired
    CarsRepository carsRepository;

    public Car getCarById (){
        Car car= carsRepository.findById(1).get();
        System.out.println(car);
        return car;
    }
}
