package com.front.curso.FrontEndCurso.modules.services;

import com.front.curso.FrontEndCurso.modules.dto.CursoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaCursoService {

    @Value("${host.api.gestao.cursos}")
    private String hostApiGestaoCursos;


    public CursoDTO execute(String id){

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = hostApiGestaoCursos + "/cursos";

            return restTemplate.getForEntity(url + "/id" + id, CursoDTO.class).getBody();
        } catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao Buscar Curso");
        }
    }
}
