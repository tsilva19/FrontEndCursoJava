package com.front.curso.FrontEndCurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontEndCursoApplication {

	public static void main(String[] args) {
		System.setProperty("host.api.gestao.cursos", "http://localhost:8080");
		SpringApplication.run(FrontEndCursoApplication.class, args);
	}

}
