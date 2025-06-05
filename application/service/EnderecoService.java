package application.service;

import domain.model.endereco.Endereco;
import domain.repository.EnderecoRepository;

public class EnderecoService implements EnderecoRepository {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco cadastrarEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new RuntimeException("O endereço não pode ser nulo");
        }

        Endereco enderecoSalvo = enderecoRepository.cadastrarEndereco(endereco);
        return enderecoSalvo;
    }
}
