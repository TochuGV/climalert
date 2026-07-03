package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.clients.WeatherApiRestClient;
import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.mappers.ClimaMapper;
import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClima;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.RegistroClimaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClimaServiceImpl {
  private final WeatherApiRestClient weatherClient;
  private final ClimaMapper mapper;
  private final RegistroClimaRepository repository;

  public void procesarClimaActual() {
    ClimaResponseDTO dto = weatherClient.buscarClimaActual();
    RegistroClima nuevoRegistroClima = mapper.toEntity(dto);
    RegistroClima registroClimaGuardado = repository.save(nuevoRegistroClima);
    if (registroClimaGuardado.isGeneroAlerta()) {
      System.out.println("Alerta!");
    } else {
      System.out.println("Todo pelota!"); // Eventualmente, no va a existir este 'else'.
    }
  }
}
