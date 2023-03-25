package br.com.theschool.service.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import br.com.theschool.Shared.Aluno.AlunoCompletoDto;
import br.com.theschool.Shared.Aluno.AlunoDto;
import br.com.theschool.httpClient.PessoaClient;
import br.com.theschool.model.Aluno;
import br.com.theschool.model.Escola;
import br.com.theschool.model.Pessoa;
import br.com.theschool.model.Sala;
import br.com.theschool.repository.AlunoRepository;
import br.com.theschool.repository.EscolaRepository;
import br.com.theschool.repository.SalaRepository;

@Service
public class AlunoServiceImp implements AlunoService{

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private PessoaClient pessoaClient;

    @Override
    public Optional<AlunoCompletoDto> createAluno(String escolaId, String id, Aluno aluno) {

        Optional<Escola> escola = escolaRepository.findById(escolaId);
        
        Optional<Pessoa> alunoRequest = Optional.empty();
        Optional<Pessoa> responsavelRequest = Optional.empty();

        try {
            alunoRequest = pessoaClient.getPessoa(id).getBody();
            responsavelRequest = pessoaClient.getPessoa(aluno.getResponsavelId()).getBody();
        } catch (Exception e) {
            return Optional.empty();
        }

        if(escola.isPresent() && alunoRequest.isPresent() && responsavelRequest.isPresent())
        {
            aluno.setId(id);
            aluno.setIdade(alunoRequest.get().getIdade());
            aluno.setName(alunoRequest.get().getNome());
            aluno.setEscolaId(escolaId);

            Double media = 0.0;
            int quantid = 0;

            for(int i=0;i<aluno.getNotas().size();i++)
            {
                media += aluno.getNotas().get(i);
                quantid+=1;
            }

            media = media/quantid;

            aluno.setMediaGeral(media);

            if(aluno.getSalaId()!=null && aluno.getSalaId()!="")
            {
                Optional<Sala> salaResposta = salaRepository.findById(aluno.getSalaId());

                if(salaResposta.isPresent())
                {
                    List<String> alunosList = new ArrayList<>();
                    
                    if(salaResposta.get().getAlunos()!= null)
                    {
                        alunosList = salaResposta.get().getAlunos();
                    }

                    System.out.println(aluno.getId());
                    int alunosCount = salaResposta.get().getAlunosQuantid() + 1;
                    
                    alunosList.add(aluno.getId());
                    
                    salaResposta.get().setAlunosQuantid(alunosCount);
                    salaResposta.get().setAlunos(alunosList);
                    
                    salaRepository.save(salaResposta.get());
                }else
                {
                    return Optional.empty();
                }
            }

            repository.save(aluno);

            AlunoCompletoDto retorno = new ModelMapper().map(aluno, AlunoCompletoDto.class);
            retorno.setSalaNome(salaRepository.findById(retorno.getSalaId()).get().getName());
            retorno.setResponsavelId(responsavelRequest.get());

            //pesssoais
            alunoRequest.get().setCargo("Estudante");

            pessoaClient.updatePessoa(id, alunoRequest.get());

            return Optional.of(retorno);
        }else
        {
            return Optional.empty();
        }
    }

    @Override
    public Optional<AlunoCompletoDto> getAluno(String escolaId, String id) {
        
        Optional<Aluno> aluno = repository.findById(id);
        
        if(aluno.isPresent() && aluno.get().getEscolaId() != null && aluno.get().getEscolaId().equals(escolaId))
        {
            Optional<Sala> sala = salaRepository.findById(aluno.get().getSalaId());

            if(!sala.isPresent() || sala.get().getAlunos() ==null || !sala.get().getAlunos().contains(aluno.get().getId()))
            {
                aluno.get().setSalaId("");
               repository.save(aluno.get());
                
            }

            AlunoCompletoDto retorno = new ModelMapper().map(aluno, AlunoCompletoDto.class);

            retorno.setResponsavelId(pessoaClient.getPessoa(aluno.get().getResponsavelId()).getBody().get());

            return Optional.of(retorno);
        }else
        {
            return Optional.empty();
        }

    }

