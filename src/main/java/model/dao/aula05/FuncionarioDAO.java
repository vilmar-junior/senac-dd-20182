package model.dao.aula05;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.BaseDAO;
import model.vo.aula05.Funcionario;

public class FuncionarioDAO extends BaseDAO<Funcionario> {

	@Override
	public String getNomeTabela() {
		return "FUNCIONARIO";
	}

	@Override
	public String getNomeColunaChavePrimaria() {
		return "ID";
	}

	@Override
	public String getNomesColunasInsert() {
		return "NOME,MATRICULA,CPF";
	}

	@Override
	public String getInterrogacoesInsert() {
		return "?,?,?";
	}

	@Override
	public void setValoresAtributosInsert(Funcionario entidade, PreparedStatement preparedStmt) {
		try {
			preparedStmt.setString(1, entidade.getNome());
			preparedStmt.setString(2, entidade.getNumeroMatricula());
			preparedStmt.setString(3, entidade.getCpf());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getValoresClausulaSetUpdate(Funcionario entidade) {
		// SET NOME=func.getNome(), MATRICULA=func.getNumeroMatricula()...
		String clausulaSet = " NOME = ?, MATRICULA = ?, CPF = ?"; 
		
		return clausulaSet;
	}
	
	@Override
	public void setValoresAtributosUpdate(Funcionario entidade, PreparedStatement preparedStmt){
		//TODO Exercício: implementar na aula de 16/10
	}

	@Override
	public Funcionario construirObjetoDoResultSet(ResultSet resultado) {
		//TODO Exercício: implementar na aula de 16/10
		return null;
	}

}
