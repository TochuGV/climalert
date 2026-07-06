package ar.edu.utn.frba.ddsi.climalert.mappers;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaActualResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.dto.UbicacionResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.Clima;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.Ubicacion;
import org.springframework.stereotype.Component;

@Component
public class ClimaMapper {
  public RegistroClima toEntity(ClimaResponseDTO dto) {
    return new RegistroClima(this.toEntity(dto.ubicacion(), dto.actual()));
  }

  public Clima toEntity(UbicacionResponseDTO ubicacionDto, ClimaActualResponseDTO actualDto) {
    return new Clima(this.toEntity(ubicacionDto), actualDto.tempC(), actualDto.humidity());
  }

  public Ubicacion toEntity(UbicacionResponseDTO dto) {
    return new Ubicacion(dto.nombre(), dto.region(), dto.pais());
  }
}
