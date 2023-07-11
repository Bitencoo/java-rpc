package com.example.protobuf;

import com.example.models.BodyStyle;
import com.example.models.Car;
import com.example.models.Dealer;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(
                Car
                        .newBuilder()
                        .setMake("Toyota")
                        .setModel("Sedan")
                        .setYear(2016)
                        .setBodyStyle(BodyStyle.SEDAN)
                        .build()
        );

        cars.add(
                Car
                        .newBuilder()
                        .setMake("Honda")
                        .setModel("Civic")
                        .setYear(2010)
                        .setBodyStyle(BodyStyle.COUPE)
                        .build()
        );

        Dealer dealer = Dealer
                .newBuilder()
                .putModel(1234, cars.get(0))
                .putModel(4932, cars.get(1))
                .build();

        System.out.println(dealer.toString());
    }
}
