package ar.edu.utn.frba.ddsi.climalert.models.entities.clima;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Clima {
  private final Ubicacion ubicacion;
  private final double temperatura;
  private final Integer humedad;

  public boolean esCondicionPeligrosa() {
    return this.temperatura > 35.0 && this.humedad > 60;
  }
}
