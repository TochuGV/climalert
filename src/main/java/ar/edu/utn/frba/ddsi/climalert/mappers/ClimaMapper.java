package ar.edu.utn.frba.ddsi.climalert.mappers;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaActualResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.Clima;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;
import org.springframework.stereotype.Component;

@Component
public class ClimaMapper {
  public RegistroClima toEntity(ClimaResponseDTO dto) {
    return new RegistroClima(this.toEntity(dto.actual()));
  }

  public Clima toEntity(ClimaActualResponseDTO dto) {
    return new Clima(dto.tempC(), dto.humidity());
  }
}
