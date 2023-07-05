package com.perficient.university.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.UUID;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curso")
public class Course {
  @Id
  @Column(name = "uuid", nullable = false)
  private UUID id;
  @Column(name = "titulo")
  private String titulo;
  @Column(name = "descripcion")
  private String descripcion;
  @Column(name = "fecha_inicio")
  private Date fechaInicio;
  @Column(name = "fecha_fin")
  private Date fechaFin;
  @Column(name = "horas_duracion")
  private double horasDuracion;
  @Column(name = "fecha_creacion")
  private Date fechaCreacion;
  @Column(name = "fecha_actualiz")
  private Date fechaActualizacion;
  @Column(name = "eliminado")
  private boolean eliminado;
  @Column(name = "fecha_eliminacion")
  private Date fechaEliminacion;
  @Column(name = "user_modificacion")
  private UUID userModificacion;
  @Column(name = "estado")
  private UUID estado;

}