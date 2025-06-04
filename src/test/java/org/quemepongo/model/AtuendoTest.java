package org.quemepongo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtuendoTest {

  @Test
  void atuendoSeCreaConCategoriasCorrectas() {
    Prenda sup = new Prenda(TipoDePrenda.REMERA, "algodón", new Color(255, 255, 255), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda inf = new Prenda(TipoDePrenda.PANTALON, "jean", new Color(0, 0, 0), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda calzado = new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(100, 100, 100), null, Trama.LISA, Formalidad.NEUTRA);

    assertDoesNotThrow(() -> new Atuendo(sup, inf, calzado));
  }

  @Test
  void atuendoLanzaErrorSiCategoriaIncorrecta() {
    Prenda aretes = new Prenda(TipoDePrenda.ARETES, "plástico", new Color(0, 255, 0), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda inf = new Prenda(TipoDePrenda.PANTALON, "gabardina", new Color(80, 80, 80), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda calzado = new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(0, 0, 0), null, Trama.LISA, Formalidad.NEUTRA);

    assertThrows(IllegalArgumentException.class, () -> new Atuendo(aretes, inf, calzado));
  }
}
