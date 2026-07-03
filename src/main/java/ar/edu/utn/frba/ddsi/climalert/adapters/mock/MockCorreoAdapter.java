package ar.edu.utn.frba.ddsi.climalert.adapters.mock;

import ar.edu.utn.frba.ddsi.climalert.adapters.CorreoAdapter;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.Notificacion;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.ResultadoEnvio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MockCorreoAdapter implements CorreoAdapter {
  private final MockConnector adaptee;

  @Override
  public ResultadoEnvio enviar(Notificacion notificacion) {
    try {
      adaptee.simularEnvio(notificacion.destinatario(), notificacion.mensaje());
      return ResultadoEnvio.exito();
    } catch (Exception e) {
      return ResultadoEnvio.falla(e.getMessage());
    }
  }
}
