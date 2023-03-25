package br.com.theschool.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.theschool.model.Sala;

public interface SalaRepository extends MongoRepository<Sala,String>{
    
}
