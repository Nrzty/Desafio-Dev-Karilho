import application.service.PetService;
import domain.model.endereco.Endereco;
import domain.model.pet.Pet;
import domain.model.pet.SexoPet;
import domain.model.pet.TipoPet;
import domain.repository.PetRepository;
import infrastructure.file.FileHandler;
import infrastructure.repository.impl.PetFileRepository;
import infrastructure.util.ValidacoesInputs;
import ui.MenuPrincipal;

public class Main{
    public static void main(String[] args) {
        ValidacoesInputs validacoes = new ValidacoesInputs();
        FileHandler fileHandler = new FileHandler();

        // Camada de Repositório
        PetRepository petRepository = new PetFileRepository(fileHandler);

        // Camada de Serviço
        PetService petService = new PetService(petRepository);

        // Camada de UI
        MenuPrincipal menu = new MenuPrincipal(validacoes, petService, fileHandler);

        // Iniciar a aplicação
        menu.selecionarOpcaoNoMenu();
    }
}