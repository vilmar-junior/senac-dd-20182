package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.FuncionarioController;
import model.vo.aula05.Funcionario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtMatricula;
	private JLabel lblMensagemRetorno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroFuncionario() {
		setTitle("Novo Funcionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblCpf = new JLabel("CPF");
		
		JLabel lblMatricula = new JLabel("Matrícula");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Construir um funcionario novo com os dados da tela
				Funcionario novoFuncionario = new Funcionario();
				novoFuncionario.setNome(txtNome.getText());
				novoFuncionario.setNumeroMatricula(txtMatricula.getText());
				novoFuncionario.setCpf(txtCPF.getText());
				
				//Chamar o controlador
				FuncionarioController controlador = new FuncionarioController();
				String mensagem = controlador.salvar(novoFuncionario);
				
				//Mostrar a mensagem de retorno na tela
				lblMensagemRetorno.setText(mensagem);
				
				limparTela();
			}
		});
		
		lblMensagemRetorno = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMatricula, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblCpf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMatricula, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addComponent(txtCPF, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
								.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
						.addComponent(lblMensagemRetorno, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCpf)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatricula))
					.addGap(18)
					.addComponent(btnSalvar)
					.addGap(18)
					.addComponent(lblMensagemRetorno)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void limparTela() {
		txtCPF.setText("");
		txtMatricula.setText("");
		txtNome.setText("");
	}
}
