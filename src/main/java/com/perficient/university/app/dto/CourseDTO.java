package com.perficient.university.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

  private UUID id;
  private String titulo;
  private String descripcion;
  private Date fechaInicio;
  private Date fechaFin;
  private double horasDuracion;
  private UUID estado;

}
