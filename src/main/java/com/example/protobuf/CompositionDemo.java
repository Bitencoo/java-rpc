package com.example.protobuf;

import com.example.models.Address;
import com.example.models.Car;
import com.example.models.Person;

import java.util.ArrayList;
import java.util.List;

public class CompositionDemo {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(
                Car
                    .newBuilder()
                        .setMake("Toyota")
                        .setModel("Sedan")
                        .setYear(2016)
                    .build()
        );

        cars.add(
                Car
                        .newBuilder()
                        .setMake("Honda")
                        .setModel("Civic")
                        .setYear(2010)
                        .build()
        );

        Person newPerson = Person.newBuilder()
                .setName("Sam")
                .setAge(21)
                .setAddress(
                        Address
                            .newBuilder()
                                .setCity("Formiga")
                                .setPostbox(35574255)
                                .setStreet("Rua A")
                            .build()
                )
                .addAllCar(cars)
                .build();

        System.out.println(newPerson.toString());
    }
}
