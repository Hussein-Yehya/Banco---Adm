package br.senai.sp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import br.senai.sp.dao.DAOCliente;
import br.senai.sp.model.Cliente;
import br.senai.sp.model.TableModelCliente;

@SuppressWarnings("serial")
public class PainelAutorizacao extends JPanel {
	private JLabel lblLimite, lblSerasa, lblSpc, lblDocumentos, lblNome, lblCPF, lblRenda, lblAviso, lblSaldo;
	private JPanel pnlAutorizacao, pnlDadosCliente;
	private JRadioButton rbtLiberado, rbtNegativado, rbtValidos, rbtInvalidos, rbtLiberado1, rbtNegativado1;
	private JTextField txtLimite, txtCPF, txtNome, txtRenda, txtSaldo;
	private JButton btnAlterar;
	private Font fontePadrao;
	private JTable tblCliente;
	private TableModelCliente modelCliente;
	private DAOCliente bdCliente;
	private JScrollPane pnlRolagem3;
	private Cliente clienteSelecionado;

	public PainelAutorizacao() {
		bdCliente = new DAOCliente();
		iniciarComponentes();
		iniciarAcoes();
	}

	private void iniciarComponentes() {

		//
		// JFONT
		//
		fontePadrao = new Font("Calibri", Font.PLAIN, 20);
		//
		// JLabel lblLimite, lblRG, lblCPF
		//
		lblAviso = new JLabel("*Seu limite não pode exceder 30% sobre sua renda!");
		lblAviso.setBounds(10, 210, 500, 50);
		lblAviso.setFont(fontePadrao);
		lblAviso.setForeground(Color.black);

		lblLimite = new JLabel("Limite de Crédito:");
		lblLimite.setBounds(10, 275, 160, 50);
		lblLimite.setFont(fontePadrao);
		lblLimite.setForeground(Color.black);
		

		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(330, 275, 160, 50);
		lblSaldo.setFont(fontePadrao);
		lblSaldo.setForeground(Color.black);
		

		lblNome = new JLabel("Nome completo:");
		lblNome.setBounds(10, 30, 150, 50);
		lblNome.setFont(fontePadrao);
		lblNome.setForeground(Color.black);

		lblSerasa = new JLabel("Consulta SERASA");
		lblSerasa.setLocation(10, 20);
		lblSerasa.setSize(200, 50);
		lblSerasa.setFont(fontePadrao);
		lblSerasa.setForeground(Color.black);

		lblRenda = new JLabel("Renda:");
		lblRenda.setBounds(810, 30, 100, 50);
		lblRenda.setFont(fontePadrao);
		lblRenda.setForeground(Color.black);

		lblCPF = new JLabel("CPF:");
		lblCPF.setLocation(585, 30);
		lblCPF.setSize(100, 50);
		lblCPF.setFont(fontePadrao);
		lblCPF.setForeground(Color.black);

		//
		// rbtLiberado
		//
		rbtLiberado = new JRadioButton("Liberado");
		rbtLiberado.setBounds(180, 32, 100, 25);
		rbtLiberado.setFont(fontePadrao);
		rbtLiberado.setBackground(Color.decode("#698495"));
		rbtLiberado.setForeground(Color.black);
		rbtLiberado.setSelected(true);

		//
		// rbtNegativado
		//
		rbtNegativado = new JRadioButton("Negativado");
		rbtNegativado.setBounds(300, 32, 130, 25);
		rbtNegativado.setFont(fontePadrao);
		rbtNegativado.setBackground(Color.decode("#698495"));
		rbtNegativado.setForeground(Color.black);

		lblSpc = new JLabel("Consulta SPC");
		lblSpc.setLocation(10, 70);
		lblSpc.setSize(200, 50);
		lblSpc.setFont(fontePadrao);
		lblSpc.setForeground(Color.black);

		//
		// rbtLiberado
		//
		rbtLiberado1 = new JRadioButton("Liberado");
		rbtLiberado1.setBounds(180, 82, 100, 25);
		rbtLiberado1.setFont(fontePadrao);
		rbtLiberado1.setBackground(Color.decode("#698495"));
		rbtLiberado1.setForeground(Color.black);
		rbtLiberado1.setSelected(true);

		//
		// rbtNegativado
		//
		rbtNegativado1 = new JRadioButton("Negativado");
		rbtNegativado1.setBounds(300, 82, 130, 25);
		rbtNegativado1.setFont(fontePadrao);
		rbtNegativado1.setBackground(Color.decode("#698495"));
		rbtNegativado1.setForeground(Color.black);

		lblDocumentos = new JLabel("Documentos");
		lblDocumentos.setLocation(10, 120);
		lblDocumentos.setSize(200, 50);
		lblDocumentos.setFont(fontePadrao);
		lblDocumentos.setForeground(Color.black);

		//
		// rbtLiberado
		//
		rbtValidos = new JRadioButton("Válidos");
		rbtValidos.setBounds(180, 132, 100, 25);
		rbtValidos.setFont(fontePadrao);
		rbtValidos.setBackground(Color.decode("#698495"));
		rbtValidos.setForeground(Color.black);
		rbtValidos.setSelected(true);

		//
		// rbtNegativado
		//
		rbtInvalidos = new JRadioButton("Inválidos");
		rbtInvalidos.setBounds(300, 132, 130, 25);
		rbtInvalidos.setFont(fontePadrao);
		rbtInvalidos.setBackground(Color.decode("#698495"));
		rbtInvalidos.setForeground(Color.black);

		//
		// ButtonGroup Opções
		//
		ButtonGroup grpOpcao = new ButtonGroup();
		grpOpcao.add(rbtLiberado);
		grpOpcao.add(rbtNegativado);
		ButtonGroup grpOpcao1 = new ButtonGroup();
		grpOpcao1.add(rbtLiberado1);
		grpOpcao1.add(rbtNegativado1);
		ButtonGroup grpOpcao2 = new ButtonGroup();
		grpOpcao2.add(rbtValidos);
		grpOpcao2.add(rbtInvalidos);

		ImageIcon img05 = new ImageIcon("imagens/alterarAutorizacao.png");
		btnAlterar = new JButton(img05);
		btnAlterar.setLocation(920, 530);
		btnAlterar.setSize(140, 200);
		btnAlterar.setBackground(Color.decode("#172D3A"));
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setFocusPainted(false);
		btnAlterar.setToolTipText("ALTERAR");

		//
		// JTextField txtLimite, txtSenha, txtTelefone
		//
		txtLimite = new JTextField();
		txtLimite.setBounds(170, 280, 100, 30);
		txtLimite.setFont(fontePadrao);
		
		txtSaldo = new JTextField();
		txtSaldo.setBounds(390, 280, 100, 30);
		txtSaldo.setFont(fontePadrao);
		txtSaldo.setEditable(false);

		txtCPF = new JTextField();
		txtCPF.setBounds(625, 35, 150, 30);
		txtCPF.setEditable(false);
		txtCPF.setFont(fontePadrao);

		txtNome = new JTextField();
		txtNome.setBounds(155, 35, 400, 30);
		txtNome.setEditable(false);
		txtNome.setFont(fontePadrao);

		txtRenda = new JTextField();
		txtRenda.setBounds(880, 35, 150, 30);
		txtRenda.setEditable(false);
		txtRenda.setFont(fontePadrao);

		//
		// JTable tblCliente
		//
		modelCliente = new TableModelCliente();

		modelCliente.atualizarModelo();
		tblCliente = new JTable(modelCliente);
		tblCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		pnlRolagem3 = new JScrollPane(tblCliente);
		pnlRolagem3.setBounds(10, 530, 900, 200);
		pnlRolagem3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		Border linhaDados1 = BorderFactory.createLineBorder(Color.BLACK);
		pnlDadosCliente = new JPanel();
		pnlDadosCliente.setLocation(10, 10);
		pnlDadosCliente.setLayout(null);
		pnlDadosCliente.setBorder(new TitledBorder(linhaDados1, "Dados Cliente"));
		pnlDadosCliente.setSize(1050, 80);
		pnlDadosCliente.add(lblNome);
		pnlDadosCliente.add(txtNome);
		pnlDadosCliente.add(lblCPF);
		pnlDadosCliente.add(txtCPF);
		pnlDadosCliente.add(lblRenda);
		pnlDadosCliente.add(txtRenda);
		pnlDadosCliente.setBackground(Color.decode("#698495"));

		Border linhaDados = BorderFactory.createLineBorder(Color.BLACK);
		pnlAutorizacao = new JPanel();
		pnlAutorizacao.setLocation(10, 100);
		pnlAutorizacao.setLayout(null);
		pnlAutorizacao.setBorder(new TitledBorder(linhaDados, "Autorizacao"));
		pnlAutorizacao.setSize(1050, 400);
		pnlAutorizacao.add(lblAviso);
		pnlAutorizacao.add(lblLimite);
		pnlAutorizacao.add(txtLimite);
		pnlAutorizacao.add(lblSerasa);
		pnlAutorizacao.add(lblSpc);
		pnlAutorizacao.add(lblDocumentos);
		pnlAutorizacao.add(rbtLiberado);
		pnlAutorizacao.add(rbtNegativado);
		pnlAutorizacao.add(rbtLiberado1);
		pnlAutorizacao.add(rbtNegativado1);
		pnlAutorizacao.add(rbtValidos);
		pnlAutorizacao.add(rbtInvalidos);
		pnlAutorizacao.add(lblSaldo);
		pnlAutorizacao.add(txtSaldo);
		pnlAutorizacao.setBackground(Color.decode("#698495"));

		//
		// JPanel this
		//

		this.setLayout(null);
		this.setLocation(200, 10);
		this.setSize(1085, 750);
		this.setBackground(Color.decode("#172D3A"));
		this.add(pnlAutorizacao);
		this.add(pnlDadosCliente);
		this.add(pnlRolagem3);
		this.add(btnAlterar);
	}

