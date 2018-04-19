package br.senai.sp.jandira.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	// criando o atributo estatico 
	private static Connection con;
	// Metódo estatico (sempre retorna o mesmo caminho , nunca muda )
	public static Connection getConexao(){
		con = null; 
		
		// comando que permite que ele se conecte com o access
		try { //caminho do access
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			//String dbURL ="jdbc:ucanaccess://C:/Users/17259224/Documents/agenda.accdb";
			String dbURL ="jdbc:ucanaccess:////10.107.134.3/banco2/agenda.accdb";
			con = DriverManager.getConnection(dbURL);			
			
		}catch (Exception erro){ //tratamento de erro
			JOptionPane.showMessageDialog(null,
					"Nao foi possivel concetar-se com o banco de dados",
					"ERRO!", JOptionPane.ERROR_MESSAGE);
			System.out.println(erro.getMessage());
		}
		
		return con;
	}
	
	public static void fecharConexao (){
		if (con!= null){
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"O banco ja esta fechado!",
						"ERRO!", JOptionPane.ERROR_MESSAGE);
				System.out.println(e.getMessage());
			}
		}	
	}
	
}
