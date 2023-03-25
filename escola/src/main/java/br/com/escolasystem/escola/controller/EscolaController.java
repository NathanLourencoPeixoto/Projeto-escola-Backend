package br.com.theschool.controller;

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

import br.com.theschool.Shared.Escola.EscolaCompletoDto;
import br.com.theschool.Shared.Escola.EscolaIncompletoDto;
import br.com.theschool.model.Escola;
import br.com.theschool.service.Escola.EscolaServiceImp;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaServiceImp service;

    //Escola
    @PostMapping()
    private ResponseEntity<EscolaCompletoDto> createEscola(@Validated @RequestBody Escola escola)
    {
        return new ResponseEntity<>(service.createEscola(escola), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<EscolaCompletoDto> getEscola( @PathVariable String id)
    {
        Optional<EscolaCompletoDto> escola = service.getEscola(id);

        if(escola.isPresent())
        {
            return new ResponseEntity<>(escola.get(), HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    private ResponseEntity<List<EscolaIncompletoDto>> getEscolas()
    {
        List<EscolaIncompletoDto> escolas = service.getEscolas();
        if(escolas.size() > 0){
            return new ResponseEntity<>(escolas,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<EscolaCompletoDto> editEscola(@Validated @PathVariable String id, @RequestBody Escola escola)
    {
        Optional<EscolaCompletoDto> retorno = service.editEscola(id, escola);
        if(retorno.isPresent())
        {
            return new ResponseEntity<EscolaCompletoDto>(retorno.get(), HttpStatus.FOUND);
        }else
        {
            return new ResponseEntity<EscolaCompletoDto>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteEscola(@PathVariable String id)
    {
        service.deleteEscola(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
