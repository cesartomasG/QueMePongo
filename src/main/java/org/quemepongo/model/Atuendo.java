package org.quemepongo.model;

import java.util.Objects;

public class Atuendo {
  private final Prenda prendaSuperior;
  private final Prenda prendaInferior;
  private final Prenda calzado;

  public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    validarCategoria(prendaSuperior, Categoria.PARTE_SUPERIOR);
    validarCategoria(prendaInferior, Categoria.PARTE_INFERIOR);
    validarCategoria(calzado, Categoria.CALZADO);

    this.prendaSuperior = Objects.requireNonNull(prendaSuperior);
    this.prendaInferior = Objects.requireNonNull(prendaInferior);
    this.calzado = Objects.requireNonNull(calzado);
  }

  private void validarCategoria(Prenda prenda, Categoria categoriaEsperada) {
    if (prenda.categoria() != categoriaEsperada) {
      throw new IllegalArgumentException("Se esperaba una prenda de categoría: " + categoriaEsperada);
    }
  }

  public Prenda getPrendaSuperior() {
    return prendaSuperior;
  }

  public Prenda getPrendaInferior() {
    return prendaInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }
}
