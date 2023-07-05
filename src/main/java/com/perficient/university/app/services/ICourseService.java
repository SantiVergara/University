package com.perficient.university.app.services;

import com.perficient.university.app.dto.CourseDTO;
import com.perficient.university.app.entities.Course;
import java.util.List;
import java.util.UUID;

public interface ICourseService {

  List<CourseDTO> findAll(Integer pageNo, Integer pageSize, String sortBy);
  CourseDTO findById(UUID uuid);
  CourseDTO create(CourseDTO courseDTO);
  CourseDTO delete(UUID uuid);



}
