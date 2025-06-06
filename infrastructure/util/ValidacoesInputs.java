package infrastructure.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidacoesInputs {

    private Scanner scanner;

    public ValidacoesInputs() {
        this.scanner = new Scanner(System.in);
    }

    public String pedirString(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine();
    }

    public int pedirNumeroInteiro(String mensagem){
        System.out.print(mensagem);

        while (!scanner.hasNextInt()) {
            System.out.println("\n" + "Entrada Inválida, por favor, insira um número inteiro!");
            scanner.next();
        }
        
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }

    public double pedirNumeroFlutuante(String mensagem) {
        System.out.print("\n" + mensagem);

        while (!scanner.hasNextDouble() && !scanner.hasNext(Pattern.compile(".*,"))) {
            System.out.print("\n" + "Entrada inválida! Por favor, insira um número com vírgula ou ponto.");
            scanner.next(); 
        }

        double numero;
        if (scanner.hasNextDouble()) {
            numero = scanner.nextDouble();
        } else {
            String entrada = scanner.next().replace(',', '.');
            numero = Double.parseDouble(entrada);
        }

        scanner.nextLine();

        return numero;
    }
}
