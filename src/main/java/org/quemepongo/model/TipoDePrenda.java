package org.quemepongo.model;

public class TipoDePrenda {
  private final Categoria categoria;

  private TipoDePrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public static final TipoDePrenda ZAPATO = new TipoDePrenda(Categoria.CALZADO);
  public static final TipoDePrenda REMERA = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  public static final TipoDePrenda PANTALON = new TipoDePrenda(Categoria.PARTE_INFERIOR);
  public static final TipoDePrenda ARETES = new TipoDePrenda(Categoria.ACCESORIO);
}
