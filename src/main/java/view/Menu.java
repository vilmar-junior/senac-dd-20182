package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

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
		
		int opcao = -1;
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(criarOpcoesMenu()));
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Valor informado deve ser um número inteiro entre 1 e 4");
//			JOptionPane.showMessageDialog(null, 
//					"Valor informado deve ser um número inteiro entre 1 e 4", "Erro", MessageType.ERROR);
		} 

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
					JOptionPane.showMessageDialog(null, "Opção Inválida");
				}
			}
			
		}
		//Selecionou 4 - Sair
		int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
		
		if(resposta == 0) {
			JOptionPane.showMessageDialog(null, "tchau!");
		}else if(resposta == 1) {
			JOptionPane.showInputDialog(criarOpcoesMenu());
		}
	}

	private String criarOpcoesMenu() {
		String mensagem = "Sistema Gerenciador de Coleções";
		mensagem += "\n Opções:";
		mensagem += "\n 1 - Menu Colecionador";
		mensagem += "\n 2 - Menu Artefato";
		mensagem += "\n 3 - Menu Coleção";
		mensagem += "\n 4 - Sair";
		mensagem +="\n Digite a Opção: ";
		
		return mensagem;
	}
}