package com.github.JeffersonRolino.AvaliacaoSprint3.model.dto;

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