	public void iniciarAcoes() {

		btnAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tblCliente.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um Cliente");
				} else {
					// criar um objeto com os dados da tela

					if (rbtInvalidos.isSelected() == true || rbtNegativado.isSelected() == true
							|| rbtNegativado1.isSelected() == true) {
						JOptionPane.showMessageDialog(null,
								"Você não pode pedir um limite de crédito. Seu nome está negativado");

					} else {
						double limites = clienteSelecionado.getRenda() * 0.3;

						if (Double.parseDouble(txtLimite.getText()) > limites) {

							JOptionPane.showMessageDialog(null, "Inválido. O limite excedeu os 30% da sua renda");
						} else {
							clienteSelecionado.setLimite(Double.parseDouble(txtLimite.getText()));
						}

						clienteSelecionado.setSerasa(rbtLiberado.isSelected());
						clienteSelecionado.setSpc(rbtLiberado1.isSelected());
						clienteSelecionado.setDocumentos(rbtValidos.isSelected());

					}

					// Salvar o Cliente
					bdCliente.alterar(clienteSelecionado);
					clienteSelecionado = null;
					limparFormulario();
					// preencherTabela();
					modelCliente.atualizarModelo();
				}
			}
		});

		tblCliente.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = tblCliente.getSelectedRow();

				clienteSelecionado = modelCliente.getCliente(linha);

				txtNome.setText(clienteSelecionado.getNome());
				txtCPF.setText(clienteSelecionado.getCpf());
				txtRenda.setText(String.valueOf(clienteSelecionado.getRenda()));
				txtLimite.setText(String.valueOf(clienteSelecionado.getLimite()));
				txtSaldo.setText(String.valueOf(clienteSelecionado.getSaldo()));
				analisarRbt();
				anaslisarRbtNegativodo();
				if (clienteSelecionado.isSerasa()) {
					rbtLiberado.setSelected(true);
					rbtNegativado.setSelected(false);
				} else {
					rbtLiberado.setSelected(false);
					rbtNegativado.setSelected(true);
				}

				if (clienteSelecionado.isSpc()) {
					rbtValidos.setSelected(true);
					rbtInvalidos.setSelected(false);
				} else {
					rbtValidos.setSelected(false);
					rbtInvalidos.setSelected(true);
				}

				if (clienteSelecionado.isDocumentos()) {
					rbtLiberado1.setSelected(true);
					rbtNegativado1.setSelected(false);
				} else {
					rbtLiberado1.setSelected(false);
					rbtNegativado1.setSelected(true);
				}

			}
		});

		rbtLiberado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				analisarRbt();

			}

		});

		rbtNegativado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				anaslisarRbtNegativodo();

			}
		});

		rbtLiberado1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				analisarRbt();
			}
		});

		rbtNegativado1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anaslisarRbtNegativodo();
			}
		});

		rbtValidos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				analisarRbt();
			}
		});

		rbtInvalidos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anaslisarRbtNegativodo();

			}
		});
	}

	private void analisarRbt() {
		if (rbtValidos.isSelected() && rbtLiberado.isSelected() && rbtLiberado1.isSelected()) {

			txtLimite.setEditable(true);
		}

	}

	private void anaslisarRbtNegativodo() {
		if (rbtInvalidos.isSelected() || rbtNegativado1.isSelected() || rbtNegativado.isSelected()) {
			txtLimite.setEditable(false);
		}
	}

	private void limparFormulario() {
		txtLimite.setText("");
		txtCPF.setText("");
		txtRenda.setText("");
		txtLimite.setToolTipText("");
	}
}
