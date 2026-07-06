package ar.edu.utn.frba.ddsi.climalert.adapters.weatherapi;

import ar.edu.utn.frba.ddsi.climalert.adapters.ProveedorClimaAdapter;
import ar.edu.utn.frba.ddsi.climalert.clients.WeatherApiRestClient;
import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.mappers.ClimaMapper;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherApiAdapter implements ProveedorClimaAdapter {
  private final WeatherApiRestClient weatherClient;
  private final ClimaMapper mapper;

  @Override
  public RegistroClima obtenerClimaActual() {
    ClimaResponseDTO dto = weatherClient.buscarClimaActual();
    return mapper.toEntity(dto);
  }
}
