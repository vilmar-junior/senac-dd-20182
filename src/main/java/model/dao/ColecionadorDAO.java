package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.ColecionadorVO;

/**
 * Classe criada na disciplina de POO (2018/1)
 * @author Adriano de Melo
 * 
 */
public class ColecionadorDAO {

	public int cadastrarColecionadorDAO(ColecionadorVO colecionadorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO colecionador (nome, cpf, telefone, email) VALUES ('" + colecionadorVO.getNome() 
		+ "', '" + colecionadorVO.getCpf() + "', '" + colecionadorVO.getTelefone() 
		+ "', '" + colecionadorVO.getEmail() + "')";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Colecionador.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM colecionador WHERE cpf like '" + cpf + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Colecionador por CPF.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean existeRegistroPorIdColecionador(int idColecionador) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM colecionador WHERE idcolecionador = " + idColecionador;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Registro por Id.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirColecionadorDAO(ColecionadorVO colecionadorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM colecionador WHERE idcolecionador = " + colecionadorVO.getIdColecionador();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Colecionador.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarColecionadorDAO(ColecionadorVO colecionadorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE colecionador SET nome = '" + colecionadorVO.getNome() 
					+ "', cpf = '" + colecionadorVO.getCpf() + "'" 
					+ "', telefone = '" + colecionadorVO.getTelefone() + "'" 
					+ "', email = '" + colecionadorVO.getEmail() + "'" 
					+ " WHERE idcolecionador = " + colecionadorVO.getIdColecionador();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização do Colecionador.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<ColecionadorVO> consultarTodosColecionadoresDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ColecionadorVO> colecionadoresVO = new ArrayList<ColecionadorVO>();
		String query = "SELECT * FROM colecionador";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				ColecionadorVO colecionadorVO = new ColecionadorVO();
				colecionadorVO.setIdColecionador(Integer.parseInt(resultado.getString(1)));
				colecionadorVO.setNome(resultado.getString(2));
				colecionadorVO.setCpf(resultado.getString(3));
				colecionadorVO.setTelefone(resultado.getString(4));
				colecionadorVO.setEmail(resultado.getString(5));
				colecionadoresVO.add(colecionadorVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Clientes.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return colecionadoresVO;
	}

	public ColecionadorVO consultarColecionadorDAO(ColecionadorVO colecionadorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ColecionadorVO colecionador = new ColecionadorVO();
		
		String query = "SELECT * FROM colecionador WHERE idcolecionador = " + colecionadorVO.getIdColecionador();
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				colecionador.setIdColecionador(Integer.parseInt(resultado.getString(1)));
				colecionador.setNome(resultado.getString(2));
				colecionador.setCpf(resultado.getString(3));
				colecionador.setTelefone(resultado.getString(4));
				colecionador.setEmail(resultado.getString(5));
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Colecionador.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return colecionador;
	}

}
