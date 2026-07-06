package ar.edu.utn.frba.ddsi.climalert.models.repositories.inmemory;

import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.RegistroClimaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RegistroClimaRepositoryImpl implements RegistroClimaRepository {
  private final List<RegistroClima> registroClima = new ArrayList<>();
  private final AtomicLong idGenerator = new AtomicLong(1);

  @Override
  public Optional<RegistroClima> findLatest() {
    if (registroClima.isEmpty()) return Optional.empty();
    return Optional.of(registroClima.getLast());
  }

  @Override
  public RegistroClima save(RegistroClima registro) {
    if (registro.getId() == null) {
      registro.setId(idGenerator.getAndIncrement());
      registroClima.add(registro);
    };
    return registro;
  }
}
