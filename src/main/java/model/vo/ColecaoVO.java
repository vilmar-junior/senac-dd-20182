package model.vo;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa um Value Object (VO) de uma Colecao
 * 
 * @author Adriano de Melo
 * 
 */
public class ColecaoVO {
	
	private int idColecao;
	private int idColecionador;
	private int idArtefato;
	
	public ColecaoVO(int idColecao, int idColecionador, int idArtefato) {
		super();
		this.idColecao = idColecao;
		this.idColecionador = idColecionador;
		this.idArtefato = idArtefato;
	}

	public ColecaoVO() {
		super();
	}

	public int getIdColecao() {
		return idColecao;
	}

	public void setIdColecao(int idColecao) {
		this.idColecao = idColecao;
	}

	public int getIdColecionador() {
		return idColecionador;
	}

	public void setIdColecionador(int idColecionador) {
		this.idColecionador = idColecionador;
	}

	public int getIdArtefato() {
		return idArtefato;
	}

	public void setIdArtefato(int idArtefato) {
		this.idArtefato = idArtefato;
	}

	public void imprimir(){
		//TODO
	}

}
