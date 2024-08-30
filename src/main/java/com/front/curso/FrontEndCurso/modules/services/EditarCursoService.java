package com.front.curso.FrontEndCurso.modules.services;

import com.front.curso.FrontEndCurso.modules.dto.CursoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EditarCursoService {

    @Value("${host.api.gestao.cursos}")
    private String hostApiGestaoCursos;

    private final RestTemplate restTemplate;

    public EditarCursoService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String execute(CursoDTO curso){
        try{
            String url = hostApiGestaoCursos + "/cursos";

            restTemplate.put(url + "/" + curso.id(), curso, Object.class);
        } catch (Exception ex){
            return ex.getLocalizedMessage();
        }

        return null;
    }

    public void delete(String id){
        String url = hostApiGestaoCursos + "/cursos";

        restTemplate.delete(url + "/" + id);
    }

    public void toggleActive(String id){
        String url = hostApiGestaoCursos + "/cursos";

        restTemplate.patchForObject(url + "/" + id + "/active", "", Object.class);
    }
}
