package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraColecao;
import model.vo.ColecaoVO;

public class MenuColecao {
	
	Scanner teclado = new Scanner(System.in);

	public void apresentaMenuColecao() {
		System.out.println("\n\nSistema Gerenciador de Coleções \n-------- Menu Coleção --------");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastrar Coleção");
		System.out.println("2 - Consultar Coleção");
		System.out.println("3 - Atualizar Coleção");
		System.out.println("4 - Excluir Coleção");
		System.out.println("5 - Sair");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 5){
			switch(opcao){
				case 1: {
					this.cadastrarColecao();
					break;
				}
				case 2: {
					this.consultarColecao();
					break;
				}
				case 3: {
					this.atualizarColecao();
					break;
				}
				case 4: {
					this.excluirColecao();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("\n\nSistema Gerenciador de Coleções \n-------- Menu Coleção --------");
			System.out.println("\nOpções:");
			System.out.println("1 - Cadastrar Coleção");
			System.out.println("2 - Consultar Coleção");
			System.out.println("3 - Atualizar Coleção");
			System.out.println("4 - Excluir Coleção");
			System.out.println("5 - Sair");
			System.out.print("\nDigite a Opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}
	
	private void cadastrarColecao() {
		ColecaoVO colecaoVO = new ColecaoVO();
		System.out.print("\nDigite o código do Colecionador: ");
		colecaoVO.setIdColecionador(Integer.parseInt(teclado.next()));
		System.out.print("Digite o código do Artefato: ");
		colecaoVO.setIdArtefato(Integer.parseInt(teclado.next()));
				
		ControladoraColecao controladoraColecao = new ControladoraColecao();
		controladoraColecao.cadastrarColecaoController(colecaoVO);
	}
	
	private void consultarColecao() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todas as Coleções");
		System.out.println("2 - Consultar uma Coleção Específica");
		System.out.println("3 - Não consultar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		
		ControladoraColecao controladoraColecao = new ControladoraColecao();
		while(opcao != 3){
			switch(opcao){
				case 1: {
					opcao = 3;
					ArrayList<ColecaoVO> colecaoVO = controladoraColecao.consultarTodasColecoesController();
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s   %-20s   %-30s \n", "ID", "NOME", "CPF");
					for(int i = 0; i < colecaoVO.size(); i++){
						colecaoVO.get(i).imprimir();
					}
					break;
				}
				case 2: {
					opcao = 3;
					ColecaoVO colecaoVO = new ColecaoVO();
					System.out.print("\nInforme o código da Coleção: ");
					colecaoVO.setIdColecao(Integer.parseInt(teclado.next()));
					
					ColecaoVO colecao = controladoraColecao.consultarColecaoController(colecaoVO);
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s   %-20s   %-30s \n", "ID", "NOME", "CPF");
					colecao.imprimir();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
					System.out.println("\nInforme o tipo de consulta a ser realizada");
					System.out.println("1 - Consultar todas as Coleçoes");
					System.out.println("2 - Consultar uma Coleção Específica");
					System.out.println("3 - Não consultar");
					System.out.print("\nDigite a Opção: ");
					opcao = Integer.parseInt(teclado.next());
				}
			}
		}
	}
	
	private void atualizarColecao() {
		ColecaoVO colecaoVO = new ColecaoVO();
		System.out.print("\nDigite o código do Coleção: ");
		colecaoVO.setIdColecao(Integer.parseInt(teclado.next()));
		System.out.print("Digite o código do Colecionador: ");
		colecaoVO.setIdColecionador(Integer.parseInt(teclado.next()));
		System.out.print("Digite o código do Artefato: ");
		colecaoVO.setIdArtefato(Integer.parseInt(teclado.next()));
				
		ControladoraColecao controladoraColecao = new ControladoraColecao();
		controladoraColecao.atualizarColecaoController(colecaoVO);
	}

	private void excluirColecao() {
		ColecaoVO colecaoVO = new ColecaoVO();
		System.out.print("\nInforme o código do Coleção: ");
		colecaoVO.setIdColecao(Integer.parseInt(teclado.next()));
		
		ControladoraColecao controladoraColecao = new ControladoraColecao();
		controladoraColecao.excluirColecaoController(colecaoVO);
	}

}
