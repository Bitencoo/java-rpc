package com.example.protobuf;

import com.example.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {
    public static void main(String[] args) throws IOException {
//        Person sam = Person.newBuilder()
//                .setAge(21)
//                .setName("Sam")
//                .build();

        Path path = Paths.get("sam.ser");
//        Files.write(path, sam.toByteArray());

        Person newSam = Person.parseFrom(Files.readAllBytes(path));
        System.out.println(newSam);
    }
}
