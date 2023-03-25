package br.com.escolasystem.escola.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.escolasystem.escola.model.Escola;

public interface EscolaRepository extends MongoRepository<Escola,String>{
    
}
