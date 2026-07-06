package ar.edu.utn.frba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UbicacionResponseDTO(
  @JsonProperty("name") String nombre,
  @JsonProperty("region") String region,
  @JsonProperty("country") String pais
) {
}
