package br.com.theschool.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.theschool.model.Escola;

public interface EscolaRepository extends MongoRepository<Escola,String>{
    
}
