package br.com.theschool.service.Escola;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.theschool.Shared.Escola.EscolaCompletoDto;
import br.com.theschool.Shared.Escola.EscolaIncompletoDto;
import br.com.theschool.model.Aluno;
import br.com.theschool.model.Escola;
import br.com.theschool.model.Sala;
import br.com.theschool.repository.AlunoRepository;
import br.com.theschool.repository.EscolaRepository;
import br.com.theschool.repository.SalaRepository;

@Service
public class EscolaServiceImp implements EscolaService{

    @Autowired
    private EscolaRepository repositorio;

    @Autowired
    private SalaRepository salaRepositorio;

    @Autowired
    private AlunoRepository alunoRepository;

    //Escolas
    @Override
    public EscolaCompletoDto createEscola(Escola escola) {
        
        EscolaCompletoDto retorno = new ModelMapper().map(escola, EscolaCompletoDto.class);

        repositorio.save(escola);

        return retorno;
    }

    @Override
    public Optional<EscolaCompletoDto> getEscola(String id) {

        Optional<Escola> escola = repositorio.findById(id);
        List<String> alunosId = escola.get().getAlunos();
        List<String> salasId = escola.get().getSalas();
        List<Aluno> alunosRepo = alunoRepository.findAll();
        List<Aluno> alunos = new ArrayList<>();
        List<Sala> salas = new ArrayList<>();

        if(salasId != null){
            for(int i=0;i<salasId.size();i++){
                if(salasId.get(i) == null)
                {
                    salasId.remove(i);
                } 
            }
        }

        if(alunosId != null){
            for(int i=0;i<alunosId.size();i++){
                if(alunosId.get(i) == null)
                {
                    alunosId.remove(i);
                }
            }
        }

        for(int a=0; a< alunosRepo.size();a++){
            if(alunosRepo.get(a).getEscolaId()!= null && alunosRepo.get(a).getEscolaId().equals(escola.get().getId()))
            {
                alunos.add(alunosRepo.get(a));
            }
        }

        if(escola.get().getSalas() !=null)
        {
            for(int i=0;i<escola.get().getSalas().size();i++){
                
                Optional<Sala> sala = salaRepositorio.findById(escola.get().getSalas().get(i));

                if(sala.isPresent())
                {
                    salas.add(sala.get());
                }
            }
        }
        
        escola.get().setAlunosQuantid(alunos.size());
        escola.get().setSalaQuantid(salas.size());
        escola.get().setAlunos(alunosId);
        escola.get().setSalas(salasId);

        repositorio.save(escola.get());
        
        EscolaCompletoDto retorno = new ModelMapper().map(escola, EscolaCompletoDto.class);
        
        retorno.setSalas(salas);
        retorno.setAlunos(alunos);

        return Optional.of(retorno);
    }

    @Override
    public List<EscolaIncompletoDto> getEscolas() {

        List<Escola> escolas = repositorio.findAll();
        List<EscolaIncompletoDto> retorno = new ArrayList<>();

        List<Aluno> alunos = alunoRepository.findAll();
        List<Sala> salas = salaRepositorio.findAll();
        
        for(int i=0;i<escolas.size();i++){
            

            for(int a=0;a<alunos.size();a++)
            {
                if(alunos.get(a).getEscolaId() == null || !alunos.get(a).getEscolaId().equals(escolas.get(i).getId()))
                {
                    alunos.remove(alunos.get(a));
                }
            }

            if(escolas.get(i).getAlunos() != null){
                for(int s=0;s<escolas.get(i).getAlunos().size();s++)
                {
                    if(escolas.get(i).getAlunos().get(s) == null)
                    {
                        escolas.get(i).getAlunos().remove(s);
                    }
                }
            }

            for(int s=0;s<salas.size();s++)
            {
                if(salas.get(s).getId() == null || !escolas.get(i).getSalas().contains(salas.get(s).getId()))
                {
                    salas.remove(salas.get(s));
                }

            }
        
            escolas.get(i).setSalaQuantid(salas.size());
            escolas.get(i).setAlunosQuantid(alunos.size());

            retorno.add(new ModelMapper().map(escolas.get(i), EscolaIncompletoDto.class));
            
        }

        return retorno;
    }


    @Override
    public Optional<EscolaCompletoDto> editEscola(String id, Escola escola) {
        
        Optional<Escola> escolaVelha = repositorio.findById(id);

        if(escolaVelha.isPresent())
        {
            if(escola.getAlunos() != null){
                escola.setAlunosQuantid(escola.getAlunos().size());
            } 

            escola.setSalas(escolaVelha.get().getSalas());
            escola.setSalaQuantid(escola.getSalas().size());
            escola.setAlunosQuantid(escola.getSalas().size());
            
            escola.setId(id);
            EscolaCompletoDto retorno = new ModelMapper().map(escola, EscolaCompletoDto.class);
            
            repositorio.save(escola);
            return Optional.of(retorno);
        }else
        {
            return Optional.empty();
        }
        
    }

    @Override
    public Optional<Void> deleteEscola(String id) {

        Optional<Escola> escola = repositorio.findById(id);
        
        if(escola.isPresent())
        {
            repositorio.deleteById(id);
        }else
        {
            return Optional.empty();
        }

        return Optional.empty();
        
    }
    
}
