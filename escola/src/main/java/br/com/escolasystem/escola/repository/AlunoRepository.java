package br.com.escolasystem.escola.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.escolasystem.escola.model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String>{
    
}
