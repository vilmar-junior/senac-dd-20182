package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelListagemClientes extends JPanel {
	private JTextField txtNome;
	private JTable tblResultados;

	/**
	 * Create the panel.
	 */
	public PanelListagemClientes() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(30, 32, 46, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(74, 29, 86, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(172, 28, 89, 23);
		add(btnFiltrar);
		
		tblResultados = new JTable();
		tblResultados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "New column", "New column"
			}
		));
		tblResultados.setBounds(30, 276, 353, -183);
		add(tblResultados);

	}
}
