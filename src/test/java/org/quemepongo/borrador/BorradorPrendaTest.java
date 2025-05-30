package org.quemepongo.borrador;

import org.junit.jupiter.api.Test;
import org.quemepongo.model.Categoria;
import org.quemepongo.model.Color;
import org.quemepongo.model.Prenda;
import org.quemepongo.model.TipoDePrenda;
import org.quemepongo.model.Trama;

import static org.junit.jupiter.api.Assertions.*;

public class BorradorPrendaTest {

  @Test
  void prendaSeCreaCorrectamenteCuandoTieneTodosLosDatos() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.REMERA);
    borrador.setMaterial("algodón");
    borrador.setColorPrincipal(new Color(255, 0, 0));

    Prenda prenda = borrador.crearPrenda();

    assertEquals(Categoria.PARTE_SUPERIOR, prenda.categoria());
    assertEquals(Trama.LISA, prenda.getTrama()); // trama por defecto
  }

  @Test
  void noSePuedeCrearPrendaSinMaterial() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.ZAPATO);
    borrador.setColorPrincipal(new Color(0, 0, 0));

    assertThrows(NullPointerException.class, borrador::crearPrenda);
  }

  @Test
  void noSePuedeCrearPrendaSinColorPrincipal() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.ZAPATO);
    borrador.setMaterial("cuero");

    assertThrows(NullPointerException.class, borrador::crearPrenda);
  }

  @Test
  void tramaSePuedeAsignarManual() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.PANTALON);
    borrador.setMaterial("jean");
    borrador.setColorPrincipal(new Color(50, 50, 50));
    borrador.setTrama(Trama.CUADROS);

    Prenda prenda = borrador.crearPrenda();

    assertEquals(Trama.CUADROS, prenda.getTrama());
  }
}
