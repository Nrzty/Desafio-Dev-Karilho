package infaestructure.repository.impl;

import infaestructure.file.FileHandler;
import domain.repository.PetRepository;

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
}
