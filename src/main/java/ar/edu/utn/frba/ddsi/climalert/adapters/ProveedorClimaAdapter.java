package ar.edu.utn.frba.ddsi.climalert.adapters;

import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.RegistroClima;

public interface ProveedorClimaAdapter {
  RegistroClima obtenerClimaActual();
}
