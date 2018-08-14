package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraColecionador;
import model.vo.ColecionadorVO;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa um menu de CRUD do colecionador.
 * Entrada de dados via console.
 * 
 * @author Adriano de Melo
 * 		   Vilmar César Pereira Júnior (continuação em Desenvolvimento Desktop 2018/2)
 * 
 */
public class MenuColecionador {
	
	private Scanner teclado = new Scanner(System.in);
	
	//TODO criar constantes para cada opção do sistema
	
	public void apresentarMenuColecionadorGUI(){
		//TODO implementar com JOptionPane
	}

	public void apresentaMenuColecionador() throws SQLException {
		System.out.println("\n\nSistema Gerenciador de Coleções \n-------- Menu Colecionador --------");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastrar Colecionador");
		System.out.println("2 - Consultar Colecionador");
		System.out.println("3 - Atualizar Colecionador");
		System.out.println("4 - Excluir Colecionador");
		System.out.println("5 - Sair");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 5){
			switch(opcao){
				case 1: {
					this.cadastrarColecionador();
					break;
				}
				case 2: {
					this.consultarColecionador();
					break;
				}
				case 3: {
					this.atualizarColecionador();
					break;
				}
				case 4: {
					this.excluirColecionador();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("\n\nSistema Gerenciador de Coleções \n-------- Menu Colecionador --------");
			System.out.println("\nOpções:");
			System.out.println("1 - Cadastrar Colecionador");
			System.out.println("2 - Consultar Colecionador");
			System.out.println("3 - Atualizar Colecionador");
			System.out.println("4 - Excluir Colecionador");
			System.out.println("5 - Sair");
			System.out.print("\nDigite a Opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}
	
	private void cadastrarColecionador() throws SQLException {
		teclado.nextLine();
		ColecionadorVO colecionadorVO = new ColecionadorVO();
		System.out.print("\nDigite o nome do Colecionador: ");
		colecionadorVO.setNome(teclado.nextLine());
		System.out.print("Digite o CPF do Colecionador: ");
		colecionadorVO.setCpf(teclado.next());
		System.out.print("Digite o telefone do Colecionador: ");
		colecionadorVO.setTelefone(teclado.next());
		System.out.print("Digite o e-mail do Colecionador: ");
		colecionadorVO.setEmail(teclado.next());
		
		ControladoraColecionador controladoraColecionador = new ControladoraColecionador();
		controladoraColecionador.cadastrarColecionadorController(colecionadorVO);
	}

	private void consultarColecionador() throws SQLException {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todos os Colecionadores");
		System.out.println("2 - Consultar um Colecionador Específico");
		System.out.println("3 - Não consultar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		
		ControladoraColecionador controladoraColecionador = new ControladoraColecionador();
		while(opcao != 3){
			switch(opcao){
				case 1: {
					opcao = 3;
					ArrayList<ColecionadorVO> colecionadorVO = controladoraColecionador.consultarTodosColecionadoresController();
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s   %-20s   %-15s   %-12s   %-20s \n", "ID", "NOME", "CPF", "TELEFONE" , "E-MAIL");
					for(int i = 0; i < colecionadorVO.size(); i++){
						colecionadorVO.get(i).imprimir();
					}
					break;
				}
				case 2: {
					opcao = 3;
					ColecionadorVO colecionadorVO = new ColecionadorVO();
					System.out.print("\nInforme o código do Colecionador: ");
					colecionadorVO.setIdColecionador(Integer.parseInt(teclado.next()));
					
					ColecionadorVO colecionador = controladoraColecionador.consultarColecionadorController(colecionadorVO);
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s   %-20s   %-15s   %-12s   %-20s \n", "ID", "NOME", "CPF", "TELEFONE" , "E-MAIL");
					colecionador.imprimir();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
					System.out.println("\nInforme o tipo de consulta a ser realizada");
					System.out.println("1 - Consultar todos os Colecionadores");
					System.out.println("2 - Consultar um Colecionador Específico");
					System.out.println("3 - Não consultar");
					System.out.print("\nDigite a Opção: ");
					opcao = Integer.parseInt(teclado.next());
				}
			}
		}
	}

	private void atualizarColecionador() throws SQLException {
		ColecionadorVO colecionadorVO = new ColecionadorVO();
		System.out.print("\nInforme o código do Colecionador: ");
		colecionadorVO.setIdColecionador(Integer.parseInt(teclado.next()));
		teclado.nextLine();
		System.out.print("Digite o nome do Colecionador: ");
		colecionadorVO.setNome(teclado.nextLine());
		System.out.print("Digite o CPF do Colecionador: ");
		colecionadorVO.setCpf(teclado.next());
		System.out.print("Digite o telefone do Colecionador: ");
		colecionadorVO.setTelefone(teclado.next());
		System.out.print("Digite o e-mail do Colecionador: ");
		colecionadorVO.setEmail(teclado.next());
		
		ControladoraColecionador controladoraColecionador = new ControladoraColecionador();
		controladoraColecionador.atualizarColecionadorController(colecionadorVO);
	}

	private void excluirColecionador() throws SQLException {
		ColecionadorVO colecionadorVO = new ColecionadorVO();
		System.out.print("\nInforme o código do Colecionador: ");
		colecionadorVO.setIdColecionador(Integer.parseInt(teclado.next()));
		
		ControladoraColecionador controladoraColecionador = new ControladoraColecionador();
		controladoraColecionador.excluirColecionadorController(colecionadorVO);
	}
	
}
