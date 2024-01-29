package com.bentike.springbootcrud.pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    Pet addPet(Pet pet);
    List<Pet> getPets();
    Pet updatePet(Pet pet);
    void deletePet(Integer id);
    Optional<Pet> getPetById(Integer id) throws Exception;
}

