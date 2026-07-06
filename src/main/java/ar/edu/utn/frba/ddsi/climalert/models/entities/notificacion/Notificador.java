package ar.edu.utn.frba.ddsi.climalert.models.entities.notificacion;

import ar.edu.utn.frba.ddsi.climalert.adapters.CorreoAdapter;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.Clima;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;
import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.Ubicacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Notificador {
  private final CorreoAdapter adapter;

  public void notificarAlerta(RegistroClima registroClima, List<String> destinatarios) {
    Clima clima = registroClima.getClima();
    Ubicacion ubicacion = clima.getUbicacion();

    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
    String fechaFormateada = registroClima.getFecha().format(formatoFecha);

    String cuerpo = """
                ¡ALERTA METEOROLÓGICA!
                
                Se han detectado condiciones climáticas extremas en la siguiente ubicación:
                📍 %s, %s (%s)
                
                Detalles del reporte actual:
                🌡️ Temperatura: %.1f °C
                💧 Humedad: %d%%
                🕒 Fecha del registro: %s
                """.formatted(
      ubicacion.nombre(),
      ubicacion.region(),
      ubicacion.pais(),
      clima.getTemperatura(),
      clima.getHumedad(),
      fechaFormateada
    );

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
