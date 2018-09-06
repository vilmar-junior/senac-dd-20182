package controller;


import java.util.List;

import model.bo.ProdutoBO;
import model.dao.aula05.ProdutoDAO;
import model.vo.aula05.Produto;

public class ProdutoController {

	private ProdutoBO bo = new ProdutoBO();

	public List<Produto> listarTodosProdutos(){
		return bo.listarProdutos();
	}
	
	public List<Produto> listarProdutosAtePreco(double maximo){
		return bo.listarProdutosPorFaixaDePreco(maximo);
	}
	 
	public String salvar(Produto produto) {
		String validacao = validarProduto(produto);

		if(validacao == "") {
			if(produto.getId() > 0) {
				//INSERT
				if(bo.atualizar(produto)) {
					validacao = "Produto atualizado com sucesso!";
				}else {
					validacao = "Erro ao atualizar produto";
				}
			}else {
				//INSERT
				if(bo.inserir(produto)) {
					validacao = "Produto salvo com sucesso!";
				}else {
					validacao = "Erro ao salvar produto";
				}
			}
		}

		return validacao;
	}

	private String validarProduto(Produto produto) {
		String validacao = "";

		if(produto == null) {
			validacao = "Produto está NULO!";
		}else {
			//Validar o preenchimento
			if(produto.getNome().trim().equals("")) {
				validacao += "- Nome é obrigatório \n";
			}
			if(produto.getFabricante().trim().equals("")) {
				validacao += "- Fabricante é obrigatório \n";
			}
		}
		return validacao;
	}
}
