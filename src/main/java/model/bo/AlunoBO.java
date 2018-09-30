package model.bo;

import model.dao.AlunoDAO;
import model.vo.Aluno;

public class AlunoBO {
	
	private AlunoDAO aDAO = new AlunoDAO();
	/**
	 * Calcula a média final de um aluno
	 * @param o aluno com suas notas preenchidas
	 * @return a média ponderada entre provas e trabalhos:
	 * 			((NP1 + NP2)*PesoProvas)/2 + ((T1 + T2)*PesoTrabalhos)/2
	 * 
	 */
	public double calcularMediaFinal(Aluno aluno){
		return ((aluno.getNotaProva1() + aluno.getNotaProva2()) * aluno.getPesoProvas())/2 
				+ ((aluno.getNotaTrabalho1() + aluno.getNotaTrabalho2()) * aluno.getPesoTrabalhos())/2;
	}
	
	/**
	 * Salva um aluno no banco
	 * 
	 * @param novoAluno o aluno que será cadastrado no banco
	 * 
	 * @return boolean se salvou ou não o aluno 
	 * 
	 */
	public boolean salvarAluno(Aluno novoAluno){
		
		boolean salvou;
		//Verificar a soma dos pesos (esta validação também pode ser replicada no controlador)
		if(novoAluno.getPesoTrabalhos() + novoAluno.getPesoProvas() != 1){
			salvou = false;
		}else{
			//Temos que ver o que o DAO retorna
			int chaveGerada = this.aDAO.inserir(novoAluno);			
			salvou = (chaveGerada > 0);
		}
		
		return salvou;
	}

	public boolean atualizarAluno(Aluno a) {
		return this.aDAO.atualizar(a);
	}
}
