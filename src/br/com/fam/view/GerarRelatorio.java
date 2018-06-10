package br.senai.sp.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import br.senai.sp.dao.DAOCliente;
import br.senai.sp.model.Cliente;

public class GerarRelatorio {

	public static final String DEST = "impressora//PDFCliente.pdf";
	public static final String LOGO = "imagens/banco.bmp";

	public GerarRelatorio() throws MalformedURLException {
		gerarRelatorio();
	}

	private void gerarRelatorio() throws MalformedURLException {
		try {
			File dest = new File(DEST);
			dest.getParentFile().mkdirs();

			// Cria o escritor de PDF
			FileOutputStream fos;

			fos = new FileOutputStream(dest);
			PdfWriter writer = new PdfWriter(fos);

			// Cria o documento PDF
			PdfDocument pdf = new PdfDocument(writer);

			// Inicializa o documento
			Document document = new Document(pdf);

		

			// Adiciona um parágrafo ao documento
	
			
			Paragraph paragrafo = new Paragraph("Banco Imperial \n");
			paragrafo.add("Relatório: \n\n");
			

			/*
			 * try { IMAAAAAAAAAAAAAAAAAAAGEM Image logo = new
			 * Image(ImageDataFactory.create(LOGO)); paragrafo.add(logo); }
			 * catch (Exception e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

			DAOCliente bdCliente = new DAOCliente();
			new Cliente();

			int resposta;
			paragrafo.add("____________________________________________\n");
			resposta = JOptionPane.showConfirmDialog(null, "Deseja relatar os negativados também?");
			if (resposta == JOptionPane.YES_OPTION) {

				for (Cliente c : bdCliente.listar()) {
					paragrafo.add(String.valueOf("Nome : " + c.getNome() + "\n"));
					paragrafo.add(String.valueOf("CPF  : " + c.getCpf() + "\n"));
					paragrafo.add(String.valueOf("Renda: " + c.getRenda() + "\n"));
					paragrafo.add("____________________________________________\n");
					
				}
				JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
			} else {
			if (resposta == JOptionPane.NO_OPTION) {
				
				for (Cliente c : bdCliente.listar()) {
					if (c.isDocumentos() == true && c.isSerasa() == true && c.isSpc() == true) {
						paragrafo.add(String.valueOf("Nome : " + c.getNome() + "\n  "));
						paragrafo.add(String.valueOf("CPF  : " + c.getCpf() + "\n  "));
						paragrafo.add(String.valueOf("Renda: " + c.getRenda() + "\n "));
						paragrafo.add("____________________________________________\n");
					
					}
					JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
				} 
			}else {
				if (resposta == JOptionPane.CANCEL_OPTION || resposta == JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "Finalizado com sucesso!");
				}
			}

			}
			

			document.add(paragrafo);

			// Fecha o documento
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
