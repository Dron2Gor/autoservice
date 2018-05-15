package net.dron.services;

import net.dron.domain.Car;
import net.dron.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServices {

    @Autowired
    CarsRepository carsRepository;


    public Car getCarById (int id){
        Car car=null;
        if (carsRepository.findById(id).isPresent())
            car=carsRepository.findById(id).get();
        return car;
    }
}
