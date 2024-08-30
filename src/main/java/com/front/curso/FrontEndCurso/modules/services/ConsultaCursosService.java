package com.front.curso.FrontEndCurso.modules.services;

import com.front.curso.FrontEndCurso.modules.dto.CursoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaCursosService {

    @Value("${host.api.gestao.cursos}")
    private String hostApiGestaoCursos;


    public CursoDTO[] execute(){

            RestTemplate restTemplate = new RestTemplate();
            String url = hostApiGestaoCursos + "/cursos";

            return restTemplate.getForEntity(url, CursoDTO[].class).getBody();

    }
}
