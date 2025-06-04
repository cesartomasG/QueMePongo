package org.quemepongo.model;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private final TipoDePrenda tipoDePrenda;
  private final String material;
  private final Color colorPrincipal;
  private final Color colorSecundario;
  private final Trama trama;
  private final Formalidad formalidad;

  public Prenda(TipoDePrenda tipoDePrenda, String material, Color colorPrincipal, Color colorSecundario, Trama trama, Formalidad formalidad) {
    this.tipoDePrenda = requireNonNull(tipoDePrenda, "tipo de prenda es obligatorio");
    this.material = requireNonNull(material, "material es obligatorio");
    this.colorPrincipal = requireNonNull(colorPrincipal, "color principal es obligatorio");
    this.colorSecundario = colorSecundario; // puede ser null
    this.trama = requireNonNull(trama);
    this.formalidad = requireNonNull(formalidad);
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

  public Trama getTrama(){
    return trama;
  }

  public Formalidad getFormalidad() {
    return formalidad;
  }
}
