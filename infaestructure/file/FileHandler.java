package infaestructure.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileHandler {
    
    String caminhoDoProjeto = System.getProperty("user.dir");

    Path caminhoFinalDoArquivo = Paths.get(caminhoDoProjeto, "petsCadastrados");
    Path caminhoDoFormulario = Paths.get(caminhoDoProjeto, "formulario.txt");

    Scanner scanner = new Scanner(System.in);

    public void criarArquivo(Object objectParaEscrever, String nomeDoArquivo){
        try {
            LocalDateTime dataAtual = LocalDateTime.now();
            
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
            String dataAtualFormatada = dataAtual.format(formatador);

            String nomeFinalDoArquivo = dataAtualFormatada + "-" + nomeDoArquivo.toUpperCase() + ".txt";
            Path caminhoCompletoParaOArquivo = caminhoFinalDoArquivo.resolve(nomeFinalDoArquivo);
            
            try (BufferedWriter writer = Files.newBufferedWriter(caminhoCompletoParaOArquivo, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                writer.write(objectParaEscrever.toString());
                writer.newLine();
                System.out.println("Arquivo " + nomeFinalDoArquivo + " salvo com sucesso!");
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lerOFormulario(){
        try (BufferedReader reader = Files.newBufferedReader(caminhoDoFormulario, StandardCharsets.UTF_8)) {
            String pergunta;
            int numeroDaPergunta = 1;

            while ((pergunta = reader.readLine()) != null) {
                System.out.println(pergunta);

                System.out.print("Resposta: ");
                String respostaDoUsuario = scanner.nextLine();

                numeroDaPergunta++;
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler ou processar o formulário" + e.getMessage());
        }
    }

    public long quantidadeDeLinhasDoArquivo(){
        long quantidadeDeLinhas = 0;

        try (Stream<String> stream = Files.lines(caminhoDoFormulario, StandardCharsets.UTF_8)) {
            quantidadeDeLinhas = stream.count();
        } catch (Exception e) {
            System.out.println("Erro ao ler a quantidade de linhas: " + e.getMessage());
        }

        return quantidadeDeLinhas;
    }
}
