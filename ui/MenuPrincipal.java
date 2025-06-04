package ui;

import infaestructure.util.ValidacoesInputs;

public class MenuPrincipal {
    
    private final ValidacoesInputs validacoesScanner;

    public MenuPrincipal(ValidacoesInputs validacoesScanner){
        this.validacoesScanner = validacoesScanner;
    }

    public String imprimirMenu(){
        return "1 - Cadastrar um novo pet\r\n" + //
               "2 - Alterar os dados do pet cadastrado\r\n" + //
               "3 - Deletar um pet cadastrado\r\n" + //
               "4 - Listar todos os pets cadastrados\r\n" + //
               "5 - Listar pets por algum critério (idade, nome, raça)\r\n" + //
               "6 - Sair";
    }

    public void selecionarOpcaoNoMenu(){
        System.out.println(imprimirMenu());
        int opcao = validacoesScanner.pedirNumeroInteiro();
        switch (opcao) {
            case 1:
                System.out.println("Chegou no caso 1");
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
