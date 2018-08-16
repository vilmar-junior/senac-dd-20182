package executavel;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.dao.aula05.FuncionarioDAO;
import model.vo.aula05.Funcionario;
import model.vo.aula05.Produto;
import view.MenuExercicio04;

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
		MenuExercicio04 menu = new MenuExercicio04();
		//menu.apresentarMenu();
		
		Funcionario joao = new Funcionario("João Silva", "123-4", "111.111.111-61");
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		funcDAO.inserir(joao);
		
//		Produto p = new Produto("Caneta", "Bic", 2.5, 0.15);
//		ProdutoDAO dao = new ProdutoDAO();
//		
//		Produto produtoQueTemNoBanco = dao.obterPorId(1);
//		Produto produtoQueNaoTemNoBanco = dao.obterPorId(100);
//		
//		mostrarProdutoNaTela(produtoQueTemNoBanco);
//		mostrarProdutoNaTela(produtoQueNaoTemNoBanco);
		
//		int chaveGerada = dao.inserir(p);
		
//		boolean removeu = dao.remover(2);
//		if(removeu){
//			JOptionPane.showMessageDialog(null, "Produto removido");
//		}else{
//			JOptionPane.showMessageDialog(null, "Temos problemas em Houston!");
//		}
		
//		ArrayList<Produto> listaProdutos = dao.listarTodos();
//		JOptionPane.showMessageDialog(null, "Produtos cadastrados \n" + listaProdutos.toString(), "Listagem", JOptionPane.WARNING_MESSAGE, null);
	}

	private static void mostrarProdutoNaTela(Produto produto) {
		
		if(produto != null){
			JOptionPane.showMessageDialog(null, produto.toString());
		}else{
			JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
		}
		
	}
}