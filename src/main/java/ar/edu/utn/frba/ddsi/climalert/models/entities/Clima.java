package ar.edu.utn.frba.ddsi.climalert.models.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Clima {
  private final double temperatura;
  private final Integer humedad;

  public boolean esCondicionPeligrosa() {
    return this.temperatura > 35.0 && this.humedad > 60;
  }
}
