package com.front.curso.FrontEndCurso.modules.controller;

import com.front.curso.FrontEndCurso.modules.dto.CursoDTO;
import com.front.curso.FrontEndCurso.modules.services.ConsultaCursoService;
import com.front.curso.FrontEndCurso.modules.services.ConsultaCursosService;
import com.front.curso.FrontEndCurso.modules.services.CriarCursoService;
import com.front.curso.FrontEndCurso.modules.services.EditarCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CursoController {

    @Autowired
    private ConsultaCursosService consultaCursosService;

    @Autowired
    private ConsultaCursoService consultaCursoService;

    @Autowired
    private CriarCursoService criarCursoService;

    @Autowired
    private EditarCursoService editarCursoService;

    @GetMapping("/curso/lista")
    public String listPage(Model model){

        var result = consultaCursosService.execute();
        model.addAttribute("courses", result);

        return  "curso/lista";

    }

    @GetMapping("/curso/cadastro")
    public String paginaCadastrar(Model model){

        return  "curso/cadastro";

    }

    @PostMapping("/add-curso")
    public String cadastrarCurso(CursoDTO cursoDTO, RedirectAttributes redirectAttributes){

        String errorMessage = cursoDTO.isIncomplete()
                ? "Preencha todos os campos"
                : criarCursoService.execute(cursoDTO);

        if(errorMessage != null){
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
            return  "redirect:/curso/cadastro";
        }

        return  "redirect:/curso/lista";
    }

    @GetMapping("/course/{id}")
    public String coursePage(@PathVariable String id, Model model){

        var course = consultaCursoService.execute(id);
        model.addAttribute("course", course);

        return  "curso";

    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable String id, Model model){

        var course = consultaCursoService.execute(id);
        model.addAttribute("course", course);

        return  "edit";

    }

    @PostMapping("/edit-course")
    public String editCourse(CursoDTO cursoDTO, RedirectAttributes redirectAttributes){

        String errorMessage = cursoDTO.isIncomplete()
                ? "Preencha todos os campos"
                : criarCursoService.execute(cursoDTO);

        if(errorMessage != null){
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
            return  "curso/cadastro";
        }

        return  "redirect:/curso/lista";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){

        editarCursoService.delete(id);
        return  "redirect:/curso/lista";

    }

    @GetMapping("/active/{id}")
    public String toggleActive(@PathVariable String id){

        editarCursoService.toggleActive(id);
        return  "redirect:/curso/lista";

    }
}
