package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class FrmAgenda extends JFrame {
	// declarou um painel 
	private JPanel painelPrincipal;
	private JLabel lblTitulo;
	private JTable tabelaContatos;
	private JPanel painelTabela;  //***
	// construtor da classe
	public FrmAgenda() {
		// painel titulo
		setTitle("Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar
		setBounds(100, 100, 574, 573); //tamanho
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal); //dentro do frame
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.PINK);
		painelTitulo.setBounds(0, 11, 558, 69);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		lblTitulo = new JLabel("Agenda De Contatos");
		lblTitulo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/icon64 (1).png")));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setBounds(10, 0, 311, 69);
		painelTitulo.add(lblTitulo);
		
		painelTabela = new JPanel();  //***
		painelTabela.setBackground(SystemColor.menu);
		painelTabela.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Meus Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(135, 206, 235)));
		painelTabela.setBounds(0, 91, 558, 326);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		// **** Constru��o da tabela aqui!!!!  //**
		criarTabela();  //***
		// painel de botoes
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(Color.PINK);
		painelBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelBotoes.setBounds(0, 427, 558, 75);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		// botao novo
		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmContatos contato = new FrmContatos("ADICIONAR");
				contato.setTitle("Adicionar Contato");
				contato.setVisible(true);
			}
		});
		
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/adicionar.png")));
		btnNovo.setToolTipText("Cadastrar novo contato");
		btnNovo.setBounds(14, 11, 63, 50);
		painelBotoes.add(btnNovo);
		
		// botao editar
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//** COLOCAR PARA APARECER AUTOMATICO 
				preenchimentoAuto("Editar");
			}
		});
		
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/edit.png")));
		btnEditar.setToolTipText("Editar contato");
		btnEditar.setBounds(87, 11, 63, 50);
		painelBotoes.add(btnEditar);
		
		// botao excluir
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//** COLOCAR PARA APARECER AUTOMATICO 	
				preenchimentoAuto("Excluir");
			}
		});
		
		btnExcluir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/cancel.png")));
		btnExcluir.setToolTipText("Excluir contato");
		btnExcluir.setBounds(164, 11, 63, 50);
		painelBotoes.add(btnExcluir);
		
		// botao sair
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setBounds(485, 11, 63, 50);
		painelBotoes.add(btnSair);	
	}
	// Colocou aqui para criar outro m�todo para a edi��o da tabela  //**
	public void criarTabela(){

		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 22, 538, 293);
		painelTabela.add(scrollTabela);
		
		tabelaContatos = new JTable();
		
		ArrayList<Contato> contatos = new ArrayList<>();
		ContatoDAO dao = new 	ContatoDAO();
		contatos = dao.getlistaContatos();
		
		// *** TITULO DA TABELA ***   /**
		
		DefaultTableModel modeloTabela = new DefaultTableModel(){ // para o usuario nao poder editar as celulas da tabela
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		
		
		String[] nomesColunas ={"ID", "NOME", "E-MAIL"};
		modeloTabela.setColumnIdentifiers(nomesColunas);
		 
		
		//***DADOS DA TABELA ***
		Object[] linha = new Object[3];  //** //criando matriz
		
		for (Contato contato : contatos){    // adiicionando as linhas do banco
			linha[0] = contato.getId();
			linha[1] = contato.getNome();
			linha[2] = contato.getEmail();
			modeloTabela.addRow(linha);
		}
		
		tabelaContatos.setModel(modeloTabela); //***
		
		//** TRAVANDO MOVIMENTA��O DE COLUNAS **
		tabelaContatos.getTableHeader().setReorderingAllowed(false); 
		
		
		//*** FORMTA��O DAS COLUNAS DA TABELA ***
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(20); // tamanho das colunas // larguras
		tabelaContatos.getColumnModel().getColumn(0).setResizable(false);  // o usuario noa consegue editar o tamanho da colunas
		
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaContatos.getColumnModel().getColumn(1).setResizable(false); 
		
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabelaContatos.getColumnModel().getColumn(2).setResizable(false); 
		scrollTabela.setViewportView(tabelaContatos); //linha de rolagem quando a tela for grande
		
	}
	public void preenchimentoAuto(String operacao){
		FrmContatos frmContato = new FrmContatos(operacao);
		frmContato.setTitle(operacao + "contato");
		try{ 
			int linha = tabelaContatos.getSelectedRow();
			int id = (int) tabelaContatos.getValueAt(linha, 0);
			
			ContatoDAO contatoDAO = new ContatoDAO();
			Contato contato = new Contato();
			contato = contatoDAO.getContato(id);
			
			frmContato.setTextID(contato.getId());;
			frmContato.setTextNome(contato.getNome());
			frmContato.setTextEmail(contato.getEmail());
			frmContato.setTextCel(contato.getCelular());
			frmContato.setTextTel(contato.getTelefone());
			frmContato.setTextEndereco(contato.getEndereco());
			frmContato.setCbSexo(contato.getSexo());
			frmContato.setTextDtNasc(contato.getDtNascimento());
			frmContato.setVisible(true);
			
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null," Por favor escolha um contato na lista", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
	}
}
