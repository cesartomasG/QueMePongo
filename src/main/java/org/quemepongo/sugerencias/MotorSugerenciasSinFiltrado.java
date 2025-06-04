package org.quemepongo.sugerencias;

import org.quemepongo.usuario.Usuario;
import org.quemepongo.model.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class MotorSugerenciasSinFiltrado implements MotorSugerencias {

  @Override
  public List<Atuendo> generarSugerencias(List<Prenda> prendasDisponibles, Usuario usuario) {
    // Ignoramos al usuario ya que no utilizamos filtrado
    List<Prenda> superiores = filtrarPorCategoria(prendasDisponibles, Categoria.PARTE_SUPERIOR);
    List<Prenda> inferiores = filtrarPorCategoria(prendasDisponibles, Categoria.PARTE_INFERIOR);
    List<Prenda> calzados = filtrarPorCategoria(prendasDisponibles, Categoria.CALZADO);

    List<Atuendo> sugerencias = new ArrayList<>();

    for (Prenda sup : superiores) {
      for (Prenda inf : inferiores) {
        for (Prenda calz : calzados) {
          sugerencias.add(new Atuendo(sup, inf, calz));
        }
      }
    }

    return sugerencias;
  }

  private List<Prenda> filtrarPorCategoria(List<Prenda> prendas, Categoria categoria) {
    return prendas.stream()
        .filter(p -> p.categoria() == categoria)
        .collect(Collectors.toList());
  }
}
