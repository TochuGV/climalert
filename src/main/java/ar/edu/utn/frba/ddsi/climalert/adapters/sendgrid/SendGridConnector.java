package ar.edu.utn.frba.ddsi.climalert.adapters.sendgrid;

import ar.edu.utn.frba.ddsi.climalert.config.SendGridProperties;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SendGridConnector {
  private final SendGridProperties properties;

  public void enviarCorreoElectronico(String destinatario, String mensaje) {
    try {
      Email from = new Email(properties.getFromEmail());
      Email to = new Email(destinatario);

      String subject = "¡ALERTA METEOROLÓGICA!";
      Content content = new Content("text/plain", mensaje);
      Mail mail = new Mail(from, subject, to, content);
      SendGrid sg = new SendGrid(properties.getApiKey());

      Request request = new Request();
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());

      Response response = sg.api(request);

      if (response.getStatusCode() < 200 || response.getStatusCode() >= 300) {
        throw new RuntimeException("Hubo un error de SendGrid (Status: " + response.getStatusCode() + ") - " + response.getBody());
      }
    } catch (IOException e) {
      throw new RuntimeException("Hubo una falla en la red al conectar con los servidores de SendGrid: " + e.getMessage());
    }
  }
}
