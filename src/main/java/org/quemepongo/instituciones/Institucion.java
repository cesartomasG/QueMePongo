package org.quemepongo.instituciones;

import org.quemepongo.model.Uniforme;

public class Institucion {
  private final String nombre;
  private final Uniforme uniforme;

  public Institucion(String nombre, Uniforme uniforme) {
    this.nombre = nombre;
    this.uniforme = uniforme;
  }

  public String getNombre() {
    return nombre;
  }

  public Uniforme getUniforme() {
    return uniforme;
  }
}
