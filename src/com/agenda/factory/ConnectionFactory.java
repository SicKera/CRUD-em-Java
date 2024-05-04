package com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	// Nome do Usuario do mysql
	private static final String USERNAME = "root";
	
	// Senha do banco de dados
	private static final String PASSWORD = "Xboxlivesenh@3395";
	
	//Caminho do banco de dados, porta, nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	/*
	 * Conexão com o bando de dados
	 */
	
	public static Connection createConnectionToMySQL() throws Exception  {
		// Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
		
	}
	
	public static void main(String[] args) throws Exception {
		//Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se a conexão é nula
		if (con!= null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}else {
			System.out.println("Falha ao conectar!");
			con.close();
		}
	}

}
