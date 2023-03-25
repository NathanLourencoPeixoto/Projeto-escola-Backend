package br.com.escolasystem.escola.service.Sala;

import java.util.List;
import java.util.Optional;

import br.com.escolasystem.escola.Shared.Sala.SalaCompletoDto;
import br.com.escolasystem.escola.Shared.Sala.SalaDto;
import br.com.escolasystem.escola.model.Sala;

public interface SalaService {
    Optional<SalaCompletoDto> createSala(String escola,Sala sala);
    Optional<SalaCompletoDto> getSala(String ecola, String id);
    List<SalaDto> getSalas(String escola);
    Optional<SalaCompletoDto> editSala(String escola,String id, Sala sala);
    Optional<Void> deleteSala(String escola,String id);
    Optional<Void> clearSalas(String escola);

}
