package br.com.theschool.service.Sala;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.theschool.Shared.Sala.SalaCompletoDto;
import br.com.theschool.Shared.Sala.SalaDto;
import br.com.theschool.model.Aluno;
import br.com.theschool.model.Escola;
import br.com.theschool.model.Sala;
import br.com.theschool.repository.AlunoRepository;
import br.com.theschool.repository.EscolaRepository;
import br.com.theschool.repository.SalaRepository;

@Service
public class SalaServiceImp implements SalaService{

    @Autowired
    private EscolaRepository repositorio;

    @Autowired
    private SalaRepository salaRepositorio;

    @Autowired
    private AlunoRepository alunoRepository;

    //POST
    @Override
    public Optional<SalaCompletoDto> createSala(String escola,Sala sala)
    {

        Optional<Escola> escolaRetorno = repositorio.findById(escola);

        if(escolaRetorno.isPresent())
        {
            sala.setEscolaId(escola);

            if(sala.getAlunos() != null)
            {
            sala.setAlunosQuantid(sala.getAlunos().size());
            }
            salaRepositorio.save(sala); 
            
            List<String> salaEscola = new ArrayList<>();
            
            if(escolaRetorno.get().getSalas() != null){
                salaEscola = escolaRetorno.get().getSalas();
            }
            
            salaEscola.add(sala.getId());
            
            escolaRetorno.get().setSalas(salaEscola);
            
            SalaCompletoDto dto = new ModelMapper().map(sala, SalaCompletoDto.class);
            List<Aluno> alunos = new ArrayList<>();
            
            if(dto.getAlunos()!=null){
                for(int i=0;i< dto.getAlunos().size();i++)
                {
                    Optional<Aluno> alunoResposta = alunoRepository.findById(sala.getAlunos().get(i));

                    if(alunoResposta.isPresent())
                    {
                        Aluno atualizarEstudante = alunoRepository.findById(alunoResposta.get().getId()).get();
                        
                        
                        atualizarEstudante.setSalaId(escola);
                        atualizarEstudante.setId(atualizarEstudante.getId());
                        alunoRepository.save(atualizarEstudante);
                        
                        alunos.add(atualizarEstudante);
                    }else{
                        salaRepositorio.deleteById(sala.getId());
                        return Optional.empty();
                    }
                }
            }
            dto.setAlunos(alunos);
            
            repositorio.save(escolaRetorno.get());
            return Optional.of(dto);
        }else
        {
            return Optional.empty();
        }

    }

    //GET
    @Override
    public Optional<SalaCompletoDto> getSala(String escola, String id) {
        
        Optional<Escola> escolaFound = repositorio.findById(escola);
        Optional<Sala> sala = salaRepositorio.findById(id);

        if(sala.isPresent() && escolaFound.isPresent())
        {
            List<Aluno> alunos = new ArrayList<>();
            if(escolaFound.get().getSalas() == null || !escolaFound.get().getSalas().contains(sala.get().getId()) || escolaFound.get().getSalas().isEmpty())
            {
                List<String> salas = new ArrayList<>();

                if(escolaFound.get().getSalas() != null)
                {
                    salas = escolaFound.get().getSalas();
                }
                salas.add(sala.get().getId());
                escolaFound.get().setSalas(salas);
            }

            //pessoas

            if(sala.get().getAlunos() != null){
                for(int i=0;i<sala.get().getAlunos().size();i++)
                {
                    if(alunoRepository.findById(sala.get().getAlunos().get(i)).isPresent())
                    {
                        alunos.add(alunoRepository.findById(sala.get().getAlunos().get(i)).get()); 
                    }else
                    {
                    }
                }
            }

            SalaCompletoDto dto = new ModelMapper().map(sala.get(), SalaCompletoDto.class);
            repositorio.save(escolaFound.get());
            dto.setAlunos(alunos);
            dto.setAlunosQuantid(alunos.size());

            return Optional.of(dto);
        }else
        {
            return Optional.empty();
        }

    }

    //GET-LIST
    @Override
    public List<SalaDto> getSalas(String escola) {
        
        Optional<Escola> escolaResponse = repositorio.findById(escola);
        List<Sala> salas = salaRepositorio.findAll();
        List<SalaDto> dto = new ArrayList<>();

        for(int i=0;i<salas.size();i++)
        {
            if(escolaResponse.get().getSalas() != null && escolaResponse.get().getSalas().contains(salas.get(i).getId()))
            {
                dto.add(new ModelMapper().map(salas.get(i), SalaDto.class));
                
            }else if(salas.get(i).getEscolaId().equals(escola))
            {
                List<String> salasId = new ArrayList<>();
                
                if(escolaResponse.get().getSalas() != null)
                {
                    salasId = escolaResponse.get().getSalas();
                }
                salasId.add(salas.get(i).getId());
                escolaResponse.get().setSalas(salasId);
                repositorio.save(escolaResponse.get());
            }
        }

        return dto;
    }

    //PUT
    @Override
    public Optional<SalaCompletoDto> editSala(String escola,String id, Sala sala) {
        
        Optional<Sala> oldSala = salaRepositorio.findById(id);

        if(oldSala.isPresent())
        {
            sala.setId(id);
            
            if(sala.getAlunos() != null)
            {
            sala.setAlunosQuantid(sala.getAlunos().size());
            }

            sala.setEscolaId(escola);
            List<Aluno> alunos = new ArrayList<>();
            
            if(sala.getAlunos() != null){
                for(int i=0;i<sala.getAlunos().size();i++)
                {
                    Optional<Aluno> alunoResposta = alunoRepository.findById(sala.getAlunos().get(i));
                    
                    if(alunoResposta.isPresent())
                    {
                        alunos.add(alunoResposta.get()); 
                    }else
                    {
                        return Optional.empty();
                    }
                }
            
            }
            salaRepositorio.save(sala);

            
            
            SalaCompletoDto retorno = new ModelMapper().map(sala,SalaCompletoDto.class);
            retorno.setAlunos(alunos);
            return  Optional.of(retorno);

        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Void> deleteSala(String escola,String id) {
        
        if(Optional.of(salaRepositorio.findById(id)).isPresent())
        {
            salaRepositorio.deleteById(id);
        }else
        {
            return Optional.empty();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Void> clearSalas(String escola) {
        
        Optional<Escola> escolaRetorno = repositorio.findById(escola);

        if(escolaRetorno.isPresent()){
            if(escolaRetorno.get().getSalas().size()>0){
                for(int i=0; i<escolaRetorno.get().getSalas().size();i++)
                {
                    salaRepositorio.deleteById(escolaRetorno.get().getSalas().get(i));
                }
                escolaRetorno.get().setSalas(null);

            }
        }
        return Optional.empty();
    }
    
}
