package com.perficient.university.app.controllers;

import com.perficient.university.app.services.impl.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class CourseControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CourseServiceImpl cursoService;

  @Test
  void testObtenerCursos() throws Exception {
    mockMvc.perform(get("/api/v1/cursos")).andDo(print());
  }

  /*void testObtenerCursoporUuid() {
    Long userId = 1L;
    Curso curso = new Curso(userId, "John Doe", "john@example.com");

    Mockito.when(cursoService.obtenerCursoporUuid(userId)).thenReturn(curso);

    mockMvc.perform(get("/users/{id}", userId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is("John Doe")))
        .andExpect(jsonPath("$.email", is("john@example.com")));

  }*/

}
