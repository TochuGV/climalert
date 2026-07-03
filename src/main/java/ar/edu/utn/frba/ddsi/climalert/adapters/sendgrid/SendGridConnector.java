package ar.edu.utn.frba.ddsi.climalert.adapters.sendgrid;

import org.springframework.stereotype.Component;

@Component
public class SendGridConnector {
  public void simularEnvio(String destinatario, String mensaje) {
    System.out.println("Simulando envío de correo a " + destinatario + " | Mensaje: " + mensaje);
  }
}
