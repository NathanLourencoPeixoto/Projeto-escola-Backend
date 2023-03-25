package br.com.theschool.httpClient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.theschool.model.Pessoa;

@FeignClient("pessoas")
public interface PessoaClient {
    
    @RequestMapping(method = RequestMethod.GET,value = "/pessoas/{id}")
  ResponseEntity<Optional<Pessoa>> getPessoa( @PathVariable String id);


    @RequestMapping(method = RequestMethod.PUT,value = "/pessoas/{id}",consumes = "application/json")
    Pessoa updatePessoa(@PathVariable String id,Pessoa pessoa);

}
