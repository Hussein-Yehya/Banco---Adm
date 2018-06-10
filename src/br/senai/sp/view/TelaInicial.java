package br.senai.sp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TelaInicial {
	private JFrame frmTela;
	private JPanel pnlPrincipal, pnlBotoes, pnlEditor, pnlNotificacoes;
	private JButton btnCadastrar, btnSair, btnAutorizacao, btnGerarPdf;
	private JLabel lblTitulo, lblSubtitulo, lblFoto, lblUsuario, lblNotificacao;
	private Font fonteTitulo, fonteSubTitulo, fontePadrao;
	private JMenuBar menuBarra;
	private JMenu fileMenu ;
	private JMenuItem menuSair;
	
	

	public TelaInicial() {
		iniciarComponentes();
		iniciarAcoes();
	}

	private void iniciarComponentes() {
		
		 menuBarra = new JMenuBar();
		 fontePadrao = new Font("Calibri", Font.PLAIN, 20);
	        
	  
	        
	        // Define e adiciona dois menus drop down na barra de menus
	        fileMenu = new JMenu("File");
	  
	       
	        menuBarra.add(fileMenu);
	      
	        
	        // Cria e adiciona um item simples para o menu
	 
	        
	        ImageIcon imgSair = new ImageIcon("imagens/menuSair.png");
	         menuSair = new JMenuItem(imgSair);
	         menuSair.setToolTipText("Sair");
	        fileMenu.add(menuSair);
	        
	       
	        
	       
	        
	        
		
		//
		// JFONT
		//
		fonteTitulo = new Font("ARIAL", Font.PLAIN, 80);
		fonteSubTitulo = new Font("ARIAL", Font.ITALIC, 40);
		//
		// JLABEL TITULO
		//
		
		ImageIcon img05 = new ImageIcon("imagens/banco.png");
		lblFoto = new JLabel(img05);
		lblFoto.setBounds(425, 50, 250,190);
		
		lblTitulo = new JLabel("BANCO IMPERIAL");
		lblTitulo.setBounds(230,239, 900, 200);
		lblTitulo.setFont(fonteTitulo);
		lblTitulo.setForeground(Color.WHITE);
		
		lblSubtitulo = new JLabel("Sistema Bancário");
		lblSubtitulo.setBounds(390,339, 900, 200);
		lblSubtitulo.setFont(fonteSubTitulo);
		lblSubtitulo.setForeground(Color.WHITE);

		//
		// JPanel, pnlEditor
		//
		pnlEditor = new JPanel();
		pnlEditor.setBounds(200, 10, 50, 50);
		pnlEditor.setBackground(Color.decode("#172D3A"));
		
		lblNotificacao = new JLabel("Usuário: ");
		lblNotificacao.setBounds(10, 10, 110, 50);
		lblNotificacao.setFont(fontePadrao);
		lblNotificacao.setForeground(Color.WHITE);
		
		lblUsuario = new JLabel("Administrador");
		lblUsuario.setBounds(90, 20, 140, 30);
		lblUsuario.setBackground(Color.decode("#172D3A"));
		lblUsuario.setForeground(Color.white);
		lblUsuario.setFont(fontePadrao);


		//
		// JBUTTON btnSair
		//
		ImageIcon img02 = new ImageIcon("imagens/sair.png");
		btnSair = new JButton(img02);
		btnSair.setBounds(30, 680, 130, 130);
		btnSair.setBackground(Color.decode("#698495"));
		btnSair.setContentAreaFilled(false);
		btnSair.setBorderPainted(false);
		btnSair.setFocusPainted(false);
		btnSair.setToolTipText("SAIR");

		//
		// JBUTTON BTNPRODUTOS
		//
		
		ImageIcon img06 = new ImageIcon("imagens/autorizacao.png");
		btnAutorizacao = new JButton(img06);
		btnAutorizacao.setBackground(Color.decode("#698495"));
		btnAutorizacao.setBounds(30, 10, 130, 130);
		btnAutorizacao.setContentAreaFilled(false);
		btnAutorizacao.setBorderPainted(false);
		btnAutorizacao.setFocusPainted(false);
		btnAutorizacao.setToolTipText("Autorização");
		
		
	
		ImageIcon img07 = new ImageIcon("imagens/imprimir.png");
		btnGerarPdf = new JButton(img07);
		btnGerarPdf.setBackground(Color.decode("#698495"));
		btnGerarPdf.setBounds(30, 150, 130, 120);
		btnGerarPdf.setContentAreaFilled(false);
		btnGerarPdf.setBorderPainted(false);
		btnGerarPdf.setFocusPainted(false);
		btnGerarPdf.setToolTipText("Gerar PDF");

		//
		// JButton btnEntrar
		//
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setLocation(200, 10);
		btnCadastrar.setSize(48, 150);

		// lbl DATA
		Date horas = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("hh:mm");
		JLabel lblData = new JLabel(df.format(horas));
		lblData.setBounds(1020, 20, 100, 25);
		lblData.setFont(fontePadrao);
		lblData.setForeground(Color.WHITE);
		
		// lbl dias
		Date dia = new Date();
		SimpleDateFormat dataDia;
		dataDia = new SimpleDateFormat("dd/MM/yyyy");
		JLabel lblDia = new JLabel(dataDia.format(dia));
		lblDia.setBounds(900, 20, 100, 25);
		lblDia.setFont(fontePadrao);
		lblDia.setForeground(Color.WHITE);
		
		//
		// JPanel pnlPricipal
		//
	
		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(null);
		pnlPrincipal.setLocation(200, 10);
		pnlPrincipal.setSize(1085, 750);
		pnlPrincipal.add(lblFoto);
		pnlPrincipal.add(lblTitulo);
		pnlPrincipal.add(lblSubtitulo);
		pnlPrincipal.setBackground(Color.decode("#172D3A"));
		

		//
		// JPanel pnlBotoes
		//
		pnlBotoes = new JPanel();
		pnlBotoes.setLayout(null);
		pnlBotoes.setLocation(10, 10);
		pnlBotoes.setSize(180, 820);
		pnlBotoes.setBackground(Color.decode("#698495"));
		pnlBotoes.add(btnSair);
		pnlBotoes.add(btnAutorizacao);
		pnlBotoes.add(btnGerarPdf);

		pnlNotificacoes = new JPanel();
		pnlNotificacoes.setLayout(null);
		pnlNotificacoes.setLocation(200, 770);
		pnlNotificacoes.setSize(1085, 60);
		pnlNotificacoes.add(lblNotificacao);
		pnlNotificacoes.add(lblUsuario);
		pnlNotificacoes.add(lblData);
		pnlNotificacoes.add(lblDia);
		pnlNotificacoes.setBackground(Color.decode("#172D3A"));
		//
		// JFrame frmTela
		//
		frmTela = new JFrame();
		frmTela.setTitle("Sistema Bancário");
		frmTela.setSize(1300, 900);
		frmTela.setLocationRelativeTo(null);
		frmTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTela.setResizable(false);
		frmTela.setLayout(null);
		frmTela.setJMenuBar(menuBarra);
		frmTela.getContentPane().add(pnlPrincipal);
		frmTela.getContentPane().add(pnlBotoes);
		frmTela.getContentPane().add(pnlNotificacoes);

		frmTela.setVisible(true);

	}

	public void iniciarAcoes() {

		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(frmTela, "Confirma saída?", "SAIR",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});

		menuSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(frmTela, "Confirma saída?", "SAIR",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	

		
		btnAutorizacao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pnlPrincipal.setVisible(false);
				pnlPrincipal = new PainelAutorizacao();
				frmTela.add(pnlPrincipal);
				pnlPrincipal.setVisible(true);

			}
		});
		
		btnGerarPdf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
						try {
							new GerarRelatorio();
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				
			}
		});
		
		

	}
	

}
