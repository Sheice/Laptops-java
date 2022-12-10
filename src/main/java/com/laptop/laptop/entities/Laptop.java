package com.laptop.laptop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private int tamaño;

    // constructores

    public Laptop() {
    }

    public Laptop(String marca, int tamaño) {
        this.marca = marca;
        this.tamaño = tamaño;
    }

    public Laptop(Long id, String marca, int tamaño) {
        this.id = id;
        this.marca = marca;
        this.tamaño = tamaño;
    }

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
}
