package biblioteca.models;

import biblioteca.models.Aluno;

public class Livro {

	private Aluno aluno;
	private Long id;
	private String nome;
	private String editora;
	private String autor;
	
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora (String editora) {
		this.editora = editora;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
}
