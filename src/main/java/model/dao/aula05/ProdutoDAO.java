package model.dao.aula05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import model.dao.Banco;
import model.vo.aula05.Produto;

public class ProdutoDAO {

	public int inserir(Produto p){
		int novoId = -1;

		String sql = " INSERT INTO PRODUTO (NOME, FABRICANTE, VALOR, PESO) "
				+ " VALUES (?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, p.getNome());
			prepStmt.setString(2, p.getFabricante());
			prepStmt.setDouble(3, p.getValor());
			prepStmt.setDouble(4, p.getPeso());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir produto. Causa: \n: " + e.getMessage());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return novoId;
	}

	public boolean atualizar(Produto p){
		boolean sucessoUpdate = false;

		String sql = " UPDATE PRODUTO P SET NOME=?, FABRICANTE=?, VALOR=?, PESO=? "
				+ " WHERE P.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, p.getNome());
			prepStmt.setString(2, p.getFabricante());
			prepStmt.setDouble(3, p.getValor());
			prepStmt.setDouble(4, p.getPeso());
			prepStmt.setDouble(5, p.getId());

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar produto");
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}
	
	//DELETE
	public boolean remover(int id){
		boolean sucessoDelete = false;

		String sql = " DELETE FROM PRODUTO "
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
			System.out.println("Erro ao remover produto. Id = " + id);
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return sucessoDelete;
	}
	
	public ArrayList<Produto> listarPorFaixaDePreco(double valorMaximo){
		String sql = " SELECT * FROM PRODUTO WHERE VALOR < ? ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try {
			prepStmt.setDouble(1, valorMaximo);
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				Produto p = new Produto();
				
				//Obtendo valores pelo NOME DA COLUNA
				p.setId(result.getInt("ID"));
				p.setNome(result.getString("NOME"));
				p.setFabricante(result.getString("FABRICANTE"));
				
				//Outra forma de obter (POSICIONAL)
				p.setValor(result.getDouble(4));
				p.setPeso(result.getDouble(5));
				produtos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
		
	}
	
	
	public ArrayList<Produto> listarTodos(){
		String sql = " SELECT * FROM PRODUTO ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try {
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				Produto p = new Produto();
				
				//Obtendo valores pelo NOME DA COLUNA
				p.setId(result.getInt("ID"));
				p.setNome(result.getString("NOME"));
				p.setFabricante(result.getString("FABRICANTE"));
				
				//Outra forma de obter (POSICIONAL)
				p.setValor(result.getDouble(4));
				p.setPeso(result.getDouble(5));
				produtos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	/**
	 * Retorna um produto dado um id.
	 * 
	 * @param id o identificador do produto
	 * @return um produto caso o id exista na tabela Produto
	 * 		   null caso contrário
	 */
	public Produto obterPorId(int id){
		String sql = " SELECT * FROM PRODUTO "
				+ " WHERE ID=?";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		Produto p = null;
		
		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				p = new Produto();
				
				//Obtendo valores pelo NOME DA COLUNA
				p.setId(result.getInt("ID"));
				p.setNome(result.getString("NOME"));
				p.setFabricante(result.getString("FABRICANTE"));
				
				//Outra forma de obter (POSICIONAL)
				p.setValor(result.getDouble(4));
				p.setPeso(result.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}