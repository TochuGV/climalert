package ar.edu.utn.frba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClimaResponseDTO(
  @JsonProperty("current") ClimaActualResponseDTO actual
) {}
