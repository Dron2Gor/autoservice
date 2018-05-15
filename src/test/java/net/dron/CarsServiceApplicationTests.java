package net.dron;

import com.google.common.collect.ImmutableList;
import net.dron.controllers.CarsDBController;
import net.dron.domain.Car;
import net.dron.repositories.CarsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)

public class CarsServiceApplicationTests {

    private MockMvc mockMvc;

    @InjectMocks
    CarsDBController controller;


    TestRestTemplate restTemplate = new TestRestTemplate();

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void contextLoads() throws Exception {
        mockMvc.perform(get("/cars/test")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"mark\":\"lada\",\"model\":\"06\",\"color\":\"green\",\"yearMade\":2010,\"country\":\"russia\"}"));

//        ResponseEntity<List<Car>> responseEntity = restTemplate.exchange("http://localhost:8080/cars/all",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Car>>() {
//                });
//        List<Car> actualList = responseEntity.getBody();
//        assertThat(actualList.size(), is(17));
//
//        List<Integer> actualsIds = actualList.stream()
//                .map(car -> car.getId()).collect(collectingAndThen(toList(), ImmutableList::copyOf));
//        assertThat(actualsIds, containsInAnyOrder("car1", "car2"));
    }

}
