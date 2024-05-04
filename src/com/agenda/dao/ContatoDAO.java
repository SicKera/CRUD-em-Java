package com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.agenda.factory.ConnectionFactory;
import com.agenda.model.Contato;


 public class ContatoDAO {
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		// Criar uma conexão com o banco de dados
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			// Executar a query
			pstm.execute();
			
			System.out.println("Contato salvo com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//Fechar as conexões
			try {
				if (pstm!=null) {
					pstm.close();
				}
				if (conn!= null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}