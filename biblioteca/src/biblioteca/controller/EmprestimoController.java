package biblioteca.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.daos.AlunoDAO;
import biblioteca.daos.EmprestimoDAO;
import biblioteca.daos.LivroDAO;
import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;


@Controller
public class EmprestimoController  {
	
	@RequestMapping("emprestimos/form")
	public ModelAndView form(Aluno aluno){
		
		System.out.println(aluno.getId());
		
		AlunoDAO alunoDAO = new AlunoDAO();
		aluno = alunoDAO.getById(aluno.getId());
		LivroDAO livroDAO = new LivroDAO();
		
		System.out.println(aluno);
		System.out.println(aluno.getId());
		List<Livro> livro = livroDAO.getLista(aluno);
		
		ModelAndView modelAndView = new ModelAndView("emprestimos/form");
		modelAndView.addObject("aluno", aluno);
		modelAndView.addObject("livros", livroDAO.getLista(aluno));
		
		return modelAndView;
	}

	@RequestMapping(value="emprestimos", method=RequestMethod.POST)
	public String gravar(Emprestimo emprestimo) {
		
//		emprestimo.setDataEmprestimo(Calendar.getInstance());
		System.out.println("Emprestimo: " + emprestimo);
		EmprestimoDAO dao = new EmprestimoDAO();
		dao.inserir(emprestimo);
		
		return "emprestimos/adicionado";
	}
	
	
	@RequestMapping(value="emprestimos", method=RequestMethod.GET)
	public ModelAndView listar() {
		EmprestimoDAO dao_listar = new EmprestimoDAO();
		List <Emprestimo> emprestimos = dao_listar.getLista();
		
		LivroDAO livroDAO = new LivroDAO();
		AlunoDAO alunoDAO = new AlunoDAO();
		
		for(Emprestimo os : emprestimos){
			Aluno aluno = alunoDAO.getById(os.getAluno().getId());
			os.setAluno(aluno);
			Livro livro = livroDAO.getById(os.getLivro().getId());
			os.setLivro(livro);
		}
		
		ModelAndView modelAndView = new ModelAndView("emprestimos/listar");
		modelAndView.addObject("emprestimos", emprestimos);
		
		return modelAndView;
	}
	
	@RequestMapping(value="emprestimos/finalizar")
	public ModelAndView finalizar(Emprestimo emprestimo){
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimo = emprestimoDAO.getById(emprestimo.getId());
		
		emprestimoDAO.finalizar(emprestimo);
		
		ModelAndView modelAndView = new ModelAndView("redirect:../emprestimos");
		
		return modelAndView;
	}
}

