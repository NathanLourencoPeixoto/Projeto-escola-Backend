package br.com.escolasystem.professores.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escolasystem.professores.Shared.ProfessorCompletoDto;
import br.com.escolasystem.professores.Shared.ProfessorIncomplatoDto;
import br.com.escolasystem.professores.model.Escola;
import br.com.escolasystem.professores.model.Pessoa;
import br.com.escolasystem.professores.model.Professor;
import br.com.escolasystem.professores.repository.ProfessorRepository;
import br.com.escolasystem.professores.service.AtributeValues.SetPessoas;
import br.com.escolasystem.professores.service.Verify.EscolaCall;
import br.com.escolasystem.professores.service.Verify.PessoaCall;

@Service
public class ProfessorServiceImplement implements ProfessorService{

    @Autowired
    private PessoaCall pessoaCall;
    
    @Autowired
    private EscolaCall escolaCall;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private SetPessoas setPessoas;


    @Override
    public Optional<ProfessorCompletoDto> createProfessor(ProfessorIncomplatoDto dto) {

        Professor professor = new ModelMapper().map(dto, Professor.class);
        ProfessorCompletoDto dtoC = new ModelMapper().map(professor, ProfessorCompletoDto.class);

        Optional <Pessoa> pessoaResposta = pessoaCall.getPessoa(professor.getId());
        Optional<Escola> escolaResposta =  escolaCall.getEscola(professor.getEscolaId());

        System.out.println(pessoaResposta.isPresent() + " " + escolaResposta.isPresent());

        if(pessoaResposta.isPresent() && escolaResposta.isPresent())
        {

            if(setPessoas.updatePessoaCargo(professor.getId(), "Professor de " + dto.getMateria()).isPresent())
            {
                professorRepository.save(professor);
                dtoC.setCpf(pessoaCall.getPessoa(professor.getId()).get().getCpf());
                dtoC.setNome(pessoaCall.getPessoa(professor.getId()).get().getNome());
                dtoC.setIdade(pessoaCall.getPessoa(professor.getId()).get().getIdade());
                dtoC.setEscolaName(escolaCall.getEscola(professor.getEscolaId()).get().getNome());

            }else
            {
                return Optional.of(new ModelMapper().map(professor, ProfessorCompletoDto.class));
            }
            return Optional.of(dtoC);

        }else
        {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProfessorCompletoDto> getProfessor(String id) {
        
        Optional<Professor> professor = professorRepository.findById(id);

        if(professor.isPresent())
        {
            ProfessorCompletoDto dto = new ModelMapper().map(professor.get(), ProfessorCompletoDto.class);
            Optional<Pessoa> Pcall = pessoaCall.getPessoa(id);
            Optional<Escola> eCall = escolaCall.getEscola(professor.get().getEscolaId());
            
            if(eCall.isPresent())
            {
                dto.setEscolaName(eCall.get().getNome());
            }else{
                dto.setEscolaName(null);
            }

            if(Pcall.isPresent())
            {
                dto.setCpf(Pcall.get().getCpf());
                dto.setIdade(Pcall.get().getIdade());
                dto.setNome(Pcall.get().getNome());
            }else
            {
                dto.setCpf(null);
                dto.setIdade(0);
                dto.setNome(null);
            }

            return Optional.of(dto);
            
        }else
        {
            return Optional.empty();
        }
        
    }

    @Override
    public List<ProfessorIncomplatoDto> getProfessoresList() {

        List<Professor> professores = professorRepository.findAll();

        List<ProfessorIncomplatoDto> dto = pessoaCall.getPessoas(professores);

        return dto;

    }

    @Override
    public Optional<ProfessorCompletoDto> editProfessor(String id, ProfessorIncomplatoDto dto) {
        
        Optional<Professor> oldUser = professorRepository.findById(id);
        
        if(oldUser.isPresent() && pessoaCall.getPessoa(id).isPresent() && escolaCall.getEscola(dto.getEscolaId()).isPresent())
        {
            if(setPessoas.updatePessoaCargo(id, "Professor de " + dto.getMateria()).isPresent())
            {

                dto.setId(id);
                professorRepository.save(new ModelMapper().map(dto, Professor.class));
                
                ProfessorCompletoDto retorno = new ModelMapper().map(dto, ProfessorCompletoDto.class);
                
                retorno.setCpf(pessoaCall.getPessoa(id).get().getCpf());
                retorno.setNome(pessoaCall.getPessoa(id).get().getNome());
                retorno.setIdade(pessoaCall.getPessoa(id).get().getIdade());
                retorno.setEscolaName(escolaCall.getEscola(dto.getEscolaId()).get().getNome());
                
                return Optional.of(retorno);

            }else{
                return Optional.empty();
            }


        }else{

        return Optional.empty();

        }
    }

    @Override
    public Optional<Void> deleteProfessor(String id) {
        
        Optional<Professor> professor = professorRepository.findById(id);

        if(professor.isPresent())
        {
            if(setPessoas.updatePessoaCargo(id, null).isPresent())
            {
                professorRepository.deleteById(id);
            }
        }
        return Optional.empty();
    }
    
}
