package controller;

import model.bo.FuncionarioBO;
import model.vo.aula05.Funcionario;

public class FuncionarioController {
	
	private FuncionarioBO bo = new FuncionarioBO();
	
	/**
	 * Salva um funcionário
	 * 
	 * 
	 * @param func o funcionário a ser salvo no Banco
	 * @return mensagem de sucesso, caso func seja persistido
	 * 		   mensagem de erro, caso contrário (ex.: CPF já existe no banco)
	 */
	public String salvar(Funcionario func) {
		String msgRetorno = "";
		boolean salvou = bo.inserir(func);
		
		if(salvou) {
			msgRetorno = "Funcionário cadastrado!";
		}else {
			msgRetorno = "CPF já existe no banco!";
		}
		
		return msgRetorno;
	}
}
