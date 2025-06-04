package org.quemepongo.sugerencias;

import org.quemepongo.usuario.Usuario;
import org.quemepongo.model.Atuendo;
import org.quemepongo.model.Prenda;
import java.util.List;

public class ServicioDeSugerencias {
  private MotorSugerencias motor;

  public ServicioDeSugerencias(MotorSugerencias motorInicial) {
    this.motor = motorInicial;
  }

  public void setMotor(MotorSugerencias motor) {
    this.motor = motor;
  }

  public List<Atuendo> sugerenciasPara(Usuario usuario, List<Prenda> prendas) {
    return motor.generarSugerencias(prendas, usuario);
  }
}