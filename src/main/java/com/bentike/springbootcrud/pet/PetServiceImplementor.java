package com.bentike.springbootcrud.pet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetServiceImplementor implements PetService{

    private PetRepository petRepository;
    @Override
    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getPets() {
        return petRepository.findAll().stream().toList();
    }

    @Override
    public Pet updatePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void deletePet(Integer id) {
       petRepository.deleteById(id);
    }

    @Override
    public Optional<Pet> getPetById(Integer id) throws Exception {
        return Optional.ofNullable(petRepository.findById(id)
                .orElseThrow(() -> new Exception("Pet Not Found !")));
    }
}
