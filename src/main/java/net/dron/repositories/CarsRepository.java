package net.dron.repositories;

import net.dron.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarsRepository extends JpaRepository<Car, Integer> {

    List<Car> findCarsByColor(String color);
    List<Car> findCarsByMark(String mark);
    List<Car> findCarsByCountry (String country);
    List<Car> findCarsByModel(String model);
    List<Car> findCarsByYearMade(Integer year);

}