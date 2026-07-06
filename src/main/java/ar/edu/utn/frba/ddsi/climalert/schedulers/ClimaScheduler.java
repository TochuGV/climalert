package ar.edu.utn.frba.ddsi.climalert.schedulers;

import ar.edu.utn.frba.ddsi.climalert.services.ClimaService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClimaScheduler {
  private final ClimaService climaService;

  @Scheduled(fixedRate = 300000)
  public void obtenerClimaActual() {
    this.climaService.procesarClimaActual();
  }

  @Scheduled(fixedRate = 60000)
  public void notificarAlerta() {
    this.climaService.procesarAlertas();
  }
}
