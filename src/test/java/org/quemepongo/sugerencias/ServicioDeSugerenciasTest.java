package org.quemepongo.sugerencias;

import org.junit.jupiter.api.Test;
import org.quemepongo.model.*;
import org.quemepongo.usuario.Usuario;

import java.util.List;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

public class ServicioDeSugerenciasTest {

  @Test
  void puedeCambiarMotorYObtenerResultadosDistintos() {
    Prenda supInformal = new Prenda(TipoDePrenda.REMERA, "algodón", new Color(255, 0, 0), null, Trama.LISA, Formalidad.INFORMAL);
    Prenda inf = new Prenda(TipoDePrenda.PANTALON, "gabardina", new Color(0, 0, 0), null, Trama.LISA, Formalidad.FORMAL);
    Prenda calz = new Prenda(TipoDePrenda.ZAPATO, "cuero", new Color(50, 50, 50), null, Trama.LISA, Formalidad.FORMAL);

    List<Prenda> prendas = of(supInformal, inf, calz);
    Usuario mayor = new Usuario("Carlos", 60);

    ServicioDeSugerencias servicio = new ServicioDeSugerencias(new MotorSugerenciasSinFiltrado());

    List<Atuendo> sinFiltrado = servicio.sugerenciasPara(mayor, prendas);
    assertEquals(1, sinFiltrado.size()); // acepta prenda informal

    servicio.setMotor(new MotorSugerenciasConFiltradoEdad());

    List<Atuendo> conFiltrado = servicio.sugerenciasPara(mayor, prendas);
    assertEquals(0, conFiltrado.size()); // descarta prenda informal
  }
}
