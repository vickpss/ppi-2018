package biblioteca.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.daos.AlunoDAO;
import biblioteca.daos.LivroDAO;
import biblioteca.models.Aluno;
import biblioteca.models.Livro;


@Controller
public class LivroController {

	@RequestMapping("livros/form")
	public ModelAndView form(Aluno aluno) {
		AlunoDAO dao = new AlunoDAO();
		aluno = dao.getById(aluno.getId());
		
		ModelAndView modelAndView = new ModelAndView("livros/form");
		modelAndView.addObject("aluno", aluno);
		
		return modelAndView;
	}
	
	@RequestMapping(value="livros", method=RequestMethod.POST)
	public String gravar(Livro l){
		LivroDAO dao = new LivroDAO();
		dao.inserir(l);
		
		return "livros/adicionado";
	} 

	@RequestMapping(value="livros", method=RequestMethod.GET)
	public ModelAndView listar(Aluno aluno) {
		AlunoDAO dao = new AlunoDAO();
		aluno = dao.getById(aluno.getId());
		
		LivroDAO livroDAO = new LivroDAO();
		List <Livro> livros = livroDAO.getLista(aluno);
		
		System.out.println(livros.size());
		
		ModelAndView modelAndView = new ModelAndView("livros/listar");
		modelAndView.addObject("livros", livros);
		modelAndView.addObject("aluno", aluno);
		
		return modelAndView;
	}
	
	@RequestMapping(value="livros/remover")
	public String remover(Livro l) {
		LivroDAO dao = new LivroDAO();
		l = dao.getById(l.getId());
		dao.remover(l);
		
		return "redirect:/livros?id="+l.getAluno().getId();
	}
	
	@RequestMapping(value="livros/selecionar")
	public ModelAndView selecionar(Livro l) {
		LivroDAO dao = new LivroDAO();
		Livro livro = dao.getById(l.getId());
		
		ModelAndView modelAndView = new ModelAndView("livros/form-alterar");
		modelAndView.addObject("livro", livro);
		
		return modelAndView;
	}
	
	@RequestMapping(value="livros/alterar")
	public String alterar(Livro l) {
		LivroDAO dao = new LivroDAO();
		dao.alterar(l);
		
		return "redirect:/livros?id="+l.getAluno().getId();
	}
}
