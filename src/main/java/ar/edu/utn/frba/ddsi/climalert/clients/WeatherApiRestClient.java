package ar.edu.utn.frba.ddsi.climalert.clients;

import ar.edu.utn.frba.ddsi.climalert.config.RestClimalertProperties;
import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class WeatherApiRestClient {
  private final RestTemplate restTemplate;
  private final RestClimalertProperties propiedades;

  public ClimaResponseDTO buscarClimaActual() {
    URI uri = UriComponentsBuilder.fromUriString(propiedades.getBaseUrl())
      .queryParam("key", propiedades.getApiKey())
      .queryParam("q", propiedades.getLocation())
      .build()
      .toUri();
    ClimaResponseDTO dto = restTemplate.getForObject(uri, ClimaResponseDTO.class);
    if (dto == null) throw new RuntimeException("Respuesta nula de WeatherAPI para URI: " + uri);
    return dto;
  }
}
