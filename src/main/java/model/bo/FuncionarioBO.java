package model.bo;

import model.dao.aula05.FuncionarioDAO;
import model.vo.aula05.Funcionario;

public class FuncionarioBO {

	private FuncionarioDAO dao = new FuncionarioDAO();
	
	/**
	 * Tenta salvar um novo funcionário.
	 * @param novoFunc o novo funcionário a ser salvo
	 * @return true caso o CPF de novoFunc ainda não exista no banco e o funcionário foi salvo;
	 * 		   false caso contrário
	 */
	public boolean inserir(Funcionario novoFunc) {
		boolean sucesso = false;
		
		//Verificar se já existe funcionário com o CPF de novoFunc
		//Caso não -> salvar!
		if(!dao.temCPFCadastrado(novoFunc.getCpf())) {
			int novaChave = dao.inserir(novoFunc);
			
			if(novaChave > 0) {
				sucesso = true;
			}
		}
		
		return sucesso;
	}
}
