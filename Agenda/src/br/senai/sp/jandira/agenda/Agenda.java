package br.senai.sp.jandira.agenda;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dao.ContatoDAO;

public class Agenda {

	public static void main(String[] args) {
		 ContatoDAO dao = new ContatoDAO();
		 ResultSet rs = dao.getContatos();
		
		try{
			while(rs.next()){
				System.out.println("Nome: " + rs.getString("nome" + ("-"))); 
				System.out.println("Fone: " + rs.getString("telefone"  + ("-")));
				System.out.println("---------------------------------------");
			}
		} catch(Exception erro){
			JOptionPane.showMessageDialog(null,
					"Nao foi possivel concetar-se com o banco de dados",
					"ERRO!", JOptionPane.ERROR_MESSAGE);
		}

		}
}

