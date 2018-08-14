package model.vo.aula05;

public class Caminhao extends Veiculo{
	
	private static final double CAPACIDADE_DEZ_TONELADAS = 0;
	private Carroceria carroceria;
	private int numeroEixos;
	
	public Caminhao(int id, String marca, String modelo, 
			String anoFabricacao, String chassi, Carroceria carroceria) {
		super(id, marca, modelo, anoFabricacao, chassi);

		this.carroceria = carroceria;
		
		if(this.getCarroceria().getCapacidadeCargaQuilos() > CAPACIDADE_DEZ_TONELADAS){
			this.numeroEixos = 4;
			this.setQuantidadeRodas(Veiculo.NUMERO_RODAS_CAMINHAO_GRANDE);
		}else{
			this.numeroEixos = 3;
			this.setQuantidadeRodas(Veiculo.NUMERO_RODAS_CAMINHAO_MEDIO);
		}
		
	}

	public Carroceria getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(Carroceria carroceria) {
		this.carroceria = carroceria;
	}

	public int getNumeroEixos() {
		return numeroEixos;
	}

	public void setNumeroEixos(int numeroEixos) {
		this.numeroEixos = numeroEixos;
	}

}
