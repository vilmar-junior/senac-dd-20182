package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Aluno;

public class AlunoDAO {
	
	/**
	 * 
	 * @param a o novo aluno a ser salvo
	 * @return id caso positivo, é a chave gerada pelo SGBD
	 * 			  caso -1, houve erro no INSERT
	 */
	public int inserir(Aluno a){
		int novoId = -1;
		//

		String sql = " INSERT INTO ALUNO (NOME, MATRICULA, NOTA_P1, NOTA_P2, NOTA_T1, NOTA_T2,"
				+ " PESO_PROVAS, PESO_TRABALHOS, NIVEL, SOBRENOME) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, a.getNome());
			prepStmt.setString(2, a.getMatricula());
			prepStmt.setDouble(3, a.getNotaProva1());
			prepStmt.setDouble(4, a.getNotaProva2());
			prepStmt.setDouble(5, a.getNotaTrabalho1());
			prepStmt.setDouble(6, a.getNotaTrabalho2());
			prepStmt.setDouble(7, a.getPesoProvas());
			prepStmt.setDouble(8, a.getPesoTrabalhos());
			prepStmt.setString(9, a.getNivel());
			prepStmt.setString(10, a.getSobrenome());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir aluno. Causa: \n:" + e.getMessage());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return novoId;
	}

	public boolean atualizar(Aluno a){
		boolean sucessoUpdate = false;

		String sql = " UPDATE ALUNO P SET NOME=?, SOBRENOME=?, MATRICULA=?, NOTA_P1=?, NOTA_P2=?"
				+ "NOTA_T1=?, NOTA_T2=?, PESO_PROVAS=?, PESO_TRABALHOS=?, NIVEL=?, SITUACAO=?, NOTA_FINAL=? "
				+ " WHERE P.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, a.getNome());
			prepStmt.setString(2, a.getSobrenome());
			prepStmt.setString(3, a.getMatricula());
			prepStmt.setDouble(4, a.getNotaProva1());
			prepStmt.setDouble(5, a.getNotaProva2());
			prepStmt.setDouble(6, a.getNotaTrabalho1());
			prepStmt.setDouble(7, a.getNotaTrabalho2());
			prepStmt.setDouble(8, a.getPesoProvas());
			prepStmt.setDouble(9, a.getPesoTrabalhos());
			prepStmt.setString(10, a.getNivel());
			prepStmt.setString(11, a.getSituacao());
			prepStmt.setDouble(12, a.getNotaFinal());

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar aluno. Causa: \n:" + e.getCause());
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}
	
	public boolean remover(int id){
		boolean sucessoDelete = false;

		String sql = " DELETE FROM ALUNO "
				+ " WHERE ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		try {
			prepStmt.setInt(1, id);
			int codigoRetorno = prepStmt.executeUpdate();
			if(codigoRetorno == 1){//1 - sucesso na execução
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao remover aluno. Causa: \n:" + e.getCause());
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return sucessoDelete;
	}
	
	public ArrayList<Aluno> listarTodos(){
		String sql = " SELECT * FROM ALUNO ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				Aluno aluno = new Aluno();
				
				aluno.setId(result.getInt("ID"));
				aluno.setNome(result.getString("NOME"));
				aluno.setMatricula(result.getString("MATRICULA"));
				aluno.setNotaProva1(result.getDouble("NOTA_P1"));
				aluno.setNotaProva2(result.getDouble("NOTA_P2"));
				
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			System.out.println("Erro listar todos os alunos. Causa: \n:" + e.getCause());
		}
		return alunos;
	}
	/**
	 * Retorna um produto dado um id.
	 * 
	 * @param id o identificador do produto
	 * @return um produto caso o id exista na tabela Produto
	 * 		   null caso contrário
	 */
	public Aluno obterPorId(int id){
		String sql = " SELECT * FROM ALUNO "
				+ " WHERE ID=?";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		Aluno aluno = null;
		
		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				aluno = new Aluno();
				
				aluno.setId(result.getInt("ID"));
				aluno.setNome(result.getString("NOME"));
				aluno.setMatricula(result.getString("MATRICULA"));
				aluno.setNotaProva1(result.getDouble("NOTA_P1"));
				aluno.setNotaProva2(result.getDouble("NOTA_P2"));
			}
		} catch (SQLException e) {
			System.out.println("Erro buscar um aluno. Causa: \n:" + e.getCause());
		}
		return aluno;
	}
}