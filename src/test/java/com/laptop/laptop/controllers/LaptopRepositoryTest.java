package com.laptop.laptop.controllers;

import com.laptop.laptop.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopRepositoryTest {

    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;


    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void listaDeLaptops() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptop/1", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());



    }

    @Test
    void traerLaptopPorId() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/laptops", Laptop[].class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());


    }

    @Test
    void saveLaptop() {

        HttpHeaders header = new HttpHeaders();

        header.setAccept(List.of(MediaType.APPLICATION_JSON));

        String json = """
                     {
                         "marca": "lenosdvo",
                          "tamanio": 3
                     }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, header);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/create/laptop", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals("lenosdvo", result.getMarca());
    }
}