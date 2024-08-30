package com.front.curso.FrontEndCurso.modules.dto;

import java.time.LocalDateTime;

public record CursoDTO(Long id, String name, String teacher, String category, String active, LocalDateTime createdAt) {

    public boolean isIncomplete(){
        return name == null || name.isBlank()
                || teacher == null || teacher.isBlank()
                || category == null || category.isBlank();
    }
}
