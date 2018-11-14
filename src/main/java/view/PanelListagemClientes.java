package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		tblResultados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = tblResultados.getSelectedRow();
				
			}
		});
		tblResultados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "New column", "New column"
			}
		));
		tblResultados.setBounds(30, 187, 353, 183);
		add(tblResultados);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnFechar.setBounds(133, 153, 89, 23);
		add(btnFechar);
	}
}