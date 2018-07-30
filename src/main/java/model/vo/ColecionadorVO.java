package model.vo;

public class ColecionadorVO {
	
	private int idColecionador;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	public ColecionadorVO(int idColecionador, String nome, String cpf, String telefone, String email) {
		super();
		this.idColecionador = idColecionador;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}
	
	public ColecionadorVO() {
		super();
	}

	public int getIdColecionador() {
		return idColecionador;
	}

	public void setIdColecionador(int idColecionador) {
		this.idColecionador = idColecionador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void imprimir(){
		System.out.printf("%3d   %-20s   %-15s   %-12s   %-20s \n", 
		this.getIdColecionador(), 
		this.getNome(), 
		this.getCpf(), 
		this.getTelefone(), 
		this.getEmail());
	}
	
}
