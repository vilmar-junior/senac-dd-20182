package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrimeiraTela extends JFrame {

	private static final long serialVersionUID = 2210495344427947010L;

	public static void main(String[] args) {
		
		System.out.println("Alterei e dei commit");
		
		PrimeiraTela tela = new PrimeiraTela();
		tela.setBounds(0, 0, 200, 200);
		
		JLabel lblBoasVindas = new JLabel("Bem-vindo!");
		lblBoasVindas.setVisible(true);
		
		tela.add(lblBoasVindas);
		lblBoasVindas.setLocation(150, 150);
		tela.setVisible(true);
	}

}
