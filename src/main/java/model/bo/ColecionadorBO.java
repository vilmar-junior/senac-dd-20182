package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.ColecionadorDAO;
import model.vo.ColecionadorVO;

/**
 * Classe criada na disciplina de POO (2018/1)
 * @author Adriano de Melo
 *
 */
public class ColecionadorBO {

	public void cadastrarColecionadorBO(ColecionadorVO colecionadorVO) throws SQLException {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		if(colecionadorDAO.existeRegistroPorCpf(colecionadorVO.getCpf())){
			System.out.println("\nColecionador já Cadastrado");
		} else {
			int idColecionador = colecionadorDAO.inserir(colecionadorVO);
			if(idColecionador > 0){
				System.out.println("\nColecionador cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar o Colecionador.");
			}
		}
	}

	public void excluirColecionadorBO(ColecionadorVO colecionadorVO) throws SQLException {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		if(colecionadorDAO.existeRegistroPorIdColecionador(colecionadorVO.getIdColecionador())){
			boolean excluiuColecionador = colecionadorDAO.excluir(colecionadorVO.getIdColecionador());
			if(excluiuColecionador){
				System.out.println("\nColecionador excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Colecionador.");
			}
		} else {
			System.out.println("\nColecionador não existe na base da dados.");
		}
	}

	public void atualizarColecionadorBO(ColecionadorVO colecionadorVO) throws SQLException {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		if(colecionadorDAO.existeRegistroPorIdColecionador(colecionadorVO.getIdColecionador())){
			boolean sucessoUpdate = colecionadorDAO.atualizar(colecionadorVO, colecionadorVO.getIdColecionador());
			if(sucessoUpdate){
				System.out.println("\nColecionador atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Colecionador.");
			}
		} else {
			System.out.println("\nColecionador ainda não foi cadastrado.");
		}
	}
	
	public ArrayList<ColecionadorVO> consultarColecionadoresBO() throws SQLException {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		ArrayList<ColecionadorVO> colecionadoresVO = (ArrayList<ColecionadorVO>) colecionadorDAO.listarTodos();
		if(colecionadoresVO.isEmpty()){
			System.out.println("\nLista de Colecionador não Localizada.");
		}
		return colecionadoresVO;
	}

	public ColecionadorVO consultarColecionadorBO(ColecionadorVO colecionadorVO) throws SQLException {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		ColecionadorVO colecionador = colecionadorDAO.pesquisarPorId(colecionadorVO.getIdColecionador());
		if(colecionador == null){
			System.out.println("\nColecionador não Localizado.");
		}
		return colecionador;
	}

}
