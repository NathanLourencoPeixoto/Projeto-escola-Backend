package br.com.theschoolprofessores.professores.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.theschoolprofessores.professores.Shared.ProfessorCompletoDto;
import br.com.theschoolprofessores.professores.Shared.ProfessorIncomplatoDto;
import br.com.theschoolprofessores.professores.service.ProfessorServiceImplement;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    
    @Autowired
    private ProfessorServiceImplement service;

    @PostMapping()
    private ResponseEntity<ProfessorCompletoDto> createProfessor(@RequestBody ProfessorIncomplatoDto dto)
    {
        Optional<ProfessorCompletoDto> retorno = service.createProfessor(dto);

        if(retorno.isPresent())
        {
            return new ResponseEntity<>(retorno.get(), HttpStatus.CREATED);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<ProfessorCompletoDto> getProfessor(@PathVariable String id)
    {
        Optional<ProfessorCompletoDto> retorno = service.getProfessor(id);

        if(retorno.isPresent())
        {
            return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    private ResponseEntity<List<ProfessorIncomplatoDto>> getProfessores()
    {
        List<ProfessorIncomplatoDto> retorno = service.getProfessoresList();

        return new ResponseEntity<>(retorno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ProfessorCompletoDto> editProfessor(@PathVariable String id, @RequestBody ProfessorIncomplatoDto dto)
    {
        Optional<ProfessorCompletoDto> retorno = service.editProfessor(id, dto);

        if(retorno.isPresent())
        {
            return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    private ResponseEntity<ProfessorCompletoDto> editProfessor(@PathVariable String id)
    {
        service.deleteProfessor(id);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }


}
