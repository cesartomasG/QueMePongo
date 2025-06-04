package org.quemepongo.instituciones;

import org.quemepongo.model.*;

public class UniformeFactory {

  public static Uniforme uniformeSanJuan() {
    return new Uniforme(
        new Prenda(TipoDePrenda.REMERA, "piqué", new Color(0, 128, 0), null, Trama.LISA, Formalidad.FORMAL),
        new Prenda(TipoDePrenda.PANTALON, "acetato", new Color(128, 128, 128), null, Trama.LISA, Formalidad.FORMAL),
        new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(255, 255, 255), null, Trama.LISA, Formalidad.FORMAL)
    );
  }

  public static Uniforme uniformeInstitutoJohnson() {
    return new Uniforme(
        new Prenda(TipoDePrenda.REMERA, "algodón", new Color(255, 255, 255), null, Trama.LISA, Formalidad.FORMAL),
        new Prenda(TipoDePrenda.PANTALON, "gabardina", new Color(0, 0, 0), null, Trama.LISA, Formalidad.FORMAL),
        new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(0, 0, 0), null, Trama.LISA, Formalidad.FORMAL)
    );
  }
}
