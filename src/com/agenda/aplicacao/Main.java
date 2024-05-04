package com.agenda.aplicacao;

import java.util.Date;

import com.agenda.dao.ContatoDAO;
import com.agenda.model.Contato;

public class Main {
	public static void main(String[] args) {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Mayra");
		contato.setIdade(35);
		contato.setDataCadastro(new Date());
		
		contatoDAO.save(contato);
	}

}
