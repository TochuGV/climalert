package ar.edu.utn.frba.ddsi.climalert.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rest-climalert")
@Data
public class RestClimalertProperties {
  private String baseUrl;
  private String apiKey;
  private String location;
}