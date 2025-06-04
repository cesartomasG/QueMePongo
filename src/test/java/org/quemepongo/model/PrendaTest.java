package org.quemepongo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrendaTest {
//test de iteracion 1 pero con ajustes minimos para que funcionen
  @Test
  void crearPrendaValidaFunciona() {
    Color rojo = new Color(255, 0, 0);
    Prenda zapato = new Prenda(TipoDePrenda.ZAPATO, "Cuero", rojo, null, Trama.LISA, Formalidad.FORMAL);

    assertEquals(Categoria.CALZADO, zapato.categoria());
  }

  @Test
  void noSePuedeCrearPrendaSinTipo() {
    Color rojo = new Color(255, 0, 0);
    assertThrows(NullPointerException.class, () -> new Prenda(null, "Algodón", rojo, null, Trama.LISA, Formalidad.INFORMAL));
  }

  @Test
  void noSePuedeCrearPrendaSinMaterial() {
    Color rojo = new Color(255, 0, 0);
    assertThrows(NullPointerException.class, () -> new Prenda(TipoDePrenda.REMERA, null, rojo, null, Trama.LISA, Formalidad.INFORMAL));
  }

  @Test
  void noSePuedeCrearPrendaSinColorPrincipal() {
    assertThrows(NullPointerException.class, () -> new Prenda(TipoDePrenda.REMERA, "Algodón", null, null, Trama.LISA, Formalidad.INFORMAL));
  }

  @Test
  void prendaPuedeNoTenerColorSecundario() {
    Color rojo = new Color(255, 0, 0);
    Prenda remera = new Prenda(TipoDePrenda.REMERA, "Algodón", rojo, null, Trama.LISA, Formalidad.INFORMAL);

    assertNull(remera.getColorSecundario(), "El color secundario debe ser null si no se proporciona");
  }

  @Test
  void prendaConColorSecundarioLoGuardaCorrectamente() {
    Color rojo = new Color(255, 0, 0);
    Color azul = new Color(0, 0, 255);

    Prenda remera = new Prenda(TipoDePrenda.REMERA, "Algodón", rojo, azul, Trama.LISA, Formalidad.INFORMAL);

    assertEquals(azul, remera.getColorSecundario(), "Debe guardar correctamente el color secundario");
  }
}
