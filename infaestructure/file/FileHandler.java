package infaestructure.file;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileHandler {
    
    Path caminhoFinalDoArquivo = Paths.get("C:\\Users\\sssantos3\\Documents\\CODE\\Questões\\Desafio\\petsCadastrados");

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
}
