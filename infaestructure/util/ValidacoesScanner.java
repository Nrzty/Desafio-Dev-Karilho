package infaestructure.util;

import java.util.Scanner;

public class ValidacoesScanner {
    
    private Scanner scanner = new Scanner(System.in);

    public int pedirNumeroInteiro(){
        int numero = 0;
        System.out.print("\n" + "Por favor, insira um número inteiro: ");

        if (!scanner.hasNextInt()){
            System.out.print("\n" + "Apenas é aceito numeros inteiros!");
            scanner.next();
            numero = pedirNumeroInteiro();
        } else {
            numero = scanner.nextInt();
        }
        
        return numero;
    }
}
