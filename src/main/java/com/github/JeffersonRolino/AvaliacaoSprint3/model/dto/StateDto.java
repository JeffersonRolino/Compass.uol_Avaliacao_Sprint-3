package com.github.JeffersonRolino.AvaliacaoSprint3.model.dto;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.entity.State;

public class StateDto {
    private Long id;
    private String name;
    private String region;
    private int population;
    private String capital;
    private double area;

    public StateDto() {
    }

    public StateDto(Long id, String name, String region, int population, String capital, double area) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.area = area;
    }

    public StateDto(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.region = state.getRegion();
        this.population = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
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


