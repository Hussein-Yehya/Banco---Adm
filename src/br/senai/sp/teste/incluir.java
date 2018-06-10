package br.senai.sp.teste;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.senai.sp.dao.DAOCliente;
import br.senai.sp.model.Cliente;

public class incluir {

	public static void main(String[] args) {
		
		Cliente p = new Cliente();
		
		p.setNome("Teste8");
		p.setTelefone("1231-9555");
		p.setNumero(3231);
		p.setEndereco("Ouchi");
		p.setEmail("sofia@gmail.com");
		p.setRenda(45.25);
		p.setCivil("1");
		p.setNascimento( new Date());
		p.setRg("231231");
		p.setCpf("43798775803");
		p.setCep("02211-010");
		p.setComplemento("Casa");
		p.setCelular("11 252151");
		p.setSexo(false);
		p.setBairro("Luz Paulista");
		p.setEstado("SP");
		p.setSerasa(true);
		p.setSpc(true);
		p.setDocumentos(false);
		p.setCidade("Sao Paulo");
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat f = new SimpleDateFormat("hh:mm");
        System.out.println(p + " :" +f.format(date));
        
		
		DAOCliente bdCliente = new DAOCliente();
		
		bdCliente.incluir(p);
		
		
		

		
	}
}