    @Override
    public List<AlunoDto> getAlunos(String escolaId) {
        
        List<Aluno> alunos = repository.findAll();
        List<AlunoDto> retorno = new ArrayList<>();

        
        for(int i=0;i<alunos.size();i++)
        {
            Optional<Sala> sala = salaRepository.findById(alunos.get(i).getSalaId());

            String id = alunos.get(i).getEscolaId();
            
            if(id != null)
            {
                if(id.equals(escolaId))
                {
                    if(!sala.isPresent() || sala.get().getAlunos() == null || !sala.get().getAlunos().contains(alunos.get(i).getId()))
                    {
                        alunos.get(i).setSalaId("");
                        repository.save(alunos.get(i));
                    }
                    retorno.add(new ModelMapper().map(alunos.get(i), AlunoDto.class));
                }
            }

           }

        return retorno;
    }

    @Override
    public Optional<AlunoCompletoDto> editAluno(String escolaId, String id, Aluno aluno) {
        
        Optional<Aluno> alunoAntigo = repository.findById(id);
        
        Optional<Pessoa> alunoRequest = Optional.empty();
        Optional<Pessoa> responsavelRequest = Optional.empty();
        
        if(pessoaClient.getPessoa(id).getStatusCode() == HttpStatusCode.valueOf(200) && pessoaClient.getPessoa(aluno.getResponsavelId()).getStatusCode() == HttpStatusCode.valueOf(200)){
            try {
                responsavelRequest = pessoaClient.getPessoa(aluno.getResponsavelId()).getBody();
                alunoRequest = pessoaClient.getPessoa(id).getBody();
                
            } catch (Exception e) {
                return Optional.empty();
            }
        }

        if(alunoAntigo.get().getEscolaId() == null)
        {
            alunoAntigo.get().setEscolaId(escolaId);
        }

        if(alunoAntigo.isPresent()&&alunoAntigo.get().getEscolaId().equals(escolaId))
        {
            aluno.setId(id);
            aluno.setIdade(alunoRequest.get().getIdade());
            aluno.setName(alunoRequest.get().getNome());
            aluno.setEscolaId(escolaId);

            Double media = 0.0;
            int quantid = 0;

            for(int i=0;i<aluno.getNotas().size();i++)
            {
                media += aluno.getNotas().get(i);
                quantid+=1;
            }

            media = media/quantid;

            aluno.setMediaGeral(media);

            if(aluno.getSalaId()!=null &&aluno.getSalaId()!="")
            {
                Optional<Sala> salaResposta = salaRepository.findById(aluno.getSalaId());

                if(salaResposta.isPresent())
                {
                    List<String> alunosList = new ArrayList<>();
                    
                    if(salaResposta.get().getAlunos() != null)
                    {
                        salaResposta.get().getAlunos();
                    }

                    alunosList.add(aluno.getId());
                    
                    salaResposta.get().setAlunos(alunosList);
                    salaResposta.get().setEscolaId(escolaId);
                    salaRepository.save(salaResposta.get());
                }else
                {
                    return Optional.empty();
                }
            }

            repository.save(aluno);

            AlunoCompletoDto retorno = new ModelMapper().map(aluno, AlunoCompletoDto.class);

            retorno.setResponsavelId(responsavelRequest.get());

            return Optional.of(retorno);


        }else
        {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Void> removeAluno(String escolaId, String id) {
        
        Optional<Aluno> aluno = repository.findById(id);

        if(aluno.isPresent() && aluno.get().getEscolaId() != null && aluno.get().getEscolaId().equals(escolaId))
        {
            Optional<Escola> escola = escolaRepository.findById(escolaId);

            for(int i =0; i<escola.get().getAlunos().size();i++)
            {
                if(escola.get().getAlunos().get(i) == null)
                {
                    if(escola.get().getAlunos().get(i).equals(id))
                    {
                        escola.get().getAlunos().remove(escola.get().getAlunos().get(i));
                    }
                    escolaRepository.save(escola.get());
                }
            }

            List<Sala> salas = salaRepository.findAll();
            for(int i=0;i<salas.size();i++)
            {
                for(int a=0;a<salas.get(i).getAlunos().size();a++)
                {
                    salas.get(i).getAlunos().remove(salas.get(i).getAlunos().get(a));
                }
                salaRepository.save(salas.get(i));
            }


            repository.deleteById(id);
        }else
        {
            return Optional.empty();
        }

        return Optional.empty();

    }
    
}
