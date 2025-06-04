package org.quemepongo.borrador;

import static java.util.Objects.requireNonNull;

import org.quemepongo.model.Color;
import org.quemepongo.model.Formalidad;
import org.quemepongo.model.Prenda;
import org.quemepongo.model.TipoDePrenda;
import org.quemepongo.model.Trama;

public class BorradorPrenda {
  private TipoDePrenda tipoDePrenda;
  private String material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama = Trama.LISA; // valor por defecto
  private Formalidad formalidad;

  public BorradorPrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = requireNonNull(tipoDePrenda, "tipo es obligatorio");
  }

  public void setTipoDePrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = tipoDePrenda;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public void setColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = colorPrincipal;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setTrama(Trama trama) {
    this.trama = trama;
  }

  public void setFormalidad(Formalidad formalidad) {
    this.formalidad = formalidad;
  }

  public Prenda crearPrenda() {
    validarCampos();
    return new Prenda(tipoDePrenda, material, colorPrincipal, colorSecundario, trama, formalidad);
  }

  private void validarCampos(){
    requireNonNull(material, "material es obligatorio");
    requireNonNull(colorPrincipal, "color principal es obligatorio");
    requireNonNull(formalidad, "formalidad es obligatorio");
  }
}

