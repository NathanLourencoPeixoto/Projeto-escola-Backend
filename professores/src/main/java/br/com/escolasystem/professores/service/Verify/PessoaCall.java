package br.com.theschoolprofessores.professores.service.Verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.theschoolprofessores.professores.Shared.ProfessorIncomplatoDto;
import br.com.theschoolprofessores.professores.httpClient.PessoaClient;
import br.com.theschoolprofessores.professores.model.Pessoa;
import br.com.theschoolprofessores.professores.model.Professor;

@Service
public class PessoaCall {
    
    @Autowired
    private PessoaClient pessoaClient;

    public Optional<Pessoa> getPessoa(String id)
    {

        try
        {
            Optional<Pessoa> pessoa= pessoaClient.getPessoa(id);

            if(pessoa.isPresent())
            {
                return pessoa;
            }
        }catch(Exception e)
        {
        }
        
        return Optional.empty();
    }

    public List<ProfessorIncomplatoDto> getPessoas(List<Professor> professores)
    {

        List<ProfessorIncomplatoDto> dto = new ArrayList<>();

        if(professores.size()>0)
        {
            for(int i=0; i< professores.size(); i++)
            {
                if(pessoaClient.getPessoa(professores.get(i).getId()).isPresent())
                {
                    dto.add(new ModelMapper().map(professores.get(i),ProfessorIncomplatoDto.class));
                }
            }

            for(int i=0;i<dto.size();i++)
            {
                pessoaClient.getPessoa(dto.get(i).getId()).get();
                dto.get(i).setCpf(pessoaClient.getPessoa(dto.get(i).getId()).get().getCpf());
                dto.get(i).setNome(pessoaClient.getPessoa(dto.get(i).getId()).get().getNome());
            }

            return dto;
        }else
        {
            return null;
        }
    }

}
