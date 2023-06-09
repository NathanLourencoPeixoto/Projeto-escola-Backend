package br.com.escolasystem.professores.service.AtributeValues;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escolasystem.professores.httpClient.PessoaClient;
import br.com.escolasystem.professores.model.Pessoa;

@Service
public class SetPessoas {
    
    @Autowired
    private PessoaClient pessoaClient;

    public Optional<Pessoa> updatePessoaCargo(String id,String cargo)
    {

        Optional<Pessoa> pessoa = pessoaClient.getPessoa(id);

        if(pessoa.isPresent())
        {
            pessoa.get().setTrabalho(cargo);
            pessoaClient.updatePessoa(id, pessoa.get());

            return pessoa;
        
        }else
        {
            return Optional.empty();
        }
    }

}
