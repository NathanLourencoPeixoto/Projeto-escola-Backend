package br.com.theschoolprofessores.professores.service;

import java.util.List;
import java.util.Optional;

import br.com.theschoolprofessores.professores.Shared.ProfessorCompletoDto;
import br.com.theschoolprofessores.professores.Shared.ProfessorIncomplatoDto;

public interface ProfessorService {
    Optional<ProfessorCompletoDto> createProfessor(ProfessorIncomplatoDto dto);
    Optional<ProfessorCompletoDto> getProfessor(String id);
    List<ProfessorIncomplatoDto> getProfessoresList();
    Optional<ProfessorCompletoDto> editProfessor(String id, ProfessorIncomplatoDto dto);
    Optional<Void> deleteProfessor(String id);
}
