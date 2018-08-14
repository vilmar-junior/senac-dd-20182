package model.vo.aula05;

public class Moto extends Veiculo {

	public Moto(int id, String marca, String modelo, String ano, String chassi) {
		super(id, marca, modelo, ano, chassi, Veiculo.NUMERO_RODAS_MOTO_PADRAO);
	}
}