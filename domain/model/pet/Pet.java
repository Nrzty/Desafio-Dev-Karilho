package domain.model.pet;

import domain.model.endereco.Endereco;
import infaestructure.util.ValidacoesInputs;

public class Pet {
    
    private ValidacoesInputs validacoesInputs = new ValidacoesInputs();

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
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.raca = raca;
        this.sexoPet = sexoPet;
        this.tipoPet = tipoPet;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
    }

    public void mudarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()){
            throw new RuntimeException("O nome é obrigatório");
        }
        
        if (validacoesInputs.verificarCaracteresEspeciais(nome)){
            throw new RuntimeException("O nome não pode conter caracteres especiais ou números!");
        }

        this.nome = nome;
    }

    public void mudarSobrenome(String sobrenome) {
        if (validacoesInputs.verificarCaracteresEspeciais(sobrenome)) {
            throw new RuntimeException("O nome não pode conter caracteres especiais!");
        }

        if (sobrenome == null) {
            throw new RuntimeException("O nome é obrigatório!");
        }

        this.sobrenome = sobrenome;
    }

    public void mudarRaca(String raca){
        if (validacoesInputs.verificarCaracteresEspeciais(raca)){
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
        if (idade > 20){
            throw new RuntimeException("A idade não pode ser maior que 20 anos!");
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
        return " 1 - " + validacoesInputs.formatarValorNaoINformado(nome, validacoesInputs.getValorNaoinformado()) + " " + sobrenome + "\n " +
               "3 - " + tipoPet + "\n " +
               "2 - " + sexoPet + "\n " +
               "4 - " + endereco + "\n " +  
               "5 - " + validacoesInputs.formatarValorNaoINformado(idade, validacoesInputs.getValorNaoinformado()) + " anos" + "\n " + 
               "6 - " + validacoesInputs.formatarValorNaoINformado(peso, validacoesInputs.getValorNaoinformado()) + "kg" +"\n " +
               "7 - " + validacoesInputs.formatarValorNaoINformado(raca, validacoesInputs.getValorNaoinformado()); 
    }
}
