package view;

import java.util.Scanner;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa um menu de uma aplicação.
 * Inicialmente com entrada de dados via console e em seguida com GUI Java Swing.
 * 
 * @author Adriano de Melo
 * 
 */
public class Menu {

	Scanner teclado = new Scanner(System.in);

	public void apresentarMenu() {
		System.out.println("Sistema Gerenciador de Coleções");
		System.out.println("\nOpções:");
		System.out.println("1 - Menu Colecionador");
		System.out.println("2 - Menu Artefato");
		System.out.println("3 - Menu Coleção");
		System.out.println("4 - Sair");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 4){
			switch(opcao){
			case 1: {
				MenuColecionador menuColecionador = new MenuColecionador();
				menuColecionador.apresentaMenuColecionador();
				break;
			}
			case 2: {
				MenuArtefato menuArtefato = new MenuArtefato();
				menuArtefato.apresentaMenuArtefato();
				break;
			}
			case 3: {
				MenuColecao menuColecao = new MenuColecao();
				menuColecao.apresentaMenuColecao();
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
			}
			}
			System.out.println("Sistema Gerenciador de Coleções");
			System.out.println("\nOpções:");
			System.out.println("1 - Menu Colecionador");
			System.out.println("2 - Menu Artefato");
			System.out.println("3 - Menu Coleção");
			System.out.println("4 - Sair");
			System.out.print("\nDigite a Opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}
}
