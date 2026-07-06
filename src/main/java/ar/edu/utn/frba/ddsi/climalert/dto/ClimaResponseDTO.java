package ar.edu.utn.frba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClimaResponseDTO(
  @JsonProperty("location") UbicacionResponseDTO ubicacion,
  @JsonProperty("current") ClimaActualResponseDTO actual
) {}
