package br.senai.sp.teste;

import br.senai.sp.dao.DAOCliente;
import br.senai.sp.model.Cliente;

public class excluir {
	public static void main(String[] args) {

		// EXCLUIR OK !!! 
		
	Cliente p = new Cliente();
		
		p.setCodigo(1);
		
		DAOCliente bdCliente = new DAOCliente();
		
		bdCliente.excluir(p);
		
		System.out.println(bdCliente);
	}
}
