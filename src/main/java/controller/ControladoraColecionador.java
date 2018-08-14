package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bo.ColecionadorBO;
import model.vo.ColecionadorVO;

/**
 * Classe criada na disciplina de POO (2018/1)
 * @author Adriano de Melo
 *
 */
public class ControladoraColecionador {

	public void cadastrarColecionadorController(ColecionadorVO colecionadorVO) throws SQLException {
		ColecionadorBO colecionadorBO = new ColecionadorBO();
		colecionadorBO.cadastrarColecionadorBO(colecionadorVO);
	}

	public void excluirColecionadorController(ColecionadorVO colecionadorVO) throws SQLException {
		ColecionadorBO colecionadorBO = new ColecionadorBO();
		colecionadorBO.excluirColecionadorBO(colecionadorVO);
	}

	public void atualizarColecionadorController(ColecionadorVO colecionadorVO) throws SQLException {
		ColecionadorBO colecionadorBO = new ColecionadorBO();
		colecionadorBO.atualizarColecionadorBO(colecionadorVO);
	}

	public ArrayList<ColecionadorVO> consultarTodosColecionadoresController() throws SQLException {
		ColecionadorBO colecionadorBO = new ColecionadorBO();
		return colecionadorBO.consultarColecionadoresBO();
	}

	public ColecionadorVO consultarColecionadorController(ColecionadorVO colecionadorVO) throws SQLException {
		ColecionadorBO colecionadorBO = new ColecionadorBO();
		return colecionadorBO.consultarColecionadorBO(colecionadorVO);
	}

}
