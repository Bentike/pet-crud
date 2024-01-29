package com.bentike.springbootcrud.pet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data keyword helps with setter and getter methods
@Data
// @Entity keyword converts a class to a database table
@Entity
@NoArgsConstructor
public class Pet {
    @Id
    // the @GeneratedValue generates an automatic id for our Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String color;

    public Pet(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
