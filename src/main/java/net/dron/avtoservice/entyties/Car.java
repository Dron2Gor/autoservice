package net.dron.avtoservice.entyties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars", schema = "carsservice")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mark")
    private String mark;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;
    @Column(name = "yearmade")
    private Integer yearMade;
    @Column(name = "country")
    private String country;

}
