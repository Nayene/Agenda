package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jdbc.Conexao;

public class ContatoDAO {
	private ResultSet resultado;
	private PreparedStatement stm;
	
	public ResultSet getContatos(){
		String consulta = "SELECT * FROM contatos ORDER BY nome ASC";
		resultado = null;
		stm = null;
	
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery();
			Conexao.fecharConexao();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro com a consulta" , "ERRO" , JOptionPane.ERROR_MESSAGE);
		}
		
		return resultado;
	}
}
