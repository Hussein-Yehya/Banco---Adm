package br.senai.sp.teste;

import br.senai.sp.dao.DAOCliente;
import br.senai.sp.model.Cliente;

public class buscar {
	public static void main(String[] args) {

		// buscar ok!! 
		
		DAOCliente bdCliente = new DAOCliente();
		
		Cliente p = bdCliente.buscar(1);
		System.out.println(p.getCodigo() + ":" + p.getNome() + " estado " + p.getEstado() + " CEP " + p.getCep());
		
		
		
	}
}
