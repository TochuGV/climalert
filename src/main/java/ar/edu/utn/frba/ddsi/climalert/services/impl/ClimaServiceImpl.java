package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.adapters.ProveedorClimaAdapter;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.Notificador;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.RegistroClimaRepository;
import ar.edu.utn.frba.ddsi.climalert.services.ClimaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClimaServiceImpl implements ClimaService {
  private final ProveedorClimaAdapter proveedorClima;
  private final RegistroClimaRepository repository;
  private final Notificador notificador;

  private final List<String> destinatarios = List.of(
    "admin@clima.com",
    "emergencias@clima.com",
    "meteorologia@clima.com"
  );

  @Override
  public void procesarClimaActual() {
    RegistroClima nuevoRegistroClima = proveedorClima.obtenerClimaActual();
    if (nuevoRegistroClima != null) repository.save(nuevoRegistroClima);
  }

  @Override
  public void procesarAlertas() {
    repository.findLatest()
              .filter(RegistroClima::isGeneroAlerta)
              .ifPresent(registroClima -> notificador.notificarAlerta(registroClima, destinatarios));
  }
}
