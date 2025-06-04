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
        if (validacoesInputs.verificarCaracteresEspeciais(nome)) {
            throw new RuntimeException("O nome não pode conter caracteres especiais!");
        }
        
        this.nome = nome;
    }

    public void mudarSobrenome(String sobrenome) {
        if (validacoesInputs.verificarCaracteresEspeciais(nome)) {
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

        if (idade < 1) {
            this.idade = idade / 12;
        }

        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome=" + validacoesInputs.formatarValorNaoINformado(nome, validacoesInputs.getValorNaoinformado()) +
             ", Sobrenome=" + sobrenome + 
             ", Raca=" + validacoesInputs.formatarValorNaoINformado(raca, validacoesInputs.getValorNaoinformado()) +
             ", SexoPet=" + sexoPet +
             ", TipoPet=" + tipoPet + 
             ", Endereco=" + endereco + 
             ", Idade=" + validacoesInputs.formatarValorNaoINformado(idade, validacoesInputs.getValorNaoinformado()) + 
             ", Peso=" + validacoesInputs.formatarValorNaoINformado(peso, validacoesInputs.getValorNaoinformado());
    }
}
