package model.vo;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa um Value Object (VO) de um Artefato
 * 
 * @author Adriano de Melo
 * 
 */
public class ArtefatoVO {
	
	private int idArtefato;
	private String nome;
	private int ano;
	private double valor;
	
	public ArtefatoVO(int idArtefato, String nome, int ano, double valor) {
		super();
		this.idArtefato = idArtefato;
		this.nome = nome;
		this.ano = ano;
		this.valor = valor;
	}
	
	public ArtefatoVO() {
		super();
	}
	
	public int getIdArtefato() {
		return idArtefato;
	}
	
	public void setIdArtefato(int idArtefato) {
		this.idArtefato = idArtefato;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void imprimir(){
		//TODO
	}
}
