package com.example.superhero_v3.services;

import com.example.superhero_v3.model.Superhero;
import com.example.superhero_v3.repositories.MyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<Superhero> getSuperheroes() {
        return myRepository.getSuperheroes();
    }

    public Superhero searchSuperhero(String name) {
        return myRepository.searchSuperhero(name);
    }

    public Superhero createSuperhero(String name, String superpower, boolean human, int introYear, double strengthPoint) {
        return myRepository.createSuperhero(name, superpower, human, introYear, strengthPoint);
    }

    public Superhero deleteSuperhero(String name) {
        return myRepository.deleteSuperhero(name);
    }

    public Superhero editSuperhero(Superhero superhero) {
        Superhero returnSuperhero = myRepository.editSuperhero(superhero);
        return returnSuperhero;
    }

}
