/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

/**
 * Classe abstrata com os métodos mínimos para que qualquer 
 * Data Access Object (DAO).
 * 
 * @author Vilmar César Pereira Júnior
 * @param T o tipo da entidade (ou VO) que associada ao DAO específico
 *	
 */
public abstract class BaseDAO<T> {

	private static final int CODIGO_RETORNO_SUCESSO_SQL = 1;
	/**
	 * 
	 * @param entidade a entidade do tipo informado a ser persistida
	 * @return 
	 * @throws SQLException
	 */
	public int inserir(T entidade){
		//SQL: 	INSERT INTO NOMETABELA (atributo1, atributo2,... atributoN) 
		//                  VALUES (?,?,...?)
		String query = " INSERT INTO " + getNomeTabela() + 
				" ( " + getNomesColunasInsert() +" ) VALUES ( " 
				+ getInterrogacoesInsert() + " ) ";

		Connection conn = Banco.getConnection();
		PreparedStatement preparedStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);
		int idEntidadeSalva = -1;

		try {
			//Este método DEVE ser implementado na classe concreta
			this.setValoresAtributosInsert(entidade, preparedStmt);

			boolean sucessoInsert = preparedStmt.execute();

			if(sucessoInsert){
				ResultSet rs = preparedStmt.getGeneratedKeys();
				idEntidadeSalva = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir " + entidade.getClass().toString());
		} finally {
			Banco.closeStatement(preparedStmt);
			Banco.closeConnection(conn);
		}
		return idEntidadeSalva;
	}
	public boolean atualizar(T entidade, int idEntidade) throws SQLException{
		//SQL: 	UPDATE NOMETABELA 
		//SET atributo1 = valor1, atributo2 = valor 2,... atributoN = valorN) WHERE IDTABELA = idEntidade
		String sql = "UPDATE "+ getNomeTabela() + 
				" SET " + getValoresClausulaSetUpdate(entidade)
		+ " WHERE" +  getNomeColunaChavePrimaria() + " = " + idEntidade;

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		boolean sucessoUpdate = false;

		try {
			//Este método DEVE ser implementado na classe concreta
			this.setValoresAtributosUpdate(entidade, stmt);
			
			int retorno = stmt.executeUpdate();
			sucessoUpdate = (retorno == CODIGO_RETORNO_SUCESSO_SQL);
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o registro com id = " + idEntidade + "da entidade " + entidade.getClass().toString());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return sucessoUpdate;
	}

	public boolean excluir(int idEntidade) throws SQLException{
		//SQL: 	DELETE FROM NomeTabela WHERE ID = idEntidade
		String sql = "DELETE FROM " + getNomeTabela() + " WHERE " + getNomeColunaChavePrimaria() + " = " + idEntidade;

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		boolean sucessoDelete = false;

		try{
			int resultado = stmt.executeUpdate(sql);
			sucessoDelete = (resultado == CODIGO_RETORNO_SUCESSO_SQL);
		} catch (SQLException e){
			System.out.println("Erro ao atualizar o registro com id = " + idEntidade + "da entidade " + this.getClass().toString());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

	public T pesquisarPorId(int idEntidade)throws SQLException{
		//SQL: SELECT * FROM NOMETABELA WHERE WHERE ID = idEntidade
		String sql = "SELECT * FROM "+ getNomeTabela()+" WHERE " + getNomeColunaChavePrimaria() + " = " + idEntidade;

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		T objetoConsultado = null;

		try{
			resultado = stmt.executeQuery(sql);
			while(resultado.next()){
				objetoConsultado = construirObjetoDoResultSet(resultado);
			}
		} catch (SQLException e){
			System.out.println("Erro ao consultar o registro com id = " + idEntidade + "da entidade " + this.getClass().toString());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return objetoConsultado;
	}

	public List<T> listarTodos() throws SQLException{
		String sql = "SELECT * FROM " + getNomeTabela();

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		ArrayList<T> listaEntidades = new ArrayList<T>();

		try{
			resultado = stmt.executeQuery(sql);
			while(resultado.next()){
				T objetoConsultado = construirObjetoDoResultSet(resultado);
				listaEntidades.add(objetoConsultado);
			}
		} catch (SQLException e){
			System.out.println("Erro ao consultar todos os objetos da entidade" + this.getClass().toString());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaEntidades;
	}


	/**
	 * Daqui para baixo...
	 * 
	 * Métodos abstratos, que obrigatoriamente serão implementados nas classes concretas.
	 * 
	 * Classe concreta: subclasse da classe abstrata que pode ter objeto construído.
	 * 
	 * */

	/**
	 * @return String o nome da tabela criado no BD.
	 */
	public abstract String getNomeTabela();

	/**
	 * @return String o nome da PK criada no BD.
	 */
	public abstract String getNomeColunaChavePrimaria();

	/**
	 * Constrói uma string formada pelos nomes das colunas (do BD) do INSERT separados por vírgula.
	 * 
	 * @return String os nomes das colunas separados por vírgula.
	 */
	public abstract String getNomesColunasInsert();

	/**
	 * Constrói uma string formada por pontos de interrogação separados por vírgula, onde cada 
	 * interrogação representa um das colunas que constam na cláusula INSERT ver ({@link #getNomesColunasInsert()}
	 * 
	 * @return String o texto com as interrogações separadas por vírgula.
	 */ 
	public abstract String getInterrogacoesInsert();

	/**
	 * Preenche os valores das colunas do insert um a um.
	 * 
	 * Obs.: A implementação deve levar em conta o tipo exato da coluna e da entidade,
	 * e também colocar aspas simples caso o valor seja uma String.
	 * 
	 * @param preparedStmt o objeto que detém a consulta SQL criada.
	 */
	public abstract void setValoresAtributosInsert(T entidade, PreparedStatement preparedStmt);

	/**
	 * Constrói uma string com os pares chave-valor da clásula SET de um UPDATE, onde:
	 * 
	 * chave = nome da coluna, valor = valor que será atualizado na coluna (vem do objeto em questão)
	 *
	 * Obs.: A implementação deve levar em conta o tipo exato da coluna e da entidade,
	 * e também colocar aspas simples caso o valor seja uma String.
	 * 
	 * @return String a clásula SET preenchida por completo.
	 */
	public abstract String getValoresClausulaSetUpdate(T entidade);
	
	public abstract void setValoresAtributosUpdate(T entidade, PreparedStatement stmt);

	/**
	 * Converte um resultSet para um objeto do tipo T.
	 * 
	 * @param resultado objeto do tipo ResultSet, que armazena as tuplas retornadas
	 * em uma determinada consulta.
	 * 
	 * @return T o objeto da classe concreta, com seus atributos preenchidos com valores
	 * oriundos do resultado.
	 */
	public abstract T construirObjetoDoResultSet(ResultSet resultado);

	//TODO e como listar com filtros? Veremos mais à frente ;)

}