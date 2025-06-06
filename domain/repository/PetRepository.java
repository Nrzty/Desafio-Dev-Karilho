package domain.repository;

import java.util.List;

import domain.model.pet.Pet;

public interface PetRepository {
    
    public Pet cadastrarPet(Pet pet);

    public List<Pet> listarTodosOsPetsCadastrados();
}
