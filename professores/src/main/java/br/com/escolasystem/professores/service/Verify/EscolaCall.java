package br.com.escolasystem.professores.service.Verify;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escolasystem.professores.httpClient.EscolaClient;
import br.com.escolasystem.professores.model.Escola;

@Service
public class EscolaCall {
    
    @Autowired
    private EscolaClient escolaClient;

    public Optional<Escola> getEscola(String id)
    {

        try
        {
            Optional<Escola> escola = escolaClient.getEscola(id);
            
            if(escola.isPresent())
            {
                return escola;
            }

        }catch(Exception e)
        {
            
        }
        return Optional.empty();



    }

}
