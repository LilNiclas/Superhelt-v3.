package com.example.superhero_v3.controller;

import com.example.superhero_v3.model.Superhero;
import com.example.superhero_v3.services.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "kea")
public class MyController {

    MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(path = "superheroes")     //localhost:8080/kea/superheroes
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List superheroesList = myService.getSuperheroes();
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }

    @GetMapping(path = "superhero/{name}")      //localhost:8080/kea/superhero/{name}
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name) {
        Superhero getSuperhero = myService.getSuperhero(name);
        return new ResponseEntity<>(getSuperhero, HttpStatus.OK);
    }

    @PostMapping(path = "hero/create")      //localhost:8080/kea/hero/create
    public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
        Superhero createSuperhero = myService.createSuperhero(superhero.getName(), superhero.getSuperpower(), superhero.isHuman(), superhero.getIntroYear(), superhero.getStrengthPoint());
        return new ResponseEntity<>(createSuperhero, HttpStatus.OK);
    }


}

