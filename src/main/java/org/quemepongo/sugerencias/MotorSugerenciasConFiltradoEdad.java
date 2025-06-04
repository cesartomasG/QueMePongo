package org.quemepongo.sugerencias;

import org.quemepongo.model.*;
import org.quemepongo.usuario.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class MotorSugerenciasConFiltradoEdad implements MotorSugerencias {

  @Override
  public List<Atuendo> generarSugerencias(List<Prenda> prendasDisponibles, Usuario usuario) {
    List<Prenda> prendasFiltradas = usuario.getEdad() > 55
        ? prendasDisponibles.stream()
        .filter(p -> p.getFormalidad() != Formalidad.INFORMAL)
        .collect(Collectors.toList())
        : prendasDisponibles;

    // Reutilizamos el mismo algoritmo del motor simple
    List<Prenda> superiores = filtrarPorCategoria(prendasFiltradas, Categoria.PARTE_SUPERIOR);
    List<Prenda> inferiores = filtrarPorCategoria(prendasFiltradas, Categoria.PARTE_INFERIOR);
    List<Prenda> calzados = filtrarPorCategoria(prendasFiltradas, Categoria.CALZADO);

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