package br.com.theschoolprofessores.professores.httpClient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.theschoolprofessores.professores.model.Escola;

@FeignClient("schools")
public interface EscolaClient {
    
    @RequestMapping(method = RequestMethod.GET,value = "/escolas/{id}")
  Optional<Escola> getEscola( @PathVariable String id);


    @RequestMapping(method = RequestMethod.PUT,value = "/escolas/{id}",consumes = "application/json")
    Optional<Escola> updateEscolas(@PathVariable String id,Escola escola);

}
