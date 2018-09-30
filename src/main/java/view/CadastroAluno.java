package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.AlunoController;
import model.vo.Aluno;

public class CadastroAluno {

	//Constantes para o combo de nível
	//Colocar no construtor do combobox
	private static final String OPCAO_SELECIONE = "-- Selecione --";
	private static final String OPCAO_BASICO = "Básico";
	private static final String OPCAO_INTERMEDIARIO = "Intermediário";
	private static final String OPCAO_AVANCADO = "Avançado";
	
	
	private JFrame frmCursoCaminhoSuave;
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JTextField txtSobrenome;
	private JTextField txtP1;
	private JTextField txtP2;
	private JTextField txtT1;
	private JTextField txtT2;
	private JTextField txtPesoProvas;
	private JTextField txtPesoTrabalhos;
	private JComboBox cbNivel;
	private JLabel lblSituacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno window = new CadastroAluno();
					window.frmCursoCaminhoSuave.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCursoCaminhoSuave = new JFrame();
		frmCursoCaminhoSuave.setTitle("Curso Caminho Suave - Cadastro de Notas");
		frmCursoCaminhoSuave.setBounds(100, 100, 450, 330);
		frmCursoCaminhoSuave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCursoCaminhoSuave.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(30, 37, 61, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblNome);

		JLabel lblMatrcula = new JLabel("Matrícula:");
		lblMatrcula.setBounds(6, 76, 85, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblMatrcula);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(216, 37, 85, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblSobrenome);

		JLabel lblNvel = new JLabel("Nível:");
		lblNvel.setBounds(226, 76, 75, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblNvel);

