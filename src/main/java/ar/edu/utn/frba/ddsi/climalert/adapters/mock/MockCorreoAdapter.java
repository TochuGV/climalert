package ar.edu.utn.frba.ddsi.climalert.adapters.mock;

import ar.edu.utn.frba.ddsi.climalert.adapters.CorreoAdapter;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.Notificacion;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.ResultadoEnvio;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "notificaciones.proveedor", havingValue = "mock", matchIfMissing = true)
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
