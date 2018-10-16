package biblioteca.models;

import java.util.List;



	public class Aluno {
		
		private Long id;
		private String turma;
		private String nome;
		private String endereco;
		private String telefone;
		private List<Livro> livros;
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getTurma() {
			return turma;
		}
		
		public void setTurma(String turma) {
			this.turma = turma;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getEndereco() {
			return endereco;
		}
		
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		
		public String getTelefone () {
			return telefone;
		}
		
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
	}


