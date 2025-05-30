package org.quemepongo.instituciones;

public class RepositorioDeInstituciones {

  public static Institucion colegioSanJuan() {
    return new Institucion("San Juan", UniformeFactory.uniformeSanJuan());
  }

  public static Institucion institutoJohnson() {
    return new Institucion("Instituto Johnson", UniformeFactory.uniformeInstitutoJohnson());
  }
}
