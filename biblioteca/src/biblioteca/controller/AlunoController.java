package biblioteca.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.daos.AlunoDAO;
import biblioteca.models.Aluno;


@Controller
public class AlunoController {
	// Comandos referentes a um aluno

	@RequestMapping("alunos/form")
	public String form() {
		return "alunos/form";
	}

	// Gravando o objeto aluno
	@RequestMapping(value = "alunos", method = RequestMethod.POST)
	public String gravar(Aluno a) {
		AlunoDAO dao = new AlunoDAO();
		dao.inserir(a);

		return "alunos/adicionado";
	}
	
	// Listando o aluno
	@RequestMapping(value = "alunos", method = RequestMethod.GET)
	public ModelAndView listar() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> alunos = dao.getLista();

		ModelAndView modelAndView = new ModelAndView("alunos/listar");
		modelAndView.addObject("alunos", alunos);
		return modelAndView;
	}
	
	// Removendo o aluno

	@RequestMapping(value = "alunos/remover")
	public String remover(Aluno a) {
		AlunoDAO dao = new AlunoDAO();
		dao.remover(a);

		return "redirect:/alunos";
	}

	// Selecionando 
	@RequestMapping(value = "alunos/selecionar")
	public ModelAndView selecionar(Aluno a) {
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = dao.getById(a.getId());

		ModelAndView modelAndView = new ModelAndView("alunos/form-alterar");
		modelAndView.addObject("aluno", aluno);

		return modelAndView;
	}
	
	// Alterar

	@RequestMapping(value = "alunos/alterar")
	public ModelAndView alterar(Aluno a) {
		AlunoDAO dao = new AlunoDAO();
		dao.alterar(a);

		return listar();
	}
}
