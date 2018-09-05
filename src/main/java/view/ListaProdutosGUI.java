package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import controller.ProdutoController;
import model.vo.aula05.Produto;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class ListaProdutosGUI extends JFrame {

	private JPanel contentPane;
	private JTable tblProdutos;
	private String[] nomesColunas = new String[] {"Nome", 
			"Fabricante", "Valor", "Peso"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaProdutosGUI frame = new ListaProdutosGUI();
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
	public ListaProdutosGUI() {
		setTitle("Consulta de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tblProdutos = new JTable();
		tblProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			nomesColunas
		));
		tblProdutos.setBounds(10, 105, 414, 145);
		contentPane.add(tblProdutos);

		JButton btnConsultar = new JButton("Consultar");
		
		btnConsultar.setBounds(143, 71, 127, 23);
		contentPane.add(btnConsultar);
		
		final JComboBox cbFiltroPreco = new JComboBox();
		cbFiltroPreco.setBounds(51, 37, 93, 20);
		contentPane.add(cbFiltroPreco);
		
		JLabel lblFiltroPreco = new JLabel("Preço");
		lblFiltroPreco.setBounds(10, 40, 46, 14);
		contentPane.add(lblFiltroPreco);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 56, 404, -1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 62, 414, 14);
		contentPane.add(separator_1);
		
		JLabel lblFiltrosDeConsulta = new JLabel("Filtros de consulta:");
		lblFiltrosDeConsulta.setBounds(154, 11, 119, 14);
		contentPane.add(lblFiltrosDeConsulta);
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				
				boolean temFiltroPreenchido = false;
				double precoMaximo = 0.0;
				if(cbFiltroPreco.getSelectedIndex() > -1) {
					temFiltroPreenchido = true;
					
					if(cbFiltroPreco.getSelectedItem().equals(CadastroProdutoGUI.NOME_VALOR_BARATO)) {
						precoMaximo = CadastroProdutoGUI.PRECO_MAXIMO_VALOR_BARATO;
					}
				}
				
				//TODO Fazer para os demais filtros da tela
				
				if(temFiltroPreenchido) {
					//TODO chamar a consulta COM filtro
					//List<Produto> produtos = controlador.listarAtePreco(precoMaximo);
				}else {
					List<Produto> produtos = controlador.listarTodosProdutos();
					//Atualizar a tabela
					atualizarTabelaProdutos(produtos);
				}

			}
		});
	}

	protected void atualizarTabelaProdutos(List<Produto> produtos) {
		//Limpa a tabela
		tblProdutos.setModel(new DefaultTableModel(
				new Object[][] {},
				nomesColunas));
		
		DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
		
		for(Produto produto: produtos) {
			//Crio uma nova linha na tabela
			//Preencher a linha com os atributos do produto
			//na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] {
					produto.getNome(),
					produto.getFabricante(),
					produto.getValor(),
					produto.getPeso()
			};
			modelo.addRow(novaLinha);
		}

	}
}
