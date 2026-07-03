package ar.edu.utn.frba.ddsi.climalert.adapters.sendgrid;

import ar.edu.utn.frba.ddsi.climalert.adapters.CorreoAdapter;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.Notificacion;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.ResultadoEnvio;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "notificaciones.proveedor", havingValue = "sendgrid")
@RequiredArgsConstructor
public class SendGridCorreoAdapter implements CorreoAdapter {
  private final SendGridConnector adaptee;

  @Override
  public ResultadoEnvio enviar(Notificacion notificacion) {
    try {
      adaptee.enviarCorreoElectronico(notificacion.destinatario(), notificacion.mensaje());
      return ResultadoEnvio.exito();
    } catch (Exception e) {
      return ResultadoEnvio.falla(e.getMessage());
    }
  }
}
