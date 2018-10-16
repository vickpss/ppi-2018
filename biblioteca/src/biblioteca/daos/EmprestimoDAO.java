package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;

	public class EmprestimoDAO {
		private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Emprestimo emprestimo) {
		String sql = "insert into emprestimo ( dataEmprestimo, aluno, livro)" + "values ( ?, ?, ?);";

		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(emprestimo.getDataEmprestimo().getTimeInMillis()));
			stmt.setLong(2, emprestimo.getAluno().getId());
			stmt.setLong(3, emprestimo.getLivro().getId());
			stmt.execute();
			stmt.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Emprestimo> getLista() {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto emprestimo
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setId(rs.getLong("id"));
				emprestimo.setAluno(new Aluno());
				emprestimo.getAluno().setId(rs.getLong("aluno"));
				emprestimo.setLivro(new Livro());
				emprestimo.getLivro().setId(rs.getLong("livro"));

				// Montando as datas através do Calendar

				Date dataSTemp = rs.getDate("dataEmprestimo");

				if (dataSTemp != null) {
					Calendar dataS = Calendar.getInstance();
					dataS.setTime(dataSTemp);
					emprestimo.setDataEmprestimo(dataS);
				}

				Date dataFTemp = rs.getDate("dataDevolucao");
				if (dataFTemp != null) {
					Calendar dataF = Calendar.getInstance();
					dataF.setTime(dataFTemp);
					emprestimo.setDataDevolucao(dataF);
				}

				// Adicionando um objeto a lista
				result.add(emprestimo);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean remover(Emprestimo emprestimo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete * from emprestimo where id=?");
			stmt.setLong(1, emprestimo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean finalizar(Emprestimo emprestimo) {
		String sql = "update emprestimo set dataDevolucao=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			emprestimo.setDataDevolucao(Calendar.getInstance());
			stmt.setDate(1, new java.sql.Date(emprestimo.getDataDevolucao().getTimeInMillis()));
			stmt.setLong(2, emprestimo.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public Emprestimo getById(Long id) {
		Emprestimo result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Criando o objeto emprestimos
				result = new Emprestimo();
				result.setId(rs.getLong("id"));
				result.setAluno(new Aluno());
				result.getAluno().setId(rs.getLong("aluno"));
				result.setLivro(new Livro());
				result.getLivro().setId(rs.getLong("livro"));

				// Montando as datas através do Calendar
				Date dataSTemp = rs.getDate("dataEmprestimo");

				if (dataSTemp != null) {
					Calendar dataS = Calendar.getInstance();
					dataS.setTime(dataSTemp);
					result.setDataEmprestimo(dataS);
				}

				Date dataFTemp = rs.getDate("dataDevolucao");
				if (dataFTemp != null) {
					Calendar dataF = Calendar.getInstance();
					dataF.setTime(dataFTemp);
					result.setDataDevolucao(dataF);
				}

				rs.close();
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}