package ar.edu.utn.frba.ddsi.climalert.models.repositories;

import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;

import java.util.List;
import java.util.Optional;

public interface RegistroClimaRepository {
  List<RegistroClima> findAll();
  Optional<RegistroClima> findById(Long id);
  RegistroClima save(RegistroClima registroClima);
}
