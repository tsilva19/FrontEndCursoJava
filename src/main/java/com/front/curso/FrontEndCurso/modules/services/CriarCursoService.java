package com.front.curso.FrontEndCurso.modules.services;

import com.front.curso.FrontEndCurso.modules.dto.CursoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CriarCursoService {

    @Value("${host.api.gestao.cursos}")
    private String hostApiGestaoCursos;


    public String execute(CursoDTO curso){
        try{
            RestTemplate restTemplate = new RestTemplate();
            String url = hostApiGestaoCursos + "/cursos";

            restTemplate.postForEntity(url, curso, Object.class);
        } catch (Exception ex){
            return ex.getLocalizedMessage();
        }

        return null;
    }

}
