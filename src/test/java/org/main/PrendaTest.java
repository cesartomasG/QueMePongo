package org.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrendaTest {

  @Test
  void crearPrendaValidaFunciona() {
    Color rojo = new Color(255, 0, 0);
    Prenda zapato = new Prenda(TipoDePrenda.ZAPATO, "Cuero", rojo, null);

    assertEquals(Categoria.CALZADO, zapato.categoria());
  }

  @Test
  void noSePuedeCrearPrendaSinTipo() {
    Color rojo = new Color(255, 0, 0);
    assertThrows(NullPointerException.class, () -> {
      new Prenda(null, "Algodón", rojo, null);
    });
  }

  @Test
  void noSePuedeCrearPrendaSinMaterial() {
    Color rojo = new Color(255, 0, 0);
    assertThrows(NullPointerException.class, () -> {
      new Prenda(TipoDePrenda.REMERA, null, rojo, null);
    });
  }

  @Test
  void noSePuedeCrearPrendaSinColorPrincipal() {
    assertThrows(NullPointerException.class, () -> {
      new Prenda(TipoDePrenda.REMERA, "Algodón", null, null);
    });
  }

  @Test
  void noSePuedeCrearTipoDePrendaArbitrario() {
    assertThrows(IllegalAccessException.class, () -> {
      // Si alguien intenta crear un tipo nuevo, esto no debería compilar ni funcionar
      TipoDePrenda tipoInvalido = TipoDePrenda.class.getDeclaredConstructor(Categoria.class).newInstance(Categoria.CALZADO);
    });
  }

  @Test
  void prendaPuedeNoTenerColorSecundario() {
    Color rojo = new Color(255, 0, 0);
    Prenda remera = new Prenda(TipoDePrenda.REMERA, "Algodón", rojo, null);

    assertNull(remera.getColorSecundario(), "El color secundario debe ser null si no se proporciona");
  }

  @Test
  void prendaConColorSecundarioLoGuardaCorrectamente() {
    Color rojo = new Color(255, 0, 0);
    Color azul = new Color(0, 0, 255);

    Prenda remera = new Prenda(TipoDePrenda.REMERA, "Algodón", rojo, azul);

    assertEquals(azul, remera.getColorSecundario(), "Debe guardar correctamente el color secundario");
  }

}
