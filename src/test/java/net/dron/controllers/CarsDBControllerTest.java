package net.dron.controllers;

import com.google.common.collect.ImmutableList;
import net.dron.domain.Car;
import net.dron.repositories.CarsRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarsDBControllerTest {

    @Mock
    private
    CarsRepository repository;

    @InjectMocks
    private
    CarsDBController controllerTest;



    @Ignore
    @Test
    public void getAllCars() {

        when(repository.findAll()).thenReturn(ImmutableList.of());

        List<Car> carList = controllerTest.getAllCars();

        verify(repository).findAll();

    }


}