package ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion;

import ar.edu.utn.frba.ddsi.climalert.adapters.CorreoAdapter;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Notificador {
  private final CorreoAdapter adapter;

  public void notificarAlerta(RegistroClima registroClima, List<String> destinatarios) {
    String cuerpo = "¡ALERTA METEOROLÓGICA!\nTemperatura: "
      + registroClima.getClima().getTemperatura() + "°C\nHumedad: "
      + registroClima.getClima().getHumedad() + "%";

    for (String destinatario : destinatarios) {
      Notificacion notificacion = new Notificacion(destinatario, cuerpo);
      ResultadoEnvio resultado = adapter.enviar(notificacion);

      if (!resultado.exitoso()) {
        System.out.println("Falló el envío a " + destinatario + " - Motivo: " + resultado.motivoFalla());
      } else {
        System.out.println("Alerta enviada con éxito a " + destinatario);
      }
    }
  }
}
