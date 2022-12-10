package com.laptop.laptop.controllers;

import com.laptop.laptop.entities.Laptop;
import com.laptop.laptop.respositories.LapotpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaptopRepository {

    @Autowired
    private LapotpRepository laptopRepository;

    @GetMapping("/laptops")
    public List<Laptop> listaDeLaptops(){
        List<Laptop> laptops = laptopRepository.findAll();

        return (List<Laptop>)laptopRepository.findAll();
    }

    @PostMapping("/create/laptop")
    public Laptop saveLaptop(@RequestBody Laptop laptop) {
        System.out.println(laptop.getMarca());
        return laptopRepository.save(laptop);
    }

}
