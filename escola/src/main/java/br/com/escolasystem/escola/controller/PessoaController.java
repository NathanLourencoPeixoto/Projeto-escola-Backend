package br.com.theschool.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.theschool.Shared.Aluno.AlunoCompletoDto;
import br.com.theschool.Shared.Aluno.AlunoDto;
import br.com.theschool.model.Aluno;
import br.com.theschool.service.Aluno.AlunoServiceImp;

@RestController
@RequestMapping("/escolas")
public class PessoaController {
    
    //Alunos
    @Autowired
    private AlunoServiceImp alunosService;

    @PostMapping("/{escolaId}/alunos")
    private ResponseEntity<AlunoCompletoDto> createAluno(@Validated @PathVariable String escolaId, @RequestBody Aluno aluno)
    {
        Optional<AlunoCompletoDto> retorno = alunosService.createAluno(escolaId, aluno.getId(), aluno);

        if(retorno.isPresent())
        {
            return new ResponseEntity<>(retorno.get(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{escolaId}/alunos/{id}")
    private ResponseEntity<AlunoCompletoDto> getAluno(@PathVariable String escolaId,@PathVariable String id)
    {
        Optional<AlunoCompletoDto> retorno = alunosService.getAluno(escolaId, id);

        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{escolaId}/alunos")
    private ResponseEntity<List<AlunoDto>> getAlunos(@PathVariable String escolaId)
    {
        List<AlunoDto> listaAlunos = alunosService.getAlunos(escolaId);
        List<AlunoDto> retorno = new ArrayList<>();

        for(int i=0;i<listaAlunos.size();i++)
        {
            retorno.add(new ModelMapper().map(listaAlunos.get(i),AlunoDto.class));
        }

        return new ResponseEntity<>(retorno, HttpStatus.FOUND);
    }

    @PutMapping("/{escolaId}/alunos/{id}")
    private ResponseEntity<AlunoCompletoDto> editAluno(@Validated @PathVariable String escolaId, @PathVariable String id,@RequestBody Aluno aluno)
    {
        Optional<AlunoCompletoDto> retorno = alunosService.editAluno(escolaId, id, aluno);

        if(retorno.isPresent())
        {
            return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{escolaId}/alunos/{id}")
    private ResponseEntity<Void> removeAluno(@PathVariable String escolaId,@PathVariable String id)
    {
        alunosService.removeAluno(escolaId,id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
