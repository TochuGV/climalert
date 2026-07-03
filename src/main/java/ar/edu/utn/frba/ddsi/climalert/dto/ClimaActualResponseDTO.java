package ar.edu.utn.frba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClimaActualResponseDTO (
  @JsonProperty("temp_c") double tempC,
  @JsonProperty("humidity") int humidity
) {}
