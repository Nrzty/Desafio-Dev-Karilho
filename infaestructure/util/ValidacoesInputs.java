package infaestructure.util;

import java.util.Scanner;

public class ValidacoesInputs {
    
    private final String valorNaoInformado = "NÂO INFORMADO";
    private Scanner scanner;


    public ValidacoesInputs(){
        this.scanner = new Scanner(System.in);
    }

    public String getValorNaoinformado() {
        return valorNaoInformado;
    }

    public int pedirNumeroInteiro(){
        System.out.print("\n" + "Por favor, insira um número inteiro: ");
        
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        }
        
        System.out.println("\n" + "Por favor, digite um número inteiro!");
        scanner.next();

        return pedirNumeroInteiro();
    }
    
    public double pedirNumeroFlutuante(){
        System.out.print("\n" + "Por favor, insira um número com vírgula ou ponto: ");
 
        if (scanner.hasNextDouble()){
            return scanner.nextDouble();
        }

        String entrada = scanner.next();
        String virgulaParaPonto = entrada.replace(',', '.');

        try {
            return Double.parseDouble(virgulaParaPonto); 
        } catch (NumberFormatException e) { 
            System.out.print("\n" + "Entrada inválida! '" + entrada + "' não é um número flutuante válido.");
            
            return pedirNumeroFlutuante(); 
        }
    }

    public boolean verificarCaracteresEspeciais(String texto){
        if (texto == null){
            return false;
        }
        return !texto.matches("\"^[\\\\p{L}\\\\s]+$\"");
    }

    public String formatarValorNaoINformado(Object object, String valor){
        if (object == null) {
            return valor;
        }
        return object.toString();
    }
}