		txtNome = new JTextField();
		txtNome.setBounds(74, 32, 130, 26);
		frmCursoCaminhoSuave.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(74, 71, 130, 26);
		frmCursoCaminhoSuave.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(299, 32, 130, 26);
		frmCursoCaminhoSuave.getContentPane().add(txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblNp = new JLabel("NP1:");
		lblNp.setBounds(6, 147, 61, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblNp);

		JLabel lblNp_1 = new JLabel("NP2:");
		lblNp_1.setBounds(6, 175, 61, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblNp_1);

		JLabel lblPesoProvas = new JLabel("Peso Provas:");
		lblPesoProvas.setBounds(6, 203, 85, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblPesoProvas);

		JLabel lblT = new JLabel("T1:");
		lblT.setBounds(240, 147, 61, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblT);

		JLabel lblT_1 = new JLabel("T2:");
		lblT_1.setBounds(240, 175, 61, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblT_1);

		JLabel lblPesoTrabalhos = new JLabel("Peso Trabalhos:");
		lblPesoTrabalhos.setBounds(216, 203, 99, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblPesoTrabalhos);

		txtP1 = new JTextField();
		txtP1.setBounds(105, 142, 99, 26);
		frmCursoCaminhoSuave.getContentPane().add(txtP1);
		txtP1.setColumns(10);

		txtP2 = new JTextField();
		txtP2.setBounds(105, 170, 99, 26);
		frmCursoCaminhoSuave.getContentPane().add(txtP2);
		txtP2.setColumns(10);

		txtT1 = new JTextField();
		txtT1.setBounds(330, 142, 99, 26);
		frmCursoCaminhoSuave.getContentPane().add(txtT1);
		txtT1.setColumns(10);

		txtT2 = new JTextField();
		txtT2.setBounds(330, 170, 99, 26);
		frmCursoCaminhoSuave.getContentPane().add(txtT2);
		txtT2.setColumns(10);

		txtPesoProvas = new JTextField();
		txtPesoProvas.setBounds(104, 198, 99, 26);
		frmCursoCaminhoSuave.getContentPane().add(txtPesoProvas);
		txtPesoProvas.setColumns(10);

		txtPesoTrabalhos = new JTextField();
		txtPesoTrabalhos.setBounds(330, 198, 99, 26);
		frmCursoCaminhoSuave.getContentPane().add(txtPesoTrabalhos);
		txtPesoTrabalhos.setColumns(10);

		lblSituacao = new JLabel("Situação:");
		lblSituacao.setBounds(6, 241, 198, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblSituacao);

		final JLabel lblMediaFinal = new JLabel("Média Final:");
		lblMediaFinal.setBounds(216, 241, 99, 16);
		frmCursoCaminhoSuave.getContentPane().add(lblMediaFinal);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Validar os dados da tela (vou criar um método separado de validação dos campos)
				String mensagemValidacao = validarPreenchimentoCampos();

				//Caso tenha erros, mostrar uma mensagem com JOptionPane
				if(!mensagemValidacao.equals("")){
					//Caso a mensagem não esteja vazia
					JOptionPane.showMessageDialog(null, mensagemValidacao, "Atenção", JOptionPane.ERROR_MESSAGE);
				}else{
					//Caso contrário (mensagem está vazia -> sem erros na tela)
					AlunoController controlador = new AlunoController();

					//Construir um aluno com os campos da tela (mais um método que vamos implementar)
					Aluno novoAluno = construirAlunoDaTela();

					//Salvar e obter a situação
					String situacao = controlador.salvar(novoAluno);
					lblSituacao.setText("Situação: " + situacao);
					
					//Atualizar a média final na tela
					double mediaFinal = controlador.obterMediaFinal(novoAluno);
					lblMediaFinal.setText("Média final: " + mediaFinal);
					
					//Ainda temos que alterar a cor do campo situação de acordo com a nota
					atualizarCorSituacao(mediaFinal);
					
					//Para fechar, vamos atualizar o aluno no banco (situacao e média final)
					novoAluno.setNotaFinal(mediaFinal);
					novoAluno.setSituacao(situacao);
					
					//Temos que criar este método, encadeando em todo o MVC
					controlador.atualizarAluno(novoAluno);
				}
			}
		});
		btnSalvar.setBounds(87, 273, 117, 29);
		frmCursoCaminhoSuave.getContentPane().add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtSobrenome.setText("");
				txtMatricula.setText("");
				txtP1.setText("");
				txtP2.setText("");
				txtT1.setText("");
				txtT2.setText("");
				txtPesoProvas.setText("");
				txtPesoTrabalhos.setText("");
				lblSituacao.setText("Situação");
				lblSituacao.setForeground(Color.BLACK);
				lblMediaFinal.setText("Média Final:");
				
				//Limpeza do combo é diferente
				cbNivel.setSelectedIndex(0);//primeiro item (SELECIONE)
				
				//Concluímos a prova
				
				
			}
		});
		btnLimpar.setBounds(226, 273, 117, 29);
		frmCursoCaminhoSuave.getContentPane().add(btnLimpar);

		cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(new String[] {OPCAO_SELECIONE, OPCAO_BASICO, OPCAO_INTERMEDIARIO, OPCAO_AVANCADO}));
		cbNivel.setBounds(299, 72, 130, 27);
		frmCursoCaminhoSuave.getContentPane().add(cbNivel);
	}

	protected void atualizarCorSituacao(double mediaFinal) {
		//Implementar a regra das cores... (como é uma regra de TELA, fica aqui)
		if(mediaFinal >= 7){
			lblSituacao.setForeground(Color.GREEN);
		}else if(mediaFinal >= 4.5){
			lblSituacao.setForeground(Color.YELLOW);
		}else{
			lblSituacao.setForeground(Color.RED);
		}
	}

	protected Aluno construirAlunoDaTela() {
		Aluno novo = new Aluno();
		novo.setNome(txtNome.getText());
		novo.setSobrenome(txtSobrenome.getText());
		novo.setMatricula(txtMatricula.getText());
		
		//Vamos considerar que a validação já foi feita -> chamar o parser direto
		novo.setNotaProva1(Double.parseDouble(txtP1.getText()));
		novo.setNotaProva2(Double.parseDouble(txtP2.getText()));
		novo.setNotaTrabalho1(Double.parseDouble(txtT1.getText()));
		novo.setNotaTrabalho2(Double.parseDouble(txtT2.getText()));
		novo.setPesoProvas(Double.parseDouble(txtPesoProvas.getText()));
		novo.setPesoTrabalhos(Double.parseDouble(txtPesoTrabalhos.getText()));
		
		//O mesmo para o combobox -> já validamos
		novo.setNivel(cbNivel.getSelectedItem().toString());
		
		return novo;
	}

	/**
	 * 
	 * @return msg, informando os campos que não estão preenchidos
	 *         "" caso contrário
	 */
	protected String validarPreenchimentoCampos() {
		String mensagemValidacao = "";
		
		
		if(txtNome.getText().equals("")){
			mensagemValidacao += "- Informe o nome \n";
		}
		
		if(txtSobrenome.getText().equals("")){
			mensagemValidacao += "- Informe o sobrenome \n";
		}
		
		if(txtMatricula.getText().equals("")){
			mensagemValidacao += "- Informe a matrícula \n";
		}
		
		//Nível vem de um combobox,logo a verificação é diferente
		//Estranhamente ele não foi declarado como atributo da classe, por isso corrigi
		//Voltando...
		if(cbNivel.getSelectedItem() == null || cbNivel.getSelectedItem().toString().equals(OPCAO_SELECIONE)){
			mensagemValidacao += "- Informe o nível \n";
			//Mas só isso não é suficiente, pois colocamos uma primeira opção que não vale para o aluno (-- Selecione --)
		}
		
		if(txtP1.getText().equals("")){
			//as notas também que ser validadas quanto à formatação...
			mensagemValidacao += "- Informe a nota da Prova 1 \n";
		}else{
			try{
				Double.parseDouble(txtP1.getText());
			}catch(NumberFormatException ex){
				//Caso tenha dado exceção, informar o usuário
				mensagemValidacao += "- Nota da Prova 1 com formato incorreto \n";
			}
		}
		
		if(txtP2.getText().equals("")){
			//as notas também que ser validadas quanto à formatação...
			mensagemValidacao += "- Informe a nota da Prova 2 \n";
		}else{
			try{
				Double.parseDouble(txtP2.getText());
			}catch(NumberFormatException ex){
				//Caso tenha dado exceção, informar o usuário
				mensagemValidacao += "- Nota da Prova 2 com formato incorreto \n";
			}
		}
		
		if(txtT1.getText().equals("")){
			//as notas também que ser validadas quanto à formatação...
			mensagemValidacao += "- Informe a nota do Trabalho 1 \n";
		}else{
			try{
				Double.parseDouble(txtT1.getText());
			}catch(NumberFormatException ex){
				//Caso tenha dado exceção, informar o usuário
				mensagemValidacao += "- Nota do Trabalho 1 com formato incorreto \n";
			}
		}
		
		if(txtT2.getText().equals("")){
			//as notas também que ser validadas quanto à formatação...
			mensagemValidacao += "- Informe a nota do Trabalho 2 \n";
		}else{
			try{
				Double.parseDouble(txtT1.getText());
			}catch(NumberFormatException ex){
				//Caso tenha dado exceção, informar o usuário
				mensagemValidacao += "- Nota do Trabalho 2 com formato incorreto \n";
			}
		}
		
		double pesoProvas = 0.0;
		double pesoTrabalhos = 0.0;
		if(txtPesoProvas.getText().equals("")){
			//as notas também que ser validadas quanto à formatação...
			mensagemValidacao += "- Informe o peso das provas \n";
		}else{
			try{
				pesoProvas = Double.parseDouble(txtPesoProvas.getText());
			}catch(NumberFormatException ex){
				//Caso tenha dado exceção, informar o usuário
				mensagemValidacao += "- Peso dos trabalhos com formato incorreto \n";
			}
		}
		
		
		if(txtPesoTrabalhos.getText().equals("")){
			//as notas também que ser validadas quanto à formatação...
			mensagemValidacao += "- Informe o peso das provas \n";
		}else{
			try{
				//Tinha um erro aqui (copy - paste)
				pesoTrabalhos = Double.parseDouble(txtPesoTrabalhos.getText());
			}catch(NumberFormatException ex){
				//Caso tenha dado exceção, informar o usuário
				mensagemValidacao += "- Peso dos trabalhos com formato incorreto \n";
			}
		}
		
		//Temos que validar também a soma dos pesos
		if((pesoProvas + pesoTrabalhos) != 1){
			mensagemValidacao += "- A soma dos pesos (provas e trabalhos) deve sempre resultar em 1 \n";
		}
		
		return mensagemValidacao;
	}
}
