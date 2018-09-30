package model.vo;

public class Aluno {

	private int id;
	private String nome;
	private String matricula;
	private double notaProva1;
	private double notaProva2;
	
	//Novos campos solicitados na prova -> INCLUIR ESTES CAMPOS NO DAO
	private String sobrenome;
	private String nivel;
	private double notaTrabalho1;
	private double notaTrabalho2;
	private double pesoProvas;
	private double pesoTrabalhos;
	private double notaFinal;
	private String situacao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getNotaProva1() {
		return notaProva1;
	}
	public void setNotaProva1(double notaProva1) {
		this.notaProva1 = notaProva1;
	}
	public double getNotaProva2() {
		return notaProva2;
	}
	public void setNotaProva2(double notaProva2) {
		this.notaProva2 = notaProva2;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public double getNotaTrabalho1() {
		return notaTrabalho1;
	}
	public void setNotaTrabalho1(double notaTrabalho1) {
		this.notaTrabalho1 = notaTrabalho1;
	}
	public double getNotaTrabalho2() {
		return notaTrabalho2;
	}
	public void setNotaTrabalho2(double notaTrabalho2) {
		this.notaTrabalho2 = notaTrabalho2;
	}
	public double getPesoProvas() {
		return pesoProvas;
	}
	public void setPesoProvas(double pesoProvas) {
		this.pesoProvas = pesoProvas;
	}
	public double getPesoTrabalhos() {
		return pesoTrabalhos;
	}
	public void setPesoTrabalhos(double pesoTrabalhos) {
		this.pesoTrabalhos = pesoTrabalhos;
	}
	public double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}