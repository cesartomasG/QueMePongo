package org.quemepongo.usuario;

public class Usuario {
  private final String nombre;
  private final int edad;

  public Usuario(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  public int getEdad() {
    return edad;
  }

  public String getNombre() {
    return nombre;
  }
}
