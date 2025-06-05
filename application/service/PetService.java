package application.service;

import domain.model.pet.Pet;
import domain.repository.PetRepository;

public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public Pet cadastrarPet(Pet pet){
        if (pet == null) {
            throw new RuntimeException("O pet não pode ser nulo!");
        }

        Pet petSalvo = petRepository.cadastrarPet(pet);
        return petSalvo;
    }
}
