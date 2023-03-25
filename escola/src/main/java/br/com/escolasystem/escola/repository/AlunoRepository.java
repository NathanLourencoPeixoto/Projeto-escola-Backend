package br.com.theschool.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.theschool.model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String>{
    
}
