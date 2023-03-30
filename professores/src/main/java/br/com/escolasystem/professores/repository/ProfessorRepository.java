package br.com.escolasystem.professores.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.escolasystem.professores.model.Professor;

public interface ProfessorRepository extends MongoRepository<Professor,String>{
    
}
