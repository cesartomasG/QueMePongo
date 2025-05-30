package org.main;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private final TipoDePrenda tipoDePrenda;
  private final String material;
  private final Color colorPrincipal;
  private final Color colorSecundario;

  public Prenda(TipoDePrenda tipoDePrenda, String material, Color colorPrincipal, Color colorSecundario) {
    this.tipoDePrenda = requireNonNull(tipoDePrenda, "tipo de prenda es obligatorio");
    this.material = requireNonNull(material, "material es obligatorio");
    this.colorPrincipal = requireNonNull(colorPrincipal, "color principal es obligatorio");
    this.colorSecundario = colorSecundario; // puede ser null
  }

  public Categoria categoria() {
    return tipoDePrenda.getCategoria();
  }

  public Color getColorPrincipal() {
    return colorSecundario;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }
}
