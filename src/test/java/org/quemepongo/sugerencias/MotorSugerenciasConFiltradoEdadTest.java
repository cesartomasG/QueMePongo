package org.quemepongo.sugerencias;

import org.junit.jupiter.api.Test;
import org.quemepongo.model.*;
import org.quemepongo.usuario.Usuario;

import java.util.List;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

public class MotorSugerenciasConFiltradoEdadTest {

  @Test
  void filtraPrendasInformalesParaMayoresDe55() {
    Prenda sup1 = new Prenda(TipoDePrenda.REMERA, "algodón", new Color(255, 255, 255), null, Trama.LISA, Formalidad.INFORMAL);
    Prenda inf1 = new Prenda(TipoDePrenda.PANTALON, "jean", new Color(0, 0, 0), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda calzado1 = new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(0, 0, 0), null, Trama.LISA, Formalidad.FORMAL);

    List<Prenda> prendas = of(sup1, inf1, calzado1);
    Usuario usuario = new Usuario("Carlos", 60);

    MotorSugerencias motor = new MotorSugerenciasConFiltradoEdad();

    List<Atuendo> sugerencias = motor.generarSugerencias(prendas, usuario);

    assertEquals(0, sugerencias.size()); // no hay prenda superior válida
  }

  @Test
  void noFiltraRopaInformalSiUsuarioEsJoven() {
    Prenda sup = new Prenda(TipoDePrenda.REMERA, "algodón", new Color(255, 0, 0), null, Trama.LISA, Formalidad.INFORMAL);
    Prenda inf = new Prenda(TipoDePrenda.PANTALON, "jean", new Color(0, 0, 0), null, Trama.LISA, Formalidad.NEUTRA);
    Prenda calz = new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(0, 0, 0), null, Trama.LISA, Formalidad.FORMAL);

    List<Prenda> prendas = of(sup, inf, calz);
    Usuario joven = new Usuario("Lu", 30);

    MotorSugerencias motor = new MotorSugerenciasConFiltradoEdad();

    List<Atuendo> sugerencias = motor.generarSugerencias(prendas, joven);

    assertEquals(1, sugerencias.size());
  }
}
