package com.perficient.university.app.controllers;

import com.perficient.university.app.dto.CourseDTO;
import com.perficient.university.app.entities.Course;
import com.perficient.university.app.mappers.CourseMapper;
import com.perficient.university.app.services.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( "/api/v1/courses" )

public class CourseController {

  @Autowired
  CourseServiceImpl courseService;

  @GetMapping
  public ResponseEntity<List<CourseDTO>> findAll(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "titulo") String sortBy
  ) {
    List<CourseDTO> list = courseService.findAll(pageNo, pageSize, sortBy);

    return  new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
  }

  @GetMapping(value = "/{uuid}")
  public ResponseEntity<CourseDTO> findById(@PathVariable UUID uuid){
    CourseDTO course = courseService.findById(uuid);

    return new ResponseEntity<>(course, new HttpHeaders(), HttpStatus.OK);
  }


  @PostMapping
  public ResponseEntity<CourseDTO> save(@RequestBody CourseDTO courseDTO) {
    return new ResponseEntity<>(courseService.create(courseDTO), HttpStatus.OK);
  }

  @PutMapping(value = "/{uuid}")
  public ResponseEntity<CourseDTO> update(@PathVariable UUID uuid, @RequestBody CourseDTO course) {
    courseService.update(uuid, course);
    return ResponseEntity.ok(course);
  }

  @PatchMapping(value = "/{uuid}")
  public ResponseEntity<CourseDTO> updatePatch(@PathVariable UUID uuid, @RequestBody CourseDTO course) {
    courseService.update(uuid, course);
    return ResponseEntity.ok(course);
  }


  @DeleteMapping(value = "/{uuid}")
  public ResponseEntity<CourseDTO> deleteById(@PathVariable UUID uuid) {
    CourseDTO courseEliminar = courseService.findById(uuid);
    if (courseEliminar != null) {
      courseService.delete(uuid);
      return ResponseEntity.status(HttpStatus.OK).body(courseEliminar);
    } else {
      return ResponseEntity.notFound().build();
    }

  }




}
