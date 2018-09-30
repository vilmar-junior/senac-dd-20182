package controller;

import model.bo.AlunoBO;
import model.vo.Aluno;

public class AlunoController {
	
	private AlunoBO bo = new AlunoBO();
	
	/**
	 * Retorna a situação do aluno, de acordo com a sua nota final calculada
	 * @param a o aluno informado
	 * @return a situação do aluno, de acordo com a descrição no item g) da prova
	 */
	public String salvar(Aluno a){
		String situacao;
		
		double mediaFinal = bo.calcularMediaFinal(a);
		
		if(mediaFinal >= 7){
			situacao = "Aprovado";
		}else if(mediaFinal >= 4.5){
			situacao = "Recuperação";
		}else{
			situacao = "Reprovado";
		}
		
		return situacao;
	}
	
	public double obterMediaFinal(Aluno al){
		return bo.calcularMediaFinal(al);
	}

	public boolean atualizarAluno(Aluno a) {
		return this.bo.atualizarAluno(a);
	}
}