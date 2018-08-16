package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.ColecionadorVO;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa um Data Access Object (DAO) da classe ColecionadorVO.
 * 
 * @author Adriano de Melo
 *  	   Vilmar César Pereira Júnior (continuação em Desenvolvimento Desktop 2018/2)
 * 
 */
public class ColecionadorDAO extends BaseDAO<ColecionadorVO> {
	
	@Override
	public String getNomeTabela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNomeColunaChavePrimaria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNomesColunasInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInterrogacoesInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValoresAtributosInsert(ColecionadorVO entidade, PreparedStatement preparedStmt) {
		// TODO Auto-generated method stub
		/**
		 * Exemplos:
		 * preparedStmt.setInt(1, entidade.getId());  
		 * preparedStmt.setString(2, entidade.getNome());
		 *  
		 */
		
	}

	@Override
	public String getValoresClausulaSetUpdate(ColecionadorVO entidade) {
		// TODO Auto-generated method stub
		
		/**
		 * Exemplos:
		 * 
		 * String clausulaSet = "";
		 * clausulaSet = getNomeColunaChavePrimaria() " = " + entidade.getIdColecionador() + ",";
		 * clausulaSet += "NOME ='" + entidade.getNome() + "'";
		 */
		
 		return null;
	}

	@Override
	public ColecionadorVO construirObjetoDoResultSet(ResultSet resultado) {
		// TODO Auto-generated method stub
		
//      Exemplo:
//      ColecionadorVO colecionadorVO = new ColecionadorVO();
//		colecionadorVO.setIdColecionador(Integer.parseInt(resultado.getString(1)));
//		colecionadorVO.setNome(resultado.getString(2));
//		colecionadorVO.setCpf(resultado.getString(3));
//		colecionadorVO.setTelefone(resultado.getString(4));
//		colecionadorVO.setEmail(resultado.getString(5));
//		colecionadoresVO.add(colecionadorVO);
		return null;
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

	@Override
	public void setValoresAtributosUpdate(ColecionadorVO entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}
	
}