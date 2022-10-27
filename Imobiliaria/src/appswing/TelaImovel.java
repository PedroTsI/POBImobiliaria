package appswing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import model.Imovel;
import model.Venda;
import regras_negocio.Fachada;

public class TelaImovel {
	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel labelrodape;
	private JLabel labelpesquisa;
	private JLabel labelnumero;
	private JLabel labelbairro;
	private JLabel labelendereco;
	private JLabel labelcomplemento;
	private JLabel labelestado;
	private JLabel labelcidade;
	private JTextField textpesquisa;
	private JTextField textnumero;
	private JTextField texttipopagamento;
	private JTextField textendereco;
	private JTextField textvalorpagamento;
	private JTextField textcorretor;
	private JTextField textcliente;
	private JButton buttonlistar;
	private JButton buttonregistrar;
	private JButton buttondeletar;
	private JButton buttonalterar;
	private JTextField texttipoimov;
	
	public TelaImovel() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Atendimentos");
		frame.setBounds(100, 100, 729, 385);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				listagem();
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 43, 674, 148);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		labelrodape = new JLabel("");
		labelrodape.setForeground(Color.BLUE);
		labelrodape.setBounds(21, 334, 688, 14);
		frame.getContentPane().add(labelrodape);

		labelpesquisa = new JLabel("Digite o id: ");
		labelpesquisa.setHorizontalAlignment(SwingConstants.LEFT);
		labelpesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelpesquisa.setBounds(21, 14, 58, 14);
		frame.getContentPane().add(labelpesquisa);

		textpesquisa = new JTextField();
		textpesquisa.setFont(new Font("Dialog", Font.PLAIN, 12));
		textpesquisa.setColumns(10);
		textpesquisa.setBackground(Color.WHITE);
		textpesquisa.setBounds(85, 11, 139, 20);
		frame.getContentPane().add(textpesquisa);
		
		labelendereco = new JLabel("Endereco:");
		labelendereco.setHorizontalAlignment(SwingConstants.LEFT);
		labelendereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelendereco.setBounds(21, 217, 58, 14);
		frame.getContentPane().add(labelendereco);

		textendereco = new JTextField();
		textendereco.setFont(new Font("Dialog", Font.PLAIN, 12));
		textendereco.setColumns(10);
		textendereco.setBounds(128, 214, 96, 20);
		frame.getContentPane().add(textendereco);

		labelnumero = new JLabel("Numero: ");
		labelnumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelnumero.setFont(new Font("Dialog", Font.PLAIN, 12));
		labelnumero.setBounds(21, 246, 50, 14);
		frame.getContentPane().add(labelnumero);
		
		textnumero = new JTextField();
		textnumero.setFont(new Font("Dialog", Font.PLAIN, 12));
		textnumero.setColumns(10);
		textnumero.setBounds(128, 243, 96, 20);
		frame.getContentPane().add(textnumero);
		
		labelbairro = new JLabel("Bairro:");
		labelbairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelbairro.setFont(new Font("Dialog", Font.PLAIN, 12));
		labelbairro.setBounds(256, 217, 42, 14);
		frame.getContentPane().add(labelbairro);
		
		texttipopagamento = new JTextField();
		texttipopagamento.setFont(new Font("Dialog", Font.PLAIN, 12));
		texttipopagamento.setColumns(10);
		texttipopagamento.setBounds(362, 217, 110, 20);
		frame.getContentPane().add(texttipopagamento);

		labelcomplemento = new JLabel("Complemento:");
		labelcomplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelcomplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelcomplemento.setBounds(21, 277, 83, 14);
		frame.getContentPane().add(labelcomplemento);

		textvalorpagamento = new JTextField();
		textvalorpagamento.setFont(new Font("Dialog", Font.PLAIN, 12));
		textvalorpagamento.setColumns(10);
		textvalorpagamento.setBounds(128, 274, 96, 20);
		frame.getContentPane().add(textvalorpagamento);
				
		labelestado = new JLabel("Estado:");
		labelestado.setHorizontalAlignment(SwingConstants.LEFT);
		labelestado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelestado.setBounds(256, 277, 50, 14);
		frame.getContentPane().add(labelestado);

		textcorretor = new JTextField();
		textcorretor.setFont(new Font("Dialog", Font.PLAIN, 12));
		textcorretor.setColumns(10);
		textcorretor.setBounds(362, 277, 110, 20);
		frame.getContentPane().add(textcorretor);

		labelcidade = new JLabel("Cidade:");
		labelcidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelcidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelcidade.setBounds(256, 246, 42, 14);
		frame.getContentPane().add(labelcidade);

		textcliente = new JTextField();
		textcliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		textcliente.setColumns(10);
		textcliente.setBounds(362, 246, 110, 20);
		frame.getContentPane().add(textcliente);

		buttonregistrar = new JButton("Criar");
		buttonregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textnumero.getText().isEmpty() ||
							texttipopagamento.getText().isEmpty() || 
							textendereco.getText().isEmpty() ||
							textvalorpagamento.getText().isEmpty())
					{
						labelrodape.setText("campo vazio");
						return;
					}

					String id = textendereco.getText();
					String tipo = textnumero.getText();
					String tipopagamento = texttipopagamento.getText();
					String valorpagamento = textvalorpagamento.getText();
					
					if (!textcorretor.getText().isEmpty() &&
						!textcliente.getText().isEmpty())
					{
						String corretor = textcorretor.getText();
						String cliente= textcliente.getText();
					}

					Venda v = Fachada.criarVenda(tipo, tipopagamento, Integer.parseInt(valorpagamento), Integer.parseInt(id));
					labelrodape.setText("Venda criada: " + v.getId());
					listagem();
				}
				catch(Exception ex) {
					labelrodape.setText(ex.getMessage());
				}
			}
		});
		buttonregistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonregistrar.setBounds(526, 277, 110, 23);
		frame.getContentPane().add(buttonregistrar);

		buttonlistar = new JButton("Listar");
		buttonlistar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonlistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listagem();
			}
		});
		buttonlistar.setBounds(234, 10, 89, 23);
		frame.getContentPane().add(buttonlistar);
		
		buttondeletar = new JButton("Deletar");
		buttondeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (table.getSelectedRow() >= 0){
						String id = (String) table.getValueAt( table.getSelectedRow(), 0);

						Object[] options = { "Confirmar", "Cancelar" };
						int escolha = JOptionPane.showOptionDialog(null, "Confirmar exclusão da venda "+id, "Alerta",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
						if(escolha == 0) {
							Fachada.apagarVenda(Integer.parseInt(id));
							labelrodape.setText("Venda foi excluida "+ id);
							listagem();
						}
						else
							labelrodape.setText("Venda nao foi excluida " +id );
					}
					else
						labelrodape.setText("selecione uma linha");
				}
				catch(Exception ex) {
					labelrodape.setText(ex.getMessage());
				}
			}
		});
		buttondeletar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttondeletar.setBounds(526, 217, 110, 23);
		frame.getContentPane().add(buttondeletar);
		
		buttonalterar = new JButton("Alterar");
		buttonalterar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				if (table.getSelectedRow() >= 0){
//		 			String protocolo = (String) table.getValueAt( table.getSelectedRow(), 1);
//		 			String novaData = JOptionPane.showInputDialog(frame,"Digite a nova data (dd/mm/aaaa)");
//		 			String novoMedicoCRM = JOptionPane.showInputDialog(frame,"Digite o CRM do novo Medico");
//		 			String novoDiagnostico = JOptionPane.showInputDialog(frame,"Digite o novo diagnostico");
//		 			String novoReceituario = JOptionPane.showInputDialog(frame,"Digite o novo receituario");
//		 			String novoProcedimento = JOptionPane.showInputDialog(frame,"Digite o novo procedimento");
//		 			String procedimentoRemover = JOptionPane.showInputDialog(frame,"Digite o procedimento a remover");
//						
//		 			if (!novaData.equals("")) {
//		 				Fachada.alterarDataAtendimento(protocolo, novaData);
//		 			}
//		 			if (!novoMedicoCRM.equals("")) {
//		 				Medico m = Fachada.consultarMedico(novoMedicoCRM);
//		 				Fachada.alterarMedicoAtendimento(protocolo, m);
//		 			}
//	 				if (!novoDiagnostico.equals("")) {
//	 					Fachada.alterarDiagnostico(protocolo, novoDiagnostico);
//	 				}
//	 				if (!novoReceituario.equals("")) {
//	 					Fachada.alterarReceituario(protocolo, novoReceituario);
//	 				}
//	 				if (!novoProcedimento.equals("")) {
//	 					Fachada.adicionarProcedimento(protocolo, novoProcedimento);
//	 				}
//	 				if (!procedimentoRemover.equals("")) {
//	 					Fachada.removerProcedimento(protocolo, procedimentoRemover);
//	 				}
//
//	 				labelrodape.setText("Atendimento atualizado : "+protocolo);
	 				listagem();
		 			}
		 			else
		 				labelrodape.setText("selecione uma linha");
		 		}
		 		catch(Exception erro) {
		 			labelrodape.setText(erro.getMessage());
		 		}
		 	}
		 });
		 buttonalterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 buttonalterar.setBounds(526, 246, 110, 23);
		 frame.getContentPane().add(buttonalterar);
		 
		 JLabel labeltipoimov = new JLabel("Tipo Imovel:");
		 labeltipoimov.setHorizontalAlignment(SwingConstants.LEFT);
		 labeltipoimov.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 labeltipoimov.setBounds(21, 304, 83, 14);
		 frame.getContentPane().add(labeltipoimov);
		 
		 texttipoimov = new JTextField();
		 texttipoimov.setFont(new Font("Dialog", Font.PLAIN, 12));
		 texttipoimov.setColumns(10);
		 texttipoimov.setBounds(128, 301, 96, 20);
		 frame.getContentPane().add(texttipoimov);
	}

	public void listagem() {
		try{
			List<Imovel> lista = Fachada.listarImovel();
	
			//model contem todas as linhas e colunas da tabela
			DefaultTableModel model = new DefaultTableModel();

			//colunas
			model.addColumn("id");
			model.addColumn("endereco");
			model.addColumn("numero");
			model.addColumn("bairro");
			model.addColumn("cidade");
			model.addColumn("estado");
			model.addColumn("tipo imovel");
			model.addColumn("proprietario");
			model.addColumn("corretor");

			//linhas
			String idpesquisa = this.textpesquisa.getText();
			if (idpesquisa == null) {
				for(Imovel i : lista) {
					model.addRow(new Object[]{i.getId()+"", i.getEndereco(), i.getNumero(), i.getBairro(), i.getCidade(), i.getEstado(), i.getTipoimov(), i.getProprietarios().get(0), i.getCorretor().getNome()});
				}
			}
			else {
				for(Imovel i : lista) {
					if (String.valueOf(i.getId()).contains(idpesquisa)) {
						model.addRow(new Object[]{i.getId()+"", i.getEndereco(), i.getNumero(), i.getBairro(), i.getCidade(), i.getEstado(), i.getTipoimov(), i.getProprietarios().get(0), i.getCorretor().getNome()});
					}
				}
			}
				
			table.setModel(model);
			labelrodape.setText("resultados: "+lista.size()+ " vendas - selecione uma linha");
		}
		catch(Exception erro){
			labelrodape.setText(erro.getMessage());
		}
		}
}
