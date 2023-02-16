package com.example.superhero_v3.controller;

import com.example.superhero_v3.model.Superhero;
import com.example.superhero_v3.services.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "kea")
public class MyController {

    MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(path = "heroes")     //localhost:8080/kea/heroes
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List superheroesList = myService.getSuperheroes();
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }

    public


}
