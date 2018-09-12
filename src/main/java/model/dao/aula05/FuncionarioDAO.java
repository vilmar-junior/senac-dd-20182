package model.dao.aula05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
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
		//Preenche cada interrogação da cláusula SET
		try {
			preparedStmt.setString(1, entidade.getNome());
			preparedStmt.setString(2, entidade.getNumeroMatricula());
			preparedStmt.setString(3, entidade.getCpf());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Funcionario construirObjetoDoResultSet(ResultSet resultado) {
		
		Funcionario novoFuncionario = null; //retorna null caso o resultado esteja vazio
		try {
			novoFuncionario = new Funcionario();
			novoFuncionario.setIdFuncionario(resultado.getInt("ID"));
			novoFuncionario.setNome(resultado.getString("NOME"));
			novoFuncionario.setNumeroMatricula(resultado.getString("MATRICULA"));
			novoFuncionario.setCpf(resultado.getString("CPF"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return novoFuncionario;
	}

	public boolean temCPFCadastrado(String cpf) {
		String sql = "SELECT COUNT(*) FROM FUNCIONARIO WHERE CPF = ?";
		boolean temFuncionarioComEsseCPF = false;
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		try{
			stmt.setString(1, cpf);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				int quantidadeRegistros = resultado.getInt(1);
				temFuncionarioComEsseCPF = (quantidadeRegistros > 0);
			}
		} catch (SQLException e){
			System.out.println("Erro ao consultar o CPF = " + cpf);
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return temFuncionarioComEsseCPF;
	}
}
