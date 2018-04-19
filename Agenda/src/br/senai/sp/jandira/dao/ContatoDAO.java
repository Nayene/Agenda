package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jdbc.Conexao;
import br.senai.sp.jandira.model.Contato;

public class ContatoDAO {
	private ResultSet resultado;
	private PreparedStatement stm;
	private Contato contato;
	// RESULTSET É UM OBJETO QUE ARMAZENA INFORMAÇAÕES DO BDA
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public ResultSet getContatos(){  // FAZ CONSULTA NO BANCO 
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
	
	public ArrayList<Contato> getlistaContatos(){  //** (editado)
		
		ArrayList<Contato> contatos = new ArrayList<>();
		String consulta = "SELECT * FROM contatos ORDER BY nome ASC";
		resultado = null;
		stm = null;
	
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery();
			
			while (resultado.next()){  //enquanto linha for verdadeira vai passando de linha //**
				Contato contato = new Contato();
				contato.setId(resultado.getInt("id"));
				contato.setNome(resultado.getString("nome"));
				contato.setDtNascimento(resultado.getString("dtNasc"));
				contato.setEmail(resultado.getString("email"));
				contato.setEndereco(resultado.getString("endereco"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setCelular(resultado.getString("celular"));
				contato.setSexo(resultado.getString("sexo"));
				contatos.add(contato);
			}
			Conexao.fecharConexao();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro com a consulta" , "ERRO" , JOptionPane.ERROR_MESSAGE);
		}
		return contatos;
		//***
	}
		public Contato getContato(int id){  // FAZ CONSULTA NO BANCO //*** 
			Contato contato = new Contato();
			
			String consulta = "SELECT * FROM contatos WHERE id = ?"; // todos os campos da tabela contato ao qual eu vou selecionar 
			resultado = null;
			stm = null;
	
			try{
				stm = Conexao.getConexao().prepareStatement(consulta);
				stm.setInt(1, id );
				resultado = stm.executeQuery();
				
				resultado.next();
				contato.setId(resultado.getInt("id"));  // pega o resultado da celula id
				contato.setNome(resultado.getString("nome"));
				contato.setDtNascimento(resultado.getString("dtNasc"));
				contato.setEmail(resultado.getString("email"));
				contato.setEndereco(resultado.getString("endereco"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setCelular(resultado.getString("celular"));
				contato.setSexo(resultado.getString("sexo"));
				
				Conexao.fecharConexao();
			}catch(Exception erro){
				JOptionPane.showMessageDialog(null, "Ocorreu um erro com a consulta" , "ERRO" , JOptionPane.ERROR_MESSAGE);
			}
			return contato;
		}
		
		public void gravar(){
			
		}
		
		public void atualizar(){
					
		}
		
		public void excluir(){
				
		}
}
