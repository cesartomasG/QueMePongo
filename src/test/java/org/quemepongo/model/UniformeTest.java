package org.quemepongo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UniformeTest {

  @Test
  void uniformeConTresCategoriasValidasSeCreaBien() {
    Prenda superior = new Prenda(TipoDePrenda.REMERA, "algodón", new Color(255, 255, 255), null, Trama.LISA);
    Prenda inferior = new Prenda(TipoDePrenda.PANTALON, "gabardina", new Color(0, 0, 0), null, Trama.LISA);
    Prenda calzado = new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(128, 128, 128), null, Trama.LISA);

    assertDoesNotThrow(() -> new Uniforme(superior, inferior, calzado));
  }

  @Test
  void uniformeConCategoriaIncorrectaLanzaError() {
    Prenda accesorio = new Prenda(TipoDePrenda.ARETES, "plástico", new Color(0, 255, 0), null, Trama.LISA);
    Prenda inferior = new Prenda(TipoDePrenda.PANTALON, "jean", new Color(100, 100, 100), null, Trama.LISA);
    Prenda calzado = new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(80, 80, 80), null, Trama.LISA);

    assertThrows(IllegalArgumentException.class, () -> new Uniforme(accesorio, inferior, calzado));
  }
}
