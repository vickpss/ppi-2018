package biblioteca.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Emprestimo {
	
	private Aluno aluno;
	private Livro livro;
	private Long id; 
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataEmprestimo;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataDevolucao;
	
	public Aluno getAluno() { 
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Livro getLivro() { 
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public String toString() {
		return "Emprestimo [aluno=" + aluno + ", livro=" + livro + ", id=" + id + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + "]";
	}
}
	
	

