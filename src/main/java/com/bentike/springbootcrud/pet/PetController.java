package com.bentike.springbootcrud.pet;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/pets")
public class PetController {
    private PetService petService;

    @GetMapping("/all-pets")
    public ResponseEntity<List<Pet>> getPets(){
        return new ResponseEntity<>(petService.getPets(), OK);
    }

    @PostMapping("/add-pet")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet){
        return new ResponseEntity<>(petService.addPet(pet), CREATED);
    }

    @PutMapping("/update-pet")
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet){
        return new ResponseEntity<>(petService.updatePet(pet), CREATED);
    }

    @DeleteMapping("/pet/{id}")
    public void deletePet(@PathVariable("id") Integer id){
        petService.deletePet(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable("id") Integer id) throws Exception {
        return petService.getPetById(id).map(ResponseEntity :: ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
