package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import biblioteca.models.Aluno;

public class AlunoDAO  {
	
	private Connection connection;
	
	public AlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean inserir(Aluno aluno) {
		String sql = "insert into alunos (turma, nome, endereco, telefone)" + "values (?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, aluno.getTurma());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getEndereco());
			stmt.setString(4, aluno.getTelefone());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		return true;
	}

	public List <Aluno> getLista() {
		List<Aluno> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt =  this.connection.prepareStatement("select * from alunos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				//criando o objeto Aluno
				Aluno aluno = new Aluno ();
				aluno.setId(rs.getLong("id"));
				aluno.setTurma(rs.getString("turma"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setTelefone(rs.getString("telefone"));
				
				//adicionando o objeto a lista
				result.add(aluno);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean alterar (Aluno aluno) {
		String sql = "update alunos set turma=?, nome=?, endereco=?, telefone=? where id=?";
		
		try {
			PreparedStatement stmt =  connection.prepareStatement(sql);
			stmt.setString(1, aluno.getTurma());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getEndereco());
			stmt.setString(4, aluno.getTelefone());
			stmt.setLong(5, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean remover (Aluno aluno) {
		
		try {
			PreparedStatement stmt =  connection.prepareStatement("delete from alunos where id=?");
			stmt.setLong(1, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public Aluno getById(Long id) {
		Aluno result = null;
		
		try { 
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from alunos where id =?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				//criando o objeto Aluno
				result = new Aluno ();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setTurma(rs.getString("turma"));
				result.setEndereco(rs.getString("endereco"));
				result.setTelefone(rs.getString("telefone"));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
