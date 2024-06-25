package com.projeto.ads.controller;

import java.util.Calendar; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.GetMapping; import org.springframework.web.bind.annotation.PathVariable; import org.springframework.web.bind.annotation.PostMapping; import org.springframework.web.servlet.ModelAndView; import com.projeto.ads.model.Aluno; import com.projeto.ads.service.AlunoService;

@Controller public class AlunoController {

 
@Autowired
private AlunoService alunoService;

@PostMapping("/aluno/inserir")
public ModelAndView insertAlunoPOST(Aluno aluno) {
    ModelAndView mv = new ModelAndView();
    String resposta = alunoService.cadastrarAluno(aluno);
    if (resposta != null) {
        mv.addObject("msg", resposta);
        mv.addObject("aluno", new Aluno());
        mv.setViewName("Login/inserirAluno");
    } else {
        mv.setViewName("redirect:/aluno/listar/");
    }
    return mv;
}

@GetMapping("/aluno/listar/")
public ModelAndView listarAlunos() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("alunos", alunoService.findAllOrderedById());
    mv.setViewName("Aluno/listarAlunos");
    return mv;
}

@GetMapping("/aluno/inserir/")
public ModelAndView insertAlunoGET() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("aluno", new Aluno());
    mv.setViewName("Aluno/inserir");
    return mv;
}

@GetMapping("/aluno/alterar/{id}")
public ModelAndView alterarAlunos(@PathVariable("id") Long id) {
    ModelAndView mv = new ModelAndView();
    Aluno aluno = alunoService.findById(id);
    mv.addObject("aluno", aluno);
    mv.setViewName("Aluno/alterarAluno");
    return mv;
}

@GetMapping("/aluno/editar")
public ModelAndView alterarAluno() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("aluno", alunoService.findAllOrderedById());
    mv.setViewName("Aluno/listarAlunos");
    return mv;
}

@PostMapping("/aluno/alterar")
public ModelAndView alterarAlunos(Aluno aluno) {
    ModelAndView mv = new ModelAndView();
    String out = alunoService.AlterarAluno(aluno, getId());
    if (out != null) {
        mv.addObject("msg", out);
        mv.addObject("aluno", aluno);
        mv.setViewName("Aluno/alterarAluno");
    } else {
        mv.setViewName("redirect:/aluno/listar");
    }

    return mv;
}

private Long getId() {
    // Coloque a lógica para obter o ID aqui
    return null;
}

@GetMapping("/aluno/excluir/{id}")
public String excluirAluno(@PathVariable("id") Long id) {
    alunoService.deleteById(id);
    return "redirect:/aluno/listar";
}
}