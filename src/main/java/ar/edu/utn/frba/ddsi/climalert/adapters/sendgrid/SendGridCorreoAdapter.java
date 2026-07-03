package ar.edu.utn.frba.ddsi.climalert.adapters.sendgrid;

import ar.edu.utn.frba.ddsi.climalert.adapters.CorreoAdapter;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.Notificacion;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.ResultadoEnvio;

public class SendGridCorreoAdapter implements CorreoAdapter {
  @Override
  public ResultadoEnvio enviar(Notificacion notificacion) {
    return null;
  }
}
