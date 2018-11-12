package model.bo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.vo.aula05.Produto;

/**
 * Classe utilitária para gerar planilhas Excel através da API Apache POI.
 * 
 * @author Vilmar César Pereira Júnior
 *
 */
public class GeradorPlanilha {

	/**
	 * Gera uma planilha .xls de produtos (exemplo básico)
	 * 
	 * @param produtos
	 *            a lista de produtos que vai preencher a planilha
	 * 
	 * @return byte[] a planilha (do tipo HSSFWorkbook) convertida para um array
	 *         de bytes
	 */
	public void gerarPlanilhaProdutos(List<Produto> produtos, String caminho) {
		String[] columns = { "Nome", "Fabricante", "Valor", "Peso" };

		HSSFWorkbook planilha = new HSSFWorkbook();

		// 1) Cria uma aba na planilha (nome é um parâmetro opcional)
		HSSFSheet abaPlanilha = planilha.createSheet("Produtos");

		Row headerRow = abaPlanilha.createRow(0);

		// 2) Cria o cabeçalho a partir de um array columns
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}

		// 3) Cria as linhas com os produtos da lista
		int rowNum = 1;
		for (Produto prod : produtos) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);

			novaLinha.createCell(0).setCellValue(prod.getNome());
			novaLinha.createCell(1).setCellValue(prod.getFabricante());
			novaLinha.createCell(2).setCellValue(prod.getValor());
			novaLinha.createCell(3).setCellValue(prod.getPeso());
		}

		// 4) Ajusta o tamanho de todas as colunas conforme a largura do
		// conteúdo
		for (int i = 0; i < columns.length; i++) {
			abaPlanilha.autoSizeColumn(i);
		}

		//5) Escreve o arquivo em disco, no caminho informado
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(caminho + ".xls");
			planilha.write(fileOut);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fileOut != null){
				try {
					fileOut.close();
					planilha.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}