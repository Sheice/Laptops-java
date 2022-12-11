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

    private int tamanio;

    // constructores

    public Laptop() {
    }

    public Laptop(String marca, int tamanio) {
        this.marca = marca;
        this.tamanio = tamanio;
    }

    public Laptop(Long id, String marca, int tamanio) {
        this.id = id;
        this.marca = marca;
        this.tamanio = tamanio;
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

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamaño) {
        this.tamanio = tamaño;
    }
}
