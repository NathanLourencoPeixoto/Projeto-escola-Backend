package br.com.escolasystem.escola.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.escolasystem.escola.Shared.Sala.SalaCompletoDto;
import br.com.escolasystem.escola.Shared.Sala.SalaDto;
import br.com.escolasystem.escola.model.Sala;
import br.com.escolasystem.escola.service.Sala.SalaServiceImp;

@RestController
@RequestMapping("/escolas")
public class SalaController {
    
    @Autowired
    private SalaServiceImp salaService;

    //Salas
    @PostMapping("/{escola}/salas")
    private ResponseEntity<SalaCompletoDto> createSala(@Validated @PathVariable String escola, @RequestBody Sala sala)
    {
        Optional<SalaCompletoDto> retorno = salaService.createSala(escola,sala);

        if(retorno.isPresent())
        {

            return new ResponseEntity<>(retorno.get(), HttpStatus.CREATED);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{escola}/salas/{id}")
    private ResponseEntity<SalaCompletoDto> getSala(@PathVariable String escola, @PathVariable String id)
    {
        Optional<SalaCompletoDto> dto = salaService.getSala(escola,id);

        if(dto.isPresent())
        {
            return new ResponseEntity<>(dto.get(), HttpStatus.FOUND);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{escola}/salas")
    private ResponseEntity<List<SalaDto>> getSalas(@PathVariable String escola)
    {
        List<SalaDto> salas = salaService.getSalas(escola);

        if(salas.size() > 0)
        {
            return new ResponseEntity<>(salas, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{escola}/salas/{id}")
    private ResponseEntity<SalaCompletoDto> updateSala(@Validated @PathVariable String escola, @PathVariable String id, @RequestBody Sala sala)
    {
        Optional<SalaCompletoDto> retorno = salaService.editSala(escola,id,sala);

        if(retorno.isPresent())
        {
            return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{escola}/salas/{id}")
    private ResponseEntity<Void> deleteSala( @PathVariable String escola,@PathVariable String id)
    {
        salaService.deleteSala(escola,id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{escola}/salas/clear")
    private ResponseEntity<Void> clearSalas(@PathVariable String escola)
    {
        salaService.clearSalas(escola);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
