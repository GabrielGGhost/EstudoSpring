package com.estudo.spring.SpringBoot2.domain;

public class Anime {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Anime() {}

    public Anime(String name) {
        this.name = name;
    }
}