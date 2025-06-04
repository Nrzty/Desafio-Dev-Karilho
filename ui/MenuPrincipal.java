package ui;

public class MenuPrincipal {
    
    public String imprimirMenu(){
        return "1 - Cadastrar um novo pet\r\n" + //
               "2 - Alterar os dados do pet cadastrado\r\n" + //
               "3 - Deletar um pet cadastrado\r\n" + //
               "4 - Listar todos os pets cadastrados\r\n" + //
               "5 - Listar pets por algum critério (idade, nome, raça)\r\n" + //
               "6 - Sair";
    }
}
