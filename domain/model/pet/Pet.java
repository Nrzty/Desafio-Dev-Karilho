package domain.model.pet;

import java.util.ArrayList;
import java.util.List;

import domain.model.endereco.Endereco;
import infrastructure.util.ValidarStrings;

public class Pet {

    private String nome;
    private String sobrenome;
    private String raca;

    private SexoPet sexoPet;
    private TipoPet tipoPet;

    private Endereco endereco;

    private double idade;
    
    private double peso; 

    public Pet(String nome, String sobrenome, String raca, SexoPet sexoPet, TipoPet tipoPet, Endereco endereco,
            double idade, double peso) {
        mudarNome(nome);
        mudarSobrenome(sobrenome);
        this.raca = raca;
        this.sexoPet = sexoPet;
        this.tipoPet = tipoPet;
        this.endereco = endereco;
        mudarIdade(idade);
        mudarPeso(peso);
    }

    public List<String> getRespostasParaArquivo(){
        List<String> respostas = new ArrayList<>();

        String enderecoFormatado = "Rua " + ValidarStrings.formatarValorNaoInformado(getEndereco().getRua(), ValidarStrings.VALOR_NAO_INFORMADO) +
                              ", " + getEndereco().getNumeroDaCasa() +
                              ", " + ValidarStrings.formatarValorNaoInformado(getEndereco().getCidade(), ValidarStrings.VALOR_NAO_INFORMADO);

        String nomeCompleto = ValidarStrings.formatarValorNaoInformado(this.nome, " ") + " " + ValidarStrings.formatarValorNaoInformado(this.sobrenome, "");

        respostas.add(nomeCompleto.trim());
        respostas.add(this.tipoPet.toString());
        respostas.add(this.sexoPet.toString());
        respostas.add(enderecoFormatado);
        respostas.add(this.idade + " anos");
        respostas.add(this.peso + "kg");
        respostas.add(ValidarStrings.formatarValorNaoInformado(this.raca, ValidarStrings.VALOR_NAO_INFORMADO));

        return respostas;
    }

    public void mudarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()){
            throw new RuntimeException("O nome é obrigatório");
        }
        
        if (ValidarStrings.verificarCaracteresEspeciais(nome)){
            throw new RuntimeException("O nome não pode conter caracteres especiais ou números!");
        }

        this.nome = nome;
    }

    public void mudarSobrenome(String sobrenome) {
        if (ValidarStrings.verificarCaracteresEspeciais(sobrenome)) {
            throw new RuntimeException("O nome não pode conter caracteres especiais!");
        }

        if (sobrenome == null) {
            throw new RuntimeException("O nome é obrigatório!");
        }

        this.sobrenome = sobrenome;
    }

    public void mudarRaca(String raca){
        if (ValidarStrings.verificarCaracteresEspeciais(raca)){
            throw new RuntimeException("A raça não pode conter números nem caracteres especiais!");
        }

        this.raca = raca;
    }

    public void mudarPeso(double peso){
        if (peso > 60 || peso < 0.5){
            throw new RuntimeException("O peso precisa ser menor que 60Kg e maior que 0.5Kg!");
        }

        this.peso = peso;
    }

    public void mudarIdade(double idade){
        if (idade > 20 || idade < 0){
            throw new RuntimeException("A idade tem que ser entre 0 a 20 anos!");
        }

        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getRaca() {
        return raca;
    }

    public SexoPet getSexoPet() {
        return sexoPet;
    }

    public TipoPet getTipoPet() {
        return tipoPet;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return " 1 - " + ValidarStrings.formatarValorNaoInformado(nome, ValidarStrings.VALOR_NAO_INFORMADO) + " " + sobrenome + "\n " +
               "3 - " + tipoPet + "\n " +
               "2 - " + sexoPet + "\n " +
               "4 - " + endereco + "\n " +  
               "5 - " + ValidarStrings.formatarValorNaoInformado(idade, ValidarStrings.VALOR_NAO_INFORMADO) + " anos" + "\n " + 
               "6 - " + ValidarStrings.formatarValorNaoInformado(peso, ValidarStrings.VALOR_NAO_INFORMADO) + "kg" +"\n " +
               "7 - " + ValidarStrings.formatarValorNaoInformado(raca, ValidarStrings.VALOR_NAO_INFORMADO); 
    }
}
