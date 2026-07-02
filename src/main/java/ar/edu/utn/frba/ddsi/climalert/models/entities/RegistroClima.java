package ar.edu.utn.frba.ddsi.climalert.models.entities;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RegistroClima {
  private final LocalDateTime fecha;
  private final Clima clima;
  private final boolean generoAlerta;

  public RegistroClima(Clima clima) {
    this.fecha = LocalDateTime.now();
    this.clima = clima;
    this.generoAlerta = clima.esCondicionPeligrosa();
  }
}
