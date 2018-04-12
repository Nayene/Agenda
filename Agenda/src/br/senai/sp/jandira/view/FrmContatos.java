package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class FrmContatos extends JFrame {

	private JPanel painelPrincipal;
	private JTextField textID;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textField_1;
	private JTextField textTel;
	private JTextField textCel;
	private final JButton button_2 = new JButton("");

	
	public FrmContatos(String operacao) {
		setTitle("Contatos");
		setBounds(100, 100, 536, 524);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(135, 206, 235));
		painelTitulo.setBounds(0, 11, 520, 78);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("  Contatos");
		lblTitulo.setIcon(new ImageIcon(FrmContatos.class.getResource("/br/senai/sp/jandira/imagens/icon64 (1).png")));
		lblTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(41, 4, 469, 69);
		painelTitulo.add(lblTitulo);
		
		JLabel lblOperao = new JLabel(operacao);
		lblOperao.setVerticalAlignment(SwingConstants.BOTTOM);
		lblOperao.setForeground(new Color(205, 92, 92));
		lblOperao.setFont(new Font("Arial", Font.BOLD, 15));
		lblOperao.setBounds(415, 25, 95, 42);
		painelTitulo.add(lblOperao);
		
		JPanel painelDados = new JPanel();
		painelDados.setBorder(new TitledBorder(null, "Dados Do Contato", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		painelDados.setBounds(17, 102, 487, 304);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblID.setBounds(25, 29, 33, 14);
		painelDados.add(lblID);
		
		textID = new JTextField();
		textID.setBounds(25, 54, 43, 20);
		painelDados.add(textID);
		textID.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblNome.setBounds(90, 29, 65, 14);
		painelDados.add(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(89, 54, 370, 20);
		painelDados.add(textNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblEmail.setBounds(25, 85, 65, 14);
		painelDados.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(25, 110, 271, 20);
		painelDados.add(textEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(25, 166, 127, 20);
		painelDados.add(textField_1);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblDataNascimento.setBounds(25, 141, 116, 14);
		painelDados.add(lblDataNascimento);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Femino", "Masculino"}));
		comboBoxSexo.setBounds(332, 110, 127, 20);
		painelDados.add(comboBoxSexo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setToolTipText("");
		lblSexo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblSexo.setBounds(332, 85, 65, 14);
		painelDados.add(lblSexo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblTelefone.setBounds(180, 141, 116, 14);
		painelDados.add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblCelular.setBounds(332, 141, 116, 14);
		painelDados.add(lblCelular);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(180, 166, 127, 20);
		painelDados.add(textTel);
		
		textCel = new JTextField();
		textCel.setColumns(10);
		textCel.setBounds(332, 166, 127, 20);
		painelDados.add(textCel);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblEndereco.setBounds(25, 197, 65, 14);
		painelDados.add(lblEndereco);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 224, 438, 69);
		painelDados.add(scrollPane);
		
		JTextArea textEndereco = new JTextArea();
		scrollPane.setViewportView(textEndereco);
		button_2.setForeground(Color.BLACK);
		button_2.setToolTipText("SALVAR");
		button_2.setIcon(new ImageIcon(FrmContatos.class.getResource("/br/senai/sp/jandira/imagens/salvar.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(27, 417, 58, 55);
		painelPrincipal.add(button_2);
		
		JButton button = new JButton("");
		button.setToolTipText("SAIR\t");
		button.setIcon(new ImageIcon(FrmContatos.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		button.setBounds(434, 417, 58, 55);
		painelPrincipal.add(button);
	}
}
