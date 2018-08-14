package view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa um menu de uma aplicação.
 * Inicialmente com entrada de dados via console e em seguida com GUI Java Swing.
 * 
 * @author Adriano de Melo
 * 		   Vilmar César Pereira Júnior (continuação em Desenvolvimento Desktop 2018/2)
 * 
 */
public class Menu {

	/**
	 * Constantes com as opções de menu (ver método <b>criarOpcoesMenu()</b>).
	 */
	private static final int OPCAO_MENU_COLECIONADOR = 0;
	private static final int OPCAO_MENU_ARTEFATO = 2;
	private static final int OPCAO_MENU_COLECAO = 3;
	private static final int OPCAO_MENU_SAIR = 4;

	/**
	 * Método alterado, agora apresenta um menu com JOptionPane
	 * @throws SQLException 
	 * 
	 * */
	public void apresentarMenu() throws SQLException {

		int opcao = -1;
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(criarOpcoesMenu()));
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, 
					"Valor informado deve ser um número inteiro entre 1 e 4", "Erro", JOptionPane.ERROR_MESSAGE);
		} 

		while (opcao != OPCAO_MENU_SAIR){
			switch(opcao){
			case OPCAO_MENU_COLECIONADOR: {
				MenuColecionador menuColecionador = new MenuColecionador();
				menuColecionador.apresentaMenuColecionador();
				break;
			}
			case OPCAO_MENU_ARTEFATO: {
				MenuArtefato menuArtefato = new MenuArtefato();
				menuArtefato.apresentaMenuArtefato();
				break;
			}
			case OPCAO_MENU_COLECAO: {
				MenuColecao menuColecao = new MenuColecao();
				menuColecao.apresentaMenuColecao();
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opção Inválida", "Atenção", JOptionPane.WARNING_MESSAGE);
			}
			}

		}
		int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");

		if(resposta == 0) {
			JOptionPane.showMessageDialog(null, "tchau!");
		}else if(resposta == 1) {
			JOptionPane.showInputDialog(criarOpcoesMenu());
		}
	}

	/**
	 * Método privado que monta o menu principal da aplicação.
	 * 
	 * @return mensagem uma String com as opções do menu concatenadas e separadas
	 * 		   por uma quebra de linha ("\n").
	 * 		   
	 * Cada opção de menu deve possuir um valor inteiro que representa seu identificador. 
	 * Estes identificadores devem ser armanezados em constantes desta classe 
	 */
	private String criarOpcoesMenu() {
		String mensagem = "Sistema Gerenciador de Coleções";
		mensagem += "\n Opções:";
		mensagem += "\n" + OPCAO_MENU_COLECIONADOR + " - Menu Colecionador";
		mensagem += "\n"+ OPCAO_MENU_ARTEFATO + " - Menu Artefato";
		mensagem += "\n"+ OPCAO_MENU_COLECAO + " - Menu Coleção";
		mensagem += "\n"+ OPCAO_MENU_SAIR + " - Sair";
		mensagem +="\n Digite a Opção: ";

		return mensagem;
	}
}