package com.laptop.laptop.controllers;

import com.laptop.laptop.entities.Laptop;
import com.laptop.laptop.respositories.LapotpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/laptop/{id}")
    public ResponseEntity<Laptop> traerLaptopPorId(@PathVariable Long id){
        Optional<Laptop> laptop = laptopRepository.findById(id);

        if(laptop.isPresent()){
            return ResponseEntity.ok(laptop.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create/laptop")
    public ResponseEntity<Laptop> saveLaptop(@RequestBody Laptop laptop) {
        if (laptop.getId() != null){
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    @PutMapping("/update/laptop/{id}")
    public ResponseEntity<Laptop> actualizarLaptop(@RequestBody Laptop laptop, @PathVariable Long id){

        if (laptop.getId() == null){
            return  ResponseEntity.badRequest().build();
        }

        if(!laptopRepository.existsById(id)){
            return  ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Laptop> borrarLaptop(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            return  ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Laptop> borrarTodasLasLaptops(){
        laptopRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }



}
