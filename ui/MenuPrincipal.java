package ui;

import infrastructure.file.FileHandler;

import java.util.List;

import application.service.PetService;
import domain.model.endereco.Endereco;
import domain.model.pet.Pet;
import domain.model.pet.SexoPet;
import domain.model.pet.TipoPet;
import infrastructure.util.ValidacoesInputs;

public class MenuPrincipal {

    private final ValidacoesInputs validacoesScanner;
    private final PetService petService;
    private final FileHandler fileHandler;

    public MenuPrincipal(ValidacoesInputs validacoesScanner, PetService petService, FileHandler fileHandler) {
        this.petService = petService;
        this.fileHandler = fileHandler;
        this.validacoesScanner = validacoesScanner;
    }

    public String imprimirMenu() {
        return "1 - Cadastrar um novo pet\r\n" + 
                "2 - Alterar os dados do pet cadastrado\r\n" + 
                "3 - Deletar um pet cadastrado\r\n" + //
                "4 - Listar todos os pets cadastrados\r\n" + 
                "5 - Listar pets por algum critério (idade, nome, raça)\r\n" + 
                "6 - Sair";
    }

    private void processarCadastroDePet() {
        List<String> perguntas = fileHandler.lerPerguntasDoFormulario();

        if (perguntas.size() < 6) {
            System.err.println("ERRO: O arquivo 'formulario.txt' está incompleto ou não foi encontrado.");
            System.err.println("Por favor, verifique o arquivo e tente novamente.");
            return;
        }

        try {
            String nomeCompleto = validacoesScanner.pedirString(perguntas.get(0) + " ");
            String[] nomeSobrenome = nomeCompleto.split(" ", 2);
            String nome = nomeSobrenome[0];
            String sobrenome = nomeSobrenome.length > 1 ? nomeSobrenome[1] : "";

            TipoPet tipo;
            while (true) {
                String tipoInput = validacoesScanner.pedirString(perguntas.get(1) + " ").toUpperCase();
                if (tipoInput.equals("CACHORRO") || tipoInput.equals("GATO")) {
                    tipo = TipoPet.valueOf(tipoInput);
                    break;
                }
                System.out.println("Opção inválida. Por favor, digite 'Cachorro' ou 'Gato'.");
            }

            SexoPet sexo;
            while (true) {
                String sexoInput = validacoesScanner.pedirString(perguntas.get(2) + " ").toUpperCase();
                if (sexoInput.equals("MASCULINO") || sexoInput.equals("FEMININO")) {
                    sexo = SexoPet.valueOf(sexoInput);
                    break;
                }
                System.out.println("Opção inválida. Por favor, digite 'Masculino' ou 'Feminino'.");
            }

            System.out.println(perguntas.get(3));
            String rua = validacoesScanner.pedirString("Rua: ");
            String cidade = validacoesScanner.pedirString("Cidade: ");
            int numero = validacoesScanner.pedirNumeroInteiro("Número: ");
            Endereco endereco = new Endereco(numero, cidade, rua);

            double idade = validacoesScanner.pedirNumeroFlutuante(perguntas.get(4) + " "); 
            double peso = validacoesScanner.pedirNumeroFlutuante(perguntas.get(5) + " "); 
            String raca = validacoesScanner.pedirString(perguntas.get(6) + " "); 

            Pet novoPet = new Pet(nome, sobrenome, raca, sexo, tipo, endereco, idade, peso);

            petService.cadastrarPet(novoPet);

            System.out.println("\n Pet cadastrado com sucesso! ");

        } catch (RuntimeException e) {
            System.err.println("\nERRO no cadastro: " + e.getMessage());
            System.err.println("Por favor, tente novamente.");
        }
    }

    public void selecionarOpcaoNoMenu() {
        System.out.println(imprimirMenu());
        int opcao = validacoesScanner.pedirNumeroInteiro("Insira a opção!: ");
        switch (opcao) {
            case 1:
                processarCadastroDePet();
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            default:
                System.out.println("Por favor, insira uma opção válida!");
                selecionarOpcaoNoMenu();
                break;
        }
    }
}
