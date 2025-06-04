package org.quemepongo.sugerencias;

import org.quemepongo.usuario.Usuario;
import org.quemepongo.model.Prenda;
import org.quemepongo.model.Atuendo;

import java.util.List;

// Interfaz Base
public interface MotorSugerencias {
  List<Atuendo> generarSugerencias(List<Prenda> prendasDisponibles, Usuario usuario);

}