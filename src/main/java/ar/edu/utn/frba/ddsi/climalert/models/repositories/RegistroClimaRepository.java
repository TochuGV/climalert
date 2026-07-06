package ar.edu.utn.frba.ddsi.climalert.models.repositories;

import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;

import java.util.Optional;

public interface RegistroClimaRepository {
  Optional<RegistroClima> findLatest();
  RegistroClima save(RegistroClima registroClima);
}
