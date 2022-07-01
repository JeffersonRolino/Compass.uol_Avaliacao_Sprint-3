package com.github.JeffersonRolino.AvaliacaoSprint3.model.entity;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.dto.StateDto;

import javax.persistence.*;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String region;
    private int population;
    private String capital;
    private double area;

    public State(){}

    public State(String name, String region, int population) {
        this.name = name;
        this.region = region;
        this.population = population;
    }

    public State(StateDto stateDto) {
        this.id = stateDto.getId();
        this.name = stateDto.getName();
        this.region = stateDto.getRegion();
        this.population = stateDto.getPopulation();
        this.capital = stateDto.getCapital();
        this.area = stateDto.getArea();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public double getArea() {
        return area;
    }
}
