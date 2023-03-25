package br.com.escolasystem.escola.service.Escola;

import java.util.List;
import java.util.Optional;

import br.com.escolasystem.escola.Shared.Escola.EscolaCompletoDto;
import br.com.escolasystem.escola.Shared.Escola.EscolaIncompletoDto;
import br.com.escolasystem.escola.model.Escola;

public interface EscolaService {
    EscolaCompletoDto createEscola(Escola escola);
    Optional<EscolaCompletoDto> getEscola(String id);
    List<EscolaIncompletoDto> getEscolas();   
    Optional<EscolaCompletoDto> editEscola(String id, Escola escola);
    Optional<Void> deleteEscola(String id);
}
