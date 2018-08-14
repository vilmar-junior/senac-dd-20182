package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.vo.aula05.Caminhao;
import model.vo.aula05.Carro;

public class MenuExercicio04 {

	private static final int OPCAO_CADASTRAR_CARRO = 1;
	private static final int OPCAO_CADASTRAR_CAMINHAO = 2;
	private static final int OPCAO_CADASTRAR_MOTO = 3;
	private static final int OPCAO_LISTAR_CARRO_OU_CAMINHAO = 4;
	private static final int OPCAO_LISTAR_MOTOS = 5;
	private static final int OPCAO_SAIR = 6;

	private static List<Carro> carros = new ArrayList<Carro>();

	public void apresentarMenu(){
		try{
			int opcaoMenu = -1;
			
			while(opcaoMenu != OPCAO_SAIR){
				String mensagemMenu = construirMenu();
				String opcao = JOptionPane.showInputDialog(null, mensagemMenu, "Título", JOptionPane.INFORMATION_MESSAGE);
				opcaoMenu = Integer.parseInt(opcao);
				
				switch (opcaoMenu) {
				case OPCAO_CADASTRAR_CARRO:
					cadastrarCarro();
					apresentarMenu();
					break;
				case OPCAO_CADASTRAR_CAMINHAO:
					cadastrarCaminhao();
					apresentarMenu();
					break;
				case OPCAO_CADASTRAR_MOTO:
					cadastrarMoto();
					apresentarMenu();
					break;	
				case OPCAO_LISTAR_CARRO_OU_CAMINHAO:
					mostrarCarroOuCaminhao();
					apresentarMenu();
					break;
				case OPCAO_LISTAR_MOTOS:
					mostrarMotos();
					apresentarMenu();
					break;
				default:
					mostrarMensagemOpcaoInvalida();
					apresentarMenu();
					break;
				}
			}
			mostrarMensagemSaida();
		}catch(NumberFormatException ex){
			//TODO tratar
		}
	}

	private void mostrarMensagemOpcaoInvalida() {
		// TODO Auto-generated method stub
		
	}

	private void mostrarMensagemSaida() {
		// TODO Auto-generated method stub

	}

	private void mostrarMotos() {
		// TODO Auto-generated method stub

	}

	private void mostrarCarroOuCaminhao() {
		String chassiInformado = JOptionPane.showInputDialog("Informe o chassi");
		
		Carro carro = obterCarroPorChassi(chassiInformado);
		Caminhao caminhao = obterCaminhaoPorChassi(chassiInformado);
		
		String mensagem = "";
		
		if(carro != null){
			mensagem = carro.toString();
		}else if (caminhao != null){
			mensagem = caminhao.toString();
		}else{
			mensagem = "Veículo não encontrado";
		}
		
		JOptionPane.showMessageDialog(null, mensagem);
	}

	private Caminhao obterCaminhaoPorChassi(String chassiInformado) {
		// TODO Auto-generated method stub
		return null;
	}

	private Carro obterCarroPorChassi(String chassiInformado) {
		
		Carro carroComChassiBuscado = null;
		for(Carro c: carros){
			if(c.getChassi().equals(chassiInformado)){
				carroComChassiBuscado = c;
				break;
			}
		}
		
		return carroComChassiBuscado;
	}

	private void cadastrarMoto() {
		// TODO Auto-generated method stub

	}

	private void cadastrarCaminhao() {
		// TODO Auto-generated method stub

	}

	private void cadastrarCarro(){
		int id = -1;
		try{
			id = Integer.parseInt(JOptionPane.showInputDialog("Informe o identificador:"));
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Chassi deve ser um número inteiro",
					"Atenção", JOptionPane.ERROR_MESSAGE, null);
		}
		String modelo = JOptionPane.showInputDialog("Informe o modelo:");
		String chassi = JOptionPane.showInputDialog("Informe o chassi:");
		String anoFabricacao = JOptionPane.showInputDialog("Informe o ano:");
		String marca = JOptionPane.showInputDialog("Informe o marca:");

		if(id == -1 || modelo == null || chassi == null
				|| anoFabricacao == null || marca == null){
			//Cancelar no JOptionPane retorna uma string nula
			apresentarMenu();
		}else{
			Carro novoCarro = new Carro(id, marca, modelo, anoFabricacao, chassi);

			if(listaCarrosNaoContem(id)){
				carros.add(novoCarro);
			}else{
				JOptionPane.showMessageDialog(null, "Carro já cadastrado",
						"Atenção", JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}

	private boolean listaCarrosNaoContem(int idNovoCarro) {
		boolean naoContem = true;

		for(Carro c: carros){
			if(c.getId() == idNovoCarro){
				naoContem = false;
				break;
			}
		}

		return naoContem;
	}

	private String construirMenu() {
		String mensagem = "Exercício 4";
		mensagem += "\n Opções:";
		mensagem += "\n 1 - Cadastrar carro";
		mensagem += "\n 2 - Cadastrar moto";
		mensagem += "\n 3 - Cadastrar caminhão";
		mensagem += "\n 4 - Exibir caminhão e carro por chassi";
		mensagem += "\n 5 - Exibir todas as motos";
		mensagem += "\n 6 - Sair";
		mensagem +="\n Digite a Opção: ";

		return mensagem;
	}
}
