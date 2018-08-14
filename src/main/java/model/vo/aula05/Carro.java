package model.vo.aula05;

public class Carro extends Veiculo {

	private String categoria;
	private String numeroPortas;
	
	public Carro(int id, String marca, String modelo, String anoFabricacao, String chassi) {
		super(id, marca, modelo, anoFabricacao, chassi, Veiculo.NUMERO_RODAS_CARRO);
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(String numeroPortas) {
		this.numeroPortas = numeroPortas;
	}
	
	@Override
	public String toString(){
		//TODO fazer mais completo
		return "Carro ("+ this.getId() + "," + this.getMarca() + " - " + this.getModelo() + ")"; 
	}
}
