package ar.edu.utn.frba.ddsi.climalert.clients;

import ar.edu.utn.frba.ddsi.climalert.config.RestClimalertProperties;
import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import jakarta.annotation.PostConstruct;
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
    return restTemplate.getForObject(uri, ClimaResponseDTO.class);
  }

  @PostConstruct
  public void probarConexion() {
    System.out.println("--- INICIANDO PRUEBA DE API ---");
    try {
      ClimaResponseDTO respuesta = buscarClimaActual();
      System.out.println("TEMPERATURA ACTUAL: " + respuesta.actual().tempC() + "°C");
      System.out.println("HUMEDAD ACTUAL: " + respuesta.actual().humidity() + "%");
    } catch (Exception e) {
      System.out.println("ERROR EN LA PETICION: " + e.getMessage());
    }
    System.out.println("--- FIN DE LA PRUEBA ---");
  }
}
