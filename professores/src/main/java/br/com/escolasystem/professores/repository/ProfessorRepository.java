package br.com.theschoolprofessores.professores.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.theschoolprofessores.professores.model.Professor;

public interface ProfessorRepository extends MongoRepository<Professor,String>{
    
}
