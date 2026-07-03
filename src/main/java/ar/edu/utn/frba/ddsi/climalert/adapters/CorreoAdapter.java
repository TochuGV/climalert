package ar.edu.utn.frba.ddsi.climalert.adapters;

import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.Notificacion;
import ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion.ResultadoEnvio;

public interface CorreoAdapter {
  ResultadoEnvio enviar(Notificacion notificacion);
}
