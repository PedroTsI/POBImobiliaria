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

import modelo.Venda;
import regras_negocio.Fachada;

public class TelaVendas {
	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel labelrodape;
	private JLabel labelpesquisa;
	private JLabel labeltipo;
	private JLabel labeltipopagamento;
	private JLabel labelid;
	private JLabel labelvalorpagamento;
	private JLabel labelcorretor;
	private JLabel labelcliente;
	private JTextField textpesquisa;
	private JTextField texttipo;
	private JTextField texttipopagamento;
	private JTextField textid;
	private JTextField textvalorpagamento;
	private JTextField textcorretor;
	private JTextField textcliente;
	private JButton buttonlistar;
	private JButton buttonregistrar;
	private JButton buttondeletar;
	private JButton buttonalterar;
	
	public TelaAtendimento() {
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
		labelrodape.setBounds(21, 321, 688, 14);
		frame.getContentPane().add(labelrodape);

		labelpesquisa = new JLabel("Digite o id: ");
		labelpesquisa.setHorizontalAlignment(SwingConstants.LEFT);
		labelpesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelpesquisa.setBounds(21, 14, 128, 14);
		frame.getContentPane().add(labelpesquisa);

		textpesquisa = new JTextField();
		textpesquisa.setFont(new Font("Dialog", Font.PLAIN, 12));
		textpesquisa.setColumns(10);
		textpesquisa.setBackground(Color.WHITE);
		textpesquisa.setBounds(128, 11, 139, 20);
		frame.getContentPane().add(textpesquisa);
		
		labelid = new JLabel("Id: ");
		labelid.setHorizontalAlignment(SwingConstants.LEFT);
		labelid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelid.setBounds(21, 269, 71, 14);
		frame.getContentPane().add(labelid);

		textid = new JTextField();
		textid.setFont(new Font("Dialog", Font.PLAIN, 12));
		textid.setColumns(10);
		textid.setBounds(82, 269, 42, 20);
		frame.getContentPane().add(textid);

		labeltipo = new JLabel("Tipo: ");
		labeltipo.setHorizontalAlignment(SwingConstants.LEFT);
		labeltipo.setFont(new Font("Dialog", Font.PLAIN, 12));
		labeltipo.setBounds(150, 269, 71, 14);
		frame.getContentPane().add(labeltipo);
		
		texttipo = new JTextField();
		texttipo.setFont(new Font("Dialog", Font.PLAIN, 12));
		texttipo.setColumns(10);
		texttipo.setBounds(190, 269, 80, 20);
		frame.getContentPane().add(texttipo);
		
		labeltipopagamento = new JLabel("Tipo Pagamento: ");
		labeltipopagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labeltipopagamento.setFont(new Font("Dialog", Font.PLAIN, 12));
		labeltipopagamento.setBounds(150, 269, 71, 14);
		frame.getContentPane().add(labeltipopagamento);
		
		texttipopagamento = new JTextField();
		texttipopagamento.setFont(new Font("Dialog", Font.PLAIN, 12));
		texttipopagamento.setColumns(10);
		texttipopagamento.setBounds(190, 269, 80, 20);
		frame.getContentPane().add(texttipopagamento);

		labelvalorpagamento = new JLabel("Valor Pagamento: ");
		labelvalorpagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelvalorpagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelvalorpagamento.setBounds(21, 293, 95, 14);
		frame.getContentPane().add(labelvalorpagamento);

		textvalorpagamento = new JTextField();
		textvalorpagamento.setFont(new Font("Dialog", Font.PLAIN, 12));
		textvalorpagamento.setColumns(10);
		textvalorpagamento.setBounds(110, 290, 96, 20);
		frame.getContentPane().add(textvalorpagamento);
				
		labelcorretor = new JLabel("Corretor: ");
		labelcorretor.setHorizontalAlignment(SwingConstants.LEFT);
		labelcorretor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelcorretor.setBounds(252, 295, 119, 14);
		frame.getContentPane().add(labelcorretor);

		textcorretor = new JTextField();
		textcorretor.setFont(new Font("Dialog", Font.PLAIN, 12));
		textcorretor.setColumns(10);
		textcorretor.setBounds(342, 290, 110, 20);
		frame.getContentPane().add(textcorretor);

		labelcliente = new JLabel("Cliente: ");
		labelcliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelcliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelcliente.setBounds(252, 295, 119, 14);
		frame.getContentPane().add(labelcliente);

		textcliente = new JTextField();
		textcliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		textcliente.setColumns(10);
		textcliente.setBounds(342, 290, 110, 20);
		frame.getContentPane().add(textcliente);

		buttonregistrar = new JButton("Criar");
		buttonregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(texttipo.getText().isEmpty() ||
							texttipopagamento.getText().isEmpty() || 
							textid.getText().isEmpty() ||
							textvalorpagamento.getText().isEmpty())
					{
						labelrodape.setText("campo vazio");
						return;
					}

					String id = textid.getText();
					String tipo = texttipo.getText();
					int tipopagamento = Integer.parseInt(texttipopagamento.getText());
					String valorpagamento = textvalorpagamento.getText();
					String corretor = textcorretor.getText();
					
					if (!textcorretor.getText().isEmpty() &&
						!textcliente.getText().isEmpty())
					{
						String corretor = textcorretor.getText();
						String cliente = textcliente.getText();
					}

					Venda v = Fachada.criarVenda(tipo, tipopagamento, valorpagamento, id);
					labelrodape.setText("Venda criada: " + v.getId());
					listagem();
				}
				catch(Exception ex) {
					labelrodape.setText(ex.getMessage());
				}
			}
		});
		buttonregistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonregistrar.setBounds(535, 273, 86, 23);
		frame.getContentPane().add(buttonregistrar);

		buttonlistar = new JButton("Listar");
		buttonlistar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonlistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listagem();
			}
		});
		buttonlistar.setBounds(306, 9, 89, 23);
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
		buttondeletar.setBounds(400, 213, 110, 23);
		frame.getContentPane().add(buttondeletar);
		
		// buttonalterar = new JButton("Alterar");
		// buttonalterar.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		try {
		// 			if (table.getSelectedRow() >= 0){
		// 				String protocolo = (String) table.getValueAt( table.getSelectedRow(), 1);
		// 				String novaData = JOptionPane.showInputDialog(frame,"Digite a nova data (dd/mm/aaaa)");
		// 				String novoMedicoCRM = JOptionPane.showInputDialog(frame,"Digite o CRM do novo Medico");
		// 				String novoDiagnostico = JOptionPane.showInputDialog(frame,"Digite o novo diagnostico");
		// 				String novoReceituario = JOptionPane.showInputDialog(frame,"Digite o novo receituario");
		// 				String novoProcedimento = JOptionPane.showInputDialog(frame,"Digite o novo procedimento");
		// 				String procedimentoRemover = JOptionPane.showInputDialog(frame,"Digite o procedimento a remover");
						
		// 				if (!novaData.equals("")) {
		// 					Fachada.alterarDataAtendimento(protocolo, novaData);
		// 				}
		// 				if (!novoMedicoCRM.equals("")) {
		// 					Medico m = Fachada.consultarMedico(novoMedicoCRM);
		// 					Fachada.alterarMedicoAtendimento(protocolo, m);
		// 				}
		// 				if (!novoDiagnostico.equals("")) {
		// 					Fachada.alterarDiagnostico(protocolo, novoDiagnostico);
		// 				}
		// 				if (!novoReceituario.equals("")) {
		// 					Fachada.alterarReceituario(protocolo, novoReceituario);
		// 				}
		// 				if (!novoProcedimento.equals("")) {
		// 					Fachada.adicionarProcedimento(protocolo, novoProcedimento);
		// 				}
		// 				if (!procedimentoRemover.equals("")) {
		// 					Fachada.removerProcedimento(protocolo, procedimentoRemover);
		// 				}

		// 				labelrodape.setText("Atendimento atualizado : "+protocolo);
		// 				listagem();
		// 			}
		// 			else
		// 				labelrodape.setText("selecione uma linha");
		// 		}
		// 		catch(Exception erro) {
		// 			labelrodape.setText(erro.getMessage());
		// 		}
		// 	}
		// });
		// buttonalterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		// buttonalterar.setBounds(520, 213, 110, 23);
		// frame.getContentPane().add(buttonalterar);
	}

	public void listagem() {
		try{
			List<Atendimento> lista = Fachada.listarVenda();
	
			//model contem todas as linhas e colunas da tabela
			DefaultTableModel model = new DefaultTableModel();

			//colunas
			model.addColumn("id");
			model.addColumn("tipo");
			model.addColumn("tipopagamento");
			model.addColumn("valorpagamento");
			model.addColumn("corretor");
			model.addColumn("cliente");

			//linhas
			String idpesquisa = this.textpesquisa.getText();
			if (idpesquisa == null) {
				for(Venda v : lista) {
					model.addRow(new Object[]{v.getId()+"", v.getTipo(), v.tipo, v.tipopagamento, v.valorpagamento, v.getCorretor().getNome(), v.getCliente().getNome()});
				}
			}
			else {
				for(Venda a : lista) {
					if (v.getId().contains(idpesquisa)) {
						model.addRow(new Object[]{v.getId()+"", v.getTipo(), v.tipo, v.tipopagamento, v.valorpagamento, v.getCorretor().getNome(), v.getCliente().getNome()});
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
