package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoController;
import model.vo.aula05.Produto;

public class ListaProdutosGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable tblProdutos;
	
	//Esta lista de produtos é atualizada a cada nova consulta realizada com os filtros.
	//Será a lista usada para gerar os relatórios
	private List<Produto> produtosConsultados;
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
		setBounds(100, 100, 480, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnConsultar = new JButton("Consultar");
		
		btnConsultar.setBounds(169, 71, 127, 23);
		contentPane.add(btnConsultar);
		
		String[] precos = {"---Selecione---", CadastroProdutoGUI.NOME_VALOR_BARATO, CadastroProdutoGUI.NOME_VALOR_MEDIO, CadastroProdutoGUI.NOME_VALOR_CARO};
		final JComboBox cbFiltroPreco = new JComboBox(precos);
		cbFiltroPreco.setBounds(66, 37, 166, 20);
		contentPane.add(cbFiltroPreco);
		
		JLabel lblFiltroPreco = new JLabel("Preço:");
		lblFiltroPreco.setBounds(10, 40, 46, 14);
		contentPane.add(lblFiltroPreco);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 56, 404, -1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 62, 448, 14);
		contentPane.add(separator_1);
		
		JLabel lblFiltrosDeConsulta = new JLabel("Filtros de consulta:");
		lblFiltrosDeConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltrosDeConsulta.setBounds(10, 11, 448, 14);
		contentPane.add(lblFiltrosDeConsulta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 194, 345, -100);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(30, 225, 246, -119);
		contentPane.add(table);
		
		tblProdutos = new JTable();
		tblProdutos.setModel(new DefaultTableModel(
			new String[][] {
				{"Nome", "Marca", "Peso", "Valor"},
			},
			new String[] {
				"Nome", "Marca", "Peso", "Valor"
			}
		));
		tblProdutos.setBounds(10, 105, 462, 174);
		contentPane.add(tblProdutos);
		
		JLabel lblFiltroMarca = new JLabel("Marca:");
		lblFiltroMarca.setBounds(244, 40, 46, 14);
		contentPane.add(lblFiltroMarca);
		
		//TODO preencher com marcas cadastradas no BD
		JComboBox cbFiltroMarca = new JComboBox();
		cbFiltroMarca.setBounds(300, 37, 172, 20);
		
		contentPane.add(cbFiltroMarca);
		
		JButton btnGerarXls = new JButton("Gerar XLS");
		btnGerarXls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Salvar relatório como...");
				
				int resultado = jfc.showSaveDialog(null);
				if(resultado == JFileChooser.APPROVE_OPTION){
					String caminhoEscolhido = jfc.getSelectedFile().getAbsolutePath();
					
					ProdutoController produtoController = new ProdutoController();
					produtoController.gerarRelatorio(produtosConsultados, caminhoEscolhido, ProdutoController.TIPO_RELATORIO_XLS);
				}
			}
		});
		btnGerarXls.setBounds(100, 291, 117, 29);
		contentPane.add(btnGerarXls);
		
		JButton btnGerarPdf = new JButton("Gerar PDF");
		btnGerarPdf.setBounds(248, 291, 117, 29);
		contentPane.add(btnGerarPdf);
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				
				boolean temFiltroPreenchido = false;
				double precoMaximo = 0.0;
				if(cbFiltroPreco.getSelectedIndex() > 0) {
					temFiltroPreenchido = true;
					
					if(cbFiltroPreco.getSelectedItem().equals(CadastroProdutoGUI.NOME_VALOR_BARATO)) {
						precoMaximo = CadastroProdutoGUI.PRECO_MAXIMO_VALOR_BARATO;
					}
					
					//TODO implementar as demais faixas de preço
					
				}
				
				//TODO Fazer para os demais filtros da tela
				
				if(temFiltroPreenchido) {
					//TODO chamar a consulta COM filtro
					//List<Produto> produtos = controlador.listarAtePreco(precoMaximo);
					List<Produto> produtos = controlador.listarProdutosAtePreco(precoMaximo);
					atualizarTabelaProdutos(produtos);
				}else {
					List<Produto> produtos = controlador.listarTodosProdutos();
					//Atualizar a tabela
					atualizarTabelaProdutos(produtos);
				}

			}
		});
	}

	protected void atualizarTabelaProdutos(List<Produto> produtos) {
		//atualiza o atributo produtosConsultados
		produtosConsultados = produtos;
		
		//Limpa a tabela
		tblProdutos.setModel(new DefaultTableModel(
				new String[][] {
					{"Nome", "Marca", "Peso", "Valor"},
				},
				new String[] {
					"Nome", "Marca", "Peso", "Valor"
				}));
		
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
