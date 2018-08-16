package model.vo.aula05;

public class Produto {
	
	private int id;
	private String nome;
	private String fabricante;
	private double valor;
	private double peso;
	
	public Produto(String nome, String fabricante, double valor, double peso) {
		super();
		this.nome = nome;
		this.fabricante = fabricante;
		this.valor = valor;
		this.peso = peso;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

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

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", fabricante=" + fabricante + "]";
	}
}