package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.clients.WeatherApiRestClient;
import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.mappers.ClimaMapper;
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
  private final WeatherApiRestClient weatherClient;
  private final ClimaMapper mapper;
  private final RegistroClimaRepository repository;
  private final Notificador notificador;

  private final List<String> destinatarios = List.of(
    "admin@clima.com",
    "emergencias@clima.com",
    "meteorologia@clima.com");

  public void procesarClimaActual() {
    ClimaResponseDTO dto = weatherClient.buscarClimaActual();
    RegistroClima nuevoRegistroClima = mapper.toEntity(dto);
    RegistroClima registroClimaGuardado = repository.save(nuevoRegistroClima);
    if (registroClimaGuardado.isGeneroAlerta()) {
      System.out.println("Alerta!");
      notificador.notificarAlerta(registroClimaGuardado, destinatarios);
    } else {
      System.out.println("Todo pelota!"); // Eventualmente, no va a existir este 'else'.
    }
  }
}
