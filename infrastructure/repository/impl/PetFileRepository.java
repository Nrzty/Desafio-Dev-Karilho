package infrastructure.repository.impl;

import domain.repository.PetRepository;
import infrastructure.file.FileHandler;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import domain.model.endereco.Endereco;
import domain.model.pet.Pet;
import domain.model.pet.SexoPet;
import domain.model.pet.TipoPet;

public class PetFileRepository implements PetRepository {

    private final FileHandler fileHandler;

    public PetFileRepository(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public Pet cadastrarPet(Pet pet) {
        if (pet != null) {
            String nomeDoArquivo = pet.getNome() + pet.getSobrenome();
            
            List<String> respostas = pet.getRespostasParaArquivo();

            fileHandler.criarArquivo(respostas, nomeDoArquivo);
        }
        return pet;
    }

    public List<Pet> listarTodosOsPetsCadastrados() {
        List<Pet> petsCadastrados = new ArrayList<>();

        try (Stream<Path> filePathStream = Files.walk(fileHandler.CAMINHO_FINAL_DO_ARQUIVO)) {
            filePathStream
                    .filter(Files::isRegularFile)
                    .forEach(filePath -> {
                        Pet pet = transformarArquivoEmPet(filePath);

                        if (pet != null) {
                            petsCadastrados.add(pet);
                        }
                    });
        } catch (Exception e) {
            System.out.println("Erro ao percorer o diretório de pets: " + e.getMessage());
        }

        return petsCadastrados;
    }

    public Pet transformarArquivoEmPet(Path filePath) {
        try {
            List<String> linhas = Files.readAllLines(filePath, StandardCharsets.UTF_8);

            if (linhas.size() < 7) {
                System.out.println("Erro");
                return null;
            }

            String[] nomeSobrenome = linhas.get(0).split(" ", 2);
            String nome = nomeSobrenome[0];
            String sobrenome = nomeSobrenome.length > 1 ? nomeSobrenome[1] : "";

            TipoPet tipo = TipoPet.valueOf(linhas.get(1).toUpperCase());

            SexoPet sexo = SexoPet.valueOf(linhas.get(2).toUpperCase());

            String[] partesEndereco = linhas.get(3).split(", ");
            String rua = partesEndereco[0].replace("Rua ", "");
            int numero = Integer.parseInt(partesEndereco[1]);
            String cidade = partesEndereco[2];
            Endereco endereco = new Endereco(numero, cidade, rua);

            double idade = Double.parseDouble(linhas.get(4).replace(" anos", ""));

            double peso = Double.parseDouble(linhas.get(5).replace("kg", ""));

            String raca = linhas.get(6);

            return new Pet(nome, sobrenome, raca, sexo, tipo, endereco, idade, peso);

        } catch (Exception e) {
            System.out.println("erro");
        }

        return null;
    }
}
