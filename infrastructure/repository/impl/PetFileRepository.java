package infrastructure.repository.impl;

import domain.repository.PetRepository;
import infrastructure.file.FileHandler;

import java.util.List;

import domain.model.pet.Pet;

public class PetFileRepository implements PetRepository{
    
    private final FileHandler fileHandler;

    public PetFileRepository(FileHandler fileHandler){
        this.fileHandler = fileHandler;
    }

    public Pet cadastrarPet(Pet pet){
        if (pet != null) {
            String nomeDoArquivo = pet.getNome() + pet.getSobrenome();
            fileHandler.criarArquivo(pet, nomeDoArquivo);
        }
        return pet;
    }

    public List<Pet> listarTodosOsPets(){
        


        return null;
    }
}
