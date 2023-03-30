package br.com.theschoolprofessores.professores.httpClient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.theschoolprofessores.professores.model.Pessoa;

@FeignClient("pessoas")
public interface PessoaClient {
    
    @RequestMapping(method = RequestMethod.GET,value = "/pessoas/{id}")
  Optional<Pessoa> getPessoa( @PathVariable String id);


    @RequestMapping(method = RequestMethod.PUT,value = "/pessoas/{id}",consumes = "application/json")
    Optional<Pessoa> updatePessoa(@PathVariable String id,Pessoa pessoa);

}
