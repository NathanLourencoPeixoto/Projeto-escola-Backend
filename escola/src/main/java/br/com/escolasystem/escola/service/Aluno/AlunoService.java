package br.com.theschool.service.Aluno;

import java.util.List;
import java.util.Optional;

import br.com.theschool.Shared.Aluno.AlunoCompletoDto;
import br.com.theschool.Shared.Aluno.AlunoDto;
import br.com.theschool.model.Aluno;

public interface AlunoService {
    Optional<AlunoCompletoDto> createAluno(String escolaId, String id,Aluno aluno);
    Optional<AlunoCompletoDto> getAluno(String escolaId, String id);
    List<AlunoDto> getAlunos(String escolaId);
    Optional<AlunoCompletoDto> editAluno(String escolaId, String id, Aluno aluno);
    Optional<Void> removeAluno(String escolaId, String id);

}
