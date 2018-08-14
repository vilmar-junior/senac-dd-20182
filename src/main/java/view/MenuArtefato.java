package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraArtefato;
import model.vo.ArtefatoVO;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa um menu de CRUD de um artefato.
 * Entrada de dados via console.
 * 
 * @author Adriano de Melo
 * 		   Vilmar César Pereira Júnior (continuação em Desenvolvimento Desktop 2018/2)
 * 
 */
public class MenuArtefato {
	
	Scanner teclado = new Scanner(System.in);
	
	//TODO criar constantes para cada opção do sistema
	
	public void apresentarMenuColecionadorGUI(){
		//TODO implementar com JOptionPane
	}

	public void apresentaMenuArtefato() {
		System.out.println("\n\nSistema Gerenciador de Coleções \n-------- Menu Artefato --------");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastrar Artefato");
		System.out.println("2 - Consultar Artefato");
		System.out.println("3 - Atualizar Artefato");
		System.out.println("4 - Excluir Artefato");
		System.out.println("5 - Sair");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 5){
			switch(opcao){
				case 1: {
					this.cadastrarArtefato();
					break;
				}
				case 2: {
					this.consultarArtefato();
					break;
				}
				case 3: {
					this.atualizarArtefato();
					break;
				}
				case 4: {
					this.excluirArtefato();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("\n\nSistema Gerenciador de Coleções \n-------- Menu Artefato --------");
			System.out.println("\nOpções:");
			System.out.println("1 - Cadastrar Artefato");
			System.out.println("2 - Consultar Artefato");
			System.out.println("3 - Atualizar Artefato");
			System.out.println("4 - Excluir Artefato");
			System.out.println("5 - Sair");
			System.out.print("\nDigite a Opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}
	
	private void cadastrarArtefato() {
		teclado.nextLine();
		ArtefatoVO artefatoVO = new ArtefatoVO();
		System.out.print("\nDigite o nome do Artefato: ");
		artefatoVO.setNome(teclado.nextLine());
		System.out.print("Digite o ano do Artefato: ");
		artefatoVO.setAno(Integer.parseInt(teclado.next()));
		System.out.print("Digite o valor do Artefato: ");
		artefatoVO.setValor(Double.parseDouble(teclado.next()));
				
		ControladoraArtefato controladoraArtefato = new ControladoraArtefato();
		controladoraArtefato.cadastrarArtefatoController(artefatoVO);
	}

	private void consultarArtefato() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todos os Artefatos");
		System.out.println("2 - Consultar um Artefato Específico");
		System.out.println("3 - Não consultar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		
		ControladoraArtefato controladoraArtefato = new ControladoraArtefato();
		while(opcao != 3){
			switch(opcao){
				case 1: {
					opcao = 3;
					ArrayList<ArtefatoVO> artefatoVO = controladoraArtefato.consultarTodosArtefatosController();
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s   %-20s   %-30s \n", "ID", "NOME", "CPF");
					for(int i = 0; i < artefatoVO.size(); i++){
						artefatoVO.get(i).imprimir();
					}
					break;
				}
				case 2: {
					opcao = 3;
					ArtefatoVO artefatoVO = new ArtefatoVO();
					System.out.print("\nInforme o código do Artefato: ");
					artefatoVO.setIdArtefato(Integer.parseInt(teclado.next()));
					
					ArtefatoVO artefato = controladoraArtefato.consultarArtefatoController(artefatoVO);
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s   %-20s   %-30s \n", "ID", "NOME", "CPF");
					artefato.imprimir();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
					System.out.println("\nInforme o tipo de consulta a ser realizada");
					System.out.println("1 - Consultar todos os Artefatos");
					System.out.println("2 - Consultar um Artefato Específico");
					System.out.println("3 - Não consultar");
					System.out.print("\nDigite a Opção: ");
					opcao = Integer.parseInt(teclado.next());
				}
			}
		}
	}

	private void atualizarArtefato() {
		ArtefatoVO artefatoVO = new ArtefatoVO();
		System.out.print("\nInforme o código do Artefato: ");
		artefatoVO.setIdArtefato(Integer.parseInt(teclado.next()));
		teclado.nextLine();
		System.out.print("Digite o nome do Artefato: ");
		artefatoVO.setNome(teclado.nextLine());
		System.out.print("Digite o ano do Artefato: ");
		artefatoVO.setAno(Integer.parseInt(teclado.next()));
		System.out.print("Digite o valor do Artefato: ");
		artefatoVO.setValor(Double.parseDouble(teclado.next()));
		
		ControladoraArtefato controladoraArtefato = new ControladoraArtefato();
		controladoraArtefato.atualizarArtefatoController(artefatoVO);
	}

	private void excluirArtefato() {
		ArtefatoVO artefatoVO = new ArtefatoVO();
		System.out.print("\nInforme o código do Artefato: ");
		artefatoVO.setIdArtefato(Integer.parseInt(teclado.next()));
		
		ControladoraArtefato controladoraArtefato = new ControladoraArtefato();
		controladoraArtefato.excluirArtefatoController(artefatoVO);
	}
}