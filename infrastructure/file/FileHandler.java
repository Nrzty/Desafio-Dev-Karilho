package infrastructure.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileHandler {
    
    public static String caminhoDoProjeto = System.getProperty("user.dir");

    public static final Path CAMINHO_FINAL_DO_ARQUIVO = Paths.get(caminhoDoProjeto, "petsCadastrados");
    Path caminhoDoFormulario = Paths.get(caminhoDoProjeto, "formulario.txt");

    Scanner scanner = new Scanner(System.in);

    public void criarArquivo(List<String> linhasParaEscrever, String nomeDoArquivo){
        try {
            String dataAtualFormatada = getDataAtualFormatada();

            String nomeFinalDoArquivo = dataAtualFormatada + "-" + nomeDoArquivo.toUpperCase() + ".txt";
            Path caminhoCompletoParaOArquivo = CAMINHO_FINAL_DO_ARQUIVO.resolve(nomeFinalDoArquivo);
            
            try (BufferedWriter writer = Files.newBufferedWriter(caminhoCompletoParaOArquivo, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                for(String linha : linhasParaEscrever){
                    writer.write(linha);
                    writer.newLine();
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getDataAtualFormatada() {
        LocalDateTime dataAtual = LocalDateTime.now();
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataAtualFormatada = dataAtual.format(formatador);
        return dataAtualFormatada;
    }

    public List<String> lerPerguntasDoFormulario(){
        List<String> perguntas = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(caminhoDoFormulario, StandardCharsets.UTF_8)) {
            String pergunta;

            while ((pergunta = reader.readLine()) != null) {
                perguntas.add(pergunta);
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler ou processar o formulário" + e.getMessage());
        }
        return perguntas;
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
