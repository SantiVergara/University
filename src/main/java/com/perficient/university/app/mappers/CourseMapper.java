package com.perficient.university.app.mappers;

import com.perficient.university.app.dto.CourseDTO;
import com.perficient.university.app.entities.Course;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseMapper {

  public static CourseDTO mapCourseToCourseDTO(Course course) {
    CourseDTO courseDTO = new CourseDTO();
    courseDTO.setId(course.getId());
    courseDTO.setTitulo(course.getTitulo());
    courseDTO.setDescripcion(course.getDescripcion());
    courseDTO.setFechaInicio(course.getFechaInicio());
    courseDTO.setFechaFin(course.getFechaFin());
    courseDTO.setHorasDuracion(course.getHorasDuracion());
    courseDTO.setEstado(course.getEstado());

    return courseDTO;
  }

  public static Course mapCourseDTOToCourse(CourseDTO courseDTO) {
    Course course = new Course();
    course.setId(courseDTO.getId());
    course.setTitulo(courseDTO.getTitulo());
    course.setDescripcion(courseDTO.getDescripcion());
    course.setFechaInicio(courseDTO.getFechaInicio());
    course.setFechaFin(courseDTO.getFechaFin());
    course.setHorasDuracion(courseDTO.getHorasDuracion());
    course.setEstado(courseDTO.getEstado());

    return course;
  }


}
