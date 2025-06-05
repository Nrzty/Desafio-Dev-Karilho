package domain.model.endereco;

import infaestructure.util.ValidacoesInputs;

public class Endereco {
    
    private ValidacoesInputs validacoesInputs = new ValidacoesInputs();

    private int numeroDaCasa;
    private String cidade;
    private String rua;

    public Endereco(int numeroDaCasa, String cidade, String rua){
        this.numeroDaCasa = numeroDaCasa;
        this.cidade = cidade;
        this.rua = rua;
    }

    public int getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void mudarNumeroDaCasa(int numeroDaCasa) {
        numeroDaCasa = validacoesInputs.pedirNumeroInteiro();

        this.numeroDaCasa = numeroDaCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return "Rua " + validacoesInputs.formatarValorNaoINformado(rua, validacoesInputs.getValorNaoinformado()) + ", " +
               numeroDaCasa + ", " + cidade;
    }
}
