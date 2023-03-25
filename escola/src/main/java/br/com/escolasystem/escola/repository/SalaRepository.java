package br.com.escolasystem.escola.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.escolasystem.escola.model.Sala;

public interface SalaRepository extends MongoRepository<Sala,String>{
    
}
