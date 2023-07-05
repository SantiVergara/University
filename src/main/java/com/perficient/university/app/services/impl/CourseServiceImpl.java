package com.perficient.university.app.services.impl;

import com.perficient.university.app.dto.CourseDTO;
import com.perficient.university.app.entities.Course;
import com.perficient.university.app.mappers.CourseMapper;
import com.perficient.university.app.repository.ICourseRepository;
import com.perficient.university.app.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements ICourseService {

  @Autowired
  ICourseRepository cursoRepository;
  LocalDateTime currentDate = LocalDateTime.now();

  public List<CourseDTO> findAll(Integer pageNo, Integer pageSize, String sortBy) {
    PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

    List<CourseDTO> pagedResult = cursoRepository.findAll(paging)
        .stream()
        .map(CourseMapper::mapCourseToCourseDTO)
        .toList();

    if (!pagedResult.isEmpty()) {
      return pagedResult;
    } else {
      return new ArrayList<>();
    }
  }

  public CourseDTO findById(UUID uuid){
    Page<Course> curso = cursoRepository.findById(uuid, Pageable.unpaged());
    if (curso.hasContent()){
      return CourseMapper.mapCourseToCourseDTO(curso.iterator().next());
    } else {
      return new CourseDTO();
    }
  }

  public CourseDTO create(CourseDTO courseDTO) {
    Course course = CourseMapper.mapCourseDTOToCourse(courseDTO);

    course.setFechaCreacion(Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant()));

    return CourseMapper.mapCourseToCourseDTO(cursoRepository.save(course));
  }

  public CourseDTO update( UUID uuid, CourseDTO courseDTO){

    Course courseActualizar = CourseMapper.mapCourseDTOToCourse(findById(uuid));

    courseActualizar.setTitulo(courseDTO.getTitulo());
    courseActualizar.setDescripcion(courseDTO.getDescripcion());
    courseActualizar.setFechaInicio(courseDTO.getFechaInicio());
    courseActualizar.setFechaFin(courseDTO.getFechaFin());
    courseActualizar.setHorasDuracion(courseDTO.getHorasDuracion());
    courseActualizar.setEstado(courseDTO.getEstado());

    cursoRepository.save(courseActualizar);
    return CourseMapper.mapCourseToCourseDTO(courseActualizar);
  }


  public CourseDTO delete(UUID uuid) {
    return CourseMapper.mapCourseToCourseDTO(cursoRepository.deleteById(uuid));
  }



}
