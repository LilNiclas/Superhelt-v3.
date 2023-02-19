package com.example.superhero_v3.repositories;

import com.example.superhero_v3.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MyRepository {

    private List<Superhero> superheroes = new ArrayList<>(List.of(
            new Superhero("Superman", "Laser", false, 1932, 18.5),
            new Superhero("Spiderman", "Spider", true, 1953, 8.4),
            new Superhero("Batman", "Money", true, 1938, 7)));

    public List<Superhero> getSuperheroes() {
        return superheroes;
    }

    public Superhero getSuperhero(String name) {
        for (Superhero hero : superheroes) {
            if (hero.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                return hero;
            }
        }
        return null;
    }

    public Superhero createSuperhero(String name, String superpower, boolean human, int introYear, double strengthPoint) {

        Superhero hero = new Superhero(name, superpower, human, introYear, strengthPoint);
        superheroes.add(hero);
        return hero;
    }


}
