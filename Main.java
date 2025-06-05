import domain.model.endereco.Endereco;
import domain.model.pet.Pet;
import domain.model.pet.SexoPet;
import domain.model.pet.TipoPet;
import infaestructure.file.FileHandler;

import infaestructure.util.ValidacoesInputs;

public class Main{
    public static void main(String[] args) {
        ValidacoesInputs validacoesScanner = new ValidacoesInputs();
        //MenuPrincipal menuPrincipal = new MenuPrincipal(validacoesScanner);
        //menuPrincipal.selecionarOpcaoNoMenu();
        Endereco endereco = new Endereco(69, "aracaju", "murilo dantas");
        Pet pet = new Pet("Pitou", "Santana", "De rua", SexoPet.FEMININO, TipoPet.GATO, endereco, 10, 20 );
        FileHandler file = new FileHandler();
        //file.criarArquivo(pet, pet.getName());

        file.lerOFormulario();
    }
}