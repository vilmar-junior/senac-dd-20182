package executavel;

import java.sql.SQLException;

import view.Menu;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa a classe principal de uma aplicação.
 * 
 * @author Adriano de Melo
 * 
 */
public class Executavel {

	public static void main(String[] args) throws SQLException {
		Menu menu = new Menu();
		menu.apresentarMenu();
	}
}