package org.quemepongo.model;

public class Uniforme {
  private final Prenda prendaSuperior;
  private final Prenda prendaInferior;
  private final Prenda calzado;

  public Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    if (prendaSuperior.categoria() != Categoria.PARTE_SUPERIOR
        || prendaInferior.categoria() != Categoria.PARTE_INFERIOR
        || calzado.categoria() != Categoria.CALZADO) {
      throw new IllegalArgumentException("Las prendas no respetan la estructura de un uniforme");
    }

    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }
}
