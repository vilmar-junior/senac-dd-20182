package view;

import java.awt.EventQueue;
import java.awt.RenderingHints.Key;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ProdutoController;
import model.bo.ProdutoBO;
import model.vo.aula05.Produto;

import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroProdutoGUI {

	protected static final String NOME_VALOR_BARATO = "Barato";
	protected static final String NOME_VALOR_MEDIO = "Médio";
	protected static final String NOME_VALOR_CARO = "Caro";
	
	protected static final double PRECO_MAXIMO_VALOR_BARATO = 9.99;
	protected static final double PRECO_MAXIMO_VALOR_MEDIO = 99.9;
	protected static final double PRECO_MAXIMO_VALOR_CARO = 999999999;

	private ProdutoBO bo = new ProdutoBO();
	private Produto produto = new Produto();
	private JFrame frmNovoProduto;
	private JTextField txtNome;
	private JTextField txtFabricante;
	private JTextField txtPeso;
	private JComboBox cbValor;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutoGUI window = new CadastroProdutoGUI();
					window.frmNovoProduto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroProdutoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovoProduto = new JFrame();
		frmNovoProduto.setTitle("Novo produto");
		frmNovoProduto.setBounds(100, 100, 350, 279);
		frmNovoProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNovoProduto.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 47, 71, 14);
		frmNovoProduto.getContentPane().add(lblNome);

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(10, 72, 71, 14);
		frmNovoProduto.getContentPane().add(lblFabricante);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 97, 71, 14);
		frmNovoProduto.getContentPane().add(lblValor);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 122, 71, 14);
		frmNovoProduto.getContentPane().add(lblPeso);

		txtNome = new JTextField();
		txtNome.setBounds(75, 44, 249, 20);
		frmNovoProduto.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		txtFabricante = new JTextField();
		txtFabricante.setBounds(75, 69, 249, 20);
		frmNovoProduto.getContentPane().add(txtFabricante);
		txtFabricante.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setBounds(75, 119, 249, 20);
		frmNovoProduto.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		String[] cores = {"---Selecione---", NOME_VALOR_BARATO, NOME_VALOR_MEDIO, NOME_VALOR_CARO};
		cbValor = new JComboBox(cores);
		cbValor.setBounds(75, 94, 249, 20);
		frmNovoProduto.getContentPane().add(cbValor);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				Produto produto = construirProduto();

				String mensagem = controlador.salvar(produto);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			}

		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(10, 183, 314, 46);
		frmNovoProduto.getContentPane().add(btnSalvar);
		
		JLabel lblId = new JLabel("ID??:");
		lblId.setBounds(10, 11, 46, 14);
		frmNovoProduto.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(75, 8, 146, 20);
		frmNovoProduto.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				produto = bo.buscarProdutoPorId(txtId.getText());
				
				if(produto != null) {
					//Preencher os campos da tela
					txtNome.setText(produto.getNome());
					txtFabricante.setText(produto.getFabricante());
					txtPeso.setText(produto.getPeso() + "");
					if(produto.getValor() < 10) {
						cbValor.setSelectedItem(NOME_VALOR_BARATO);
					}else if(produto.getValor() < 100) {
						cbValor.setSelectedItem(NOME_VALOR_MEDIO);
					}else {
						cbValor.setSelectedItem(NOME_VALOR_CARO);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
				}
			}
		});
		btnBuscar.setBounds(223, 7, 101, 23);
		frmNovoProduto.getContentPane().add(btnBuscar);
	}

	protected void limparTela() {
		produto = new Produto();
		txtId.setText("");
		txtNome.setText("");
		txtFabricante.setText("");
		txtPeso.setText("");
		cbValor.setSelectedIndex(0);
	}

	public Produto construirProduto() {
		produto.setNome(txtNome.getText());
		produto.setFabricante(txtFabricante.getText());
		String strPeso = txtPeso.getText();

		if(strPeso.trim() != "") {
			produto.setPeso(Double.parseDouble(strPeso));
		}

		switch (cbValor.getSelectedItem().toString()) {
			case NOME_VALOR_BARATO:
				produto.setValor(1.0);
				break;
			case NOME_VALOR_MEDIO:
				produto.setValor(10.0);
				break;
			case NOME_VALOR_CARO:
				produto.setValor(100.0);
				break;

		default:
			produto.setValor(1.0);
			break;
		}
		return produto;
	}
}