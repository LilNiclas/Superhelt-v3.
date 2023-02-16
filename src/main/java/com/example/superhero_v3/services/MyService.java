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

    public List<Superhero> getSuperhero(String name) {
        return myRepository.getSuperhero(name);
    }

}
