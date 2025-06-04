package org.quemepongo.sugerencias;

import org.junit.jupiter.api.Test;
import org.quemepongo.model.*;
import org.quemepongo.usuario.Usuario;

import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

public class MotorSugerenciasSinFiltradoTest {

  @Test
  void generaTodasLasCombinacionesPosibles() {
    Prenda sup1 = new Prenda(TipoDePrenda.REMERA, "algodón", new Color(200, 0, 0), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda inf1 = new Prenda(TipoDePrenda.PANTALON, "jean", new Color(50, 50, 50), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda inf2 = new Prenda(TipoDePrenda.PANTALON, "gabardina", new Color(100, 100, 100), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda calzado1 = new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(0, 0, 0), null, Trama.LISA, Formalidad.NEUTRA);

    List<Prenda> prendas = of(sup1, inf1, inf2, calzado1);

    MotorSugerencias motor = new MotorSugerenciasSinFiltrado();
    Usuario usuario = new Usuario("Ana", 30); // ignorado en este motor

    List<Atuendo> sugerencias = motor.generarSugerencias(prendas, usuario);

    assertEquals(2, sugerencias.size()); // 1 sup × 2 inf × 1 calz
  }
}
