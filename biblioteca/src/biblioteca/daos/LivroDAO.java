package biblioteca.daos;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import biblioteca.models.Aluno;
import biblioteca.models.Livro;

	public class LivroDAO {

		private Connection connection;
		
		public LivroDAO () {
			connection = ConnectionFactory.getConnection();
		}
		
		public boolean inserir (Livro livro) {
			String sql = "insert into livro (nome, editora, autor, aluno)" + "values ( ?, ?, ?, ?);";
		
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, livro.getNome());
				stmt.setString(2, livro.getEditora());
				stmt.setString(3, livro.getAutor());
				stmt.setLong(4, livro.getAluno().getId());
				
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public List <Livro> getLista(Aluno a) {
			List <Livro> result = new ArrayList<>();
			
			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from livro where aluno=?");
				stmt.setLong(1, a.getId());
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					//Criando o objeto livro
					Livro livro = new Livro ();
					livro.setId(rs.getLong("id"));
					livro.setNome(rs.getString("nome"));
					livro.setEditora(rs.getString("editora"));
					livro.setAutor(rs.getString("autor"));
					livro.setAluno(new Aluno());
					livro.getAluno().setId(rs.getLong("aluno"));
					
					//Adicionando objeto a lista
					result.add(livro);
				}
				
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
		
		public boolean alterar (Livro livro) {
			String sql = "update livro set nome=?, editora=?, autor=? where id=?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, livro.getNome());
				stmt.setString(2, livro.getEditora());
				stmt.setString(3, livro.getAutor());
				stmt.setLong(4, livro.getId());
				
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public boolean remover (Livro livro) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from livro where id=?");
				
				stmt.setLong(1, livro.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public Livro getById(Long id) {
			Livro result = null;
			
			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from livro where id = ?;");
				stmt.setLong(1, id);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) { 
					//Criando o objeto livro
					result = new Livro();
					result.setId(rs.getLong("id"));
					result.setNome(rs.getString("nome"));
					result.setEditora(rs.getString("editora"));
					result.setAutor(rs.getString("autor"));
					result.setAluno(new Aluno());
					result.getAluno().setId(rs.getLong("aluno"));
				}
				
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
	}