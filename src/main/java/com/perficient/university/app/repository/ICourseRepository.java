package com.perficient.university.app.repository;

import com.perficient.university.app.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICourseRepository extends PagingAndSortingRepository<Course, UUID> {

  Page<Course> findById(UUID id, Pageable pageable);
  Course save(Course course);
  Course deleteById(UUID uuid);
}
