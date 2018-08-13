package model.bo;

import java.util.ArrayList;

import model.dao.ColecionadorDAO;
import model.vo.ColecionadorVO;

/**
 * Classe criada na disciplina de POO (2018/1)
 * @author Adriano de Melo
 *
 */
public class ColecionadorBO {

	public void cadastrarColecionadorBO(ColecionadorVO colecionadorVO) {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		if(colecionadorDAO.existeRegistroPorCpf(colecionadorVO.getCpf())){
			System.out.println("\nColecionador já Cadastrado");
		} else {
			int resultado = colecionadorDAO.cadastrarColecionadorDAO(colecionadorVO);
			if(resultado == 1){
				System.out.println("\nColecionador cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrat o Colecionador.");
			}
		}
	}

	public void excluirColecionadorBO(ColecionadorVO colecionadorVO) {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		if(colecionadorDAO.existeRegistroPorIdColecionador(colecionadorVO.getIdColecionador())){
			int resultado = colecionadorDAO.excluirColecionadorDAO(colecionadorVO);
			if(resultado == 1){
				System.out.println("\nColecionador excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Colecionador.");
			}
		} else {
			System.out.println("\nColecionador não existe na base da dados.");
		}
	}

	public void atualizarColecionadorBO(ColecionadorVO colecionadorVO) {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		if(colecionadorDAO.existeRegistroPorIdColecionador(colecionadorVO.getIdColecionador())){
			int resultado = colecionadorDAO.atualizarColecionadorDAO(colecionadorVO);
			if(resultado == 1){
				System.out.println("\nColecionador atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Colecionador.");
			}
		} else {
			System.out.println("\nColecionador ainda não foi cadastrado.");
		}
	}
	
	public ArrayList<ColecionadorVO> consultarColecionadoresBO() {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		ArrayList<ColecionadorVO> colecionadoresVO = colecionadorDAO.consultarTodosColecionadoresDAO();
		if(colecionadoresVO.isEmpty()){
			System.out.println("\nLista de Colecionador não Localizada.");
		}
		return colecionadoresVO;
	}

	public ColecionadorVO consultarColecionadorBO(ColecionadorVO colecionadorVO) {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		ColecionadorVO colecionador = colecionadorDAO.consultarColecionadorDAO(colecionadorVO);
		if(colecionador == null){
			System.out.println("\nColecionador não Localizado.");
		}
		return colecionador;
	}

}
