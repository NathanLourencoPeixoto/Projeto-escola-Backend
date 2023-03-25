package br.com.theschool.service.Escola;

import java.util.List;
import java.util.Optional;

import br.com.theschool.Shared.Escola.EscolaCompletoDto;
import br.com.theschool.Shared.Escola.EscolaIncompletoDto;
import br.com.theschool.model.Escola;

public interface EscolaService {
    EscolaCompletoDto createEscola(Escola escola);
    Optional<EscolaCompletoDto> getEscola(String id);
    List<EscolaIncompletoDto> getEscolas();   
    Optional<EscolaCompletoDto> editEscola(String id, Escola escola);
    Optional<Void> deleteEscola(String id);
}
