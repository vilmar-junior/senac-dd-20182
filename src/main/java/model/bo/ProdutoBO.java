package model.bo;

import model.dao.aula05.ProdutoDAO;
import model.vo.aula05.Produto;

public class ProdutoBO {

	ProdutoDAO dao = new ProdutoDAO();
	public boolean inserir(Produto produto) {
		int idGerado = dao.inserir(produto);
		return idGerado > 0;
	}
	public Produto buscarProdutoPorId(String textoId) {
		Produto produtoBuscado = dao.obterPorId(Integer.parseInt(textoId));
		return produtoBuscado;
	}
	public boolean atualizar(Produto produto) {
		boolean sucesso = dao.atualizar(produto);
		return sucesso;
	}
}
