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
    public ResponseEntity<Superhero> searchSuperhero(@PathVariable String name) {
        Superhero searchSuperhero = myService.searchSuperhero(name);
        return new ResponseEntity<>(searchSuperhero, HttpStatus.OK);
    }

    @PostMapping(path = "hero/create")      //localhost:8080/kea/hero/create
    public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
        Superhero createSuperhero = myService.createSuperhero(superhero.getName(), superhero.getSuperpower(), superhero.isHuman(), superhero.getIntroYear(), superhero.getStrengthPoints());
        return new ResponseEntity<>(createSuperhero, HttpStatus.OK);
    }

    @DeleteMapping(path = "hero/delete/{name}")     //localhost:8080/kea/hero/delete/{name}
    public ResponseEntity<Superhero> deleteSuperhero(@PathVariable String name) {
        Superhero deleteSuperhero = myService.deleteSuperhero(name);
        return new ResponseEntity<>(deleteSuperhero, HttpStatus.OK);
    }

    @PutMapping(path = "hero/edit")     //localhost:8080/kea/hero/edit
    public ResponseEntity<Superhero> editSuperhero(@RequestBody Superhero superhero) {
        Superhero editSuperhero = myService.editSuperhero(superhero);
        return new ResponseEntity<>(editSuperhero, HttpStatus.OK);
    }


}

