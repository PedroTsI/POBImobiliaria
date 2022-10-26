package model;
import java.util.ArrayList;
import java.util.List;


public class Venda {
	public String tipo;
	public String tipopagamento;
	public int valorpagamento;
	private int idVenda;
	// private ArrayList<Pessoa> pessoas = new ArrayList<>();
	// private ArrayList<Cliente> clientes = new ArrayList<>();
	private Corretor corretor;
	private Cliente cliente;
	private Imovel imovel;

	public Venda(String tipo, String tipopagamento, int valorpagamento, int id) {
		this.tipo = tipo;
		this.tipopagamento = tipopagamento;
		this.valorpagamento = valorpagamento;
		this.idVenda = id;
	}

	public Venda(String tipo, String tipopagamento, int valorpagamento, int id, Corretor corretor, Cliente cliente, Imovel imovel) {
		this.tipo = tipo;
		this.tipopagamento = tipopagamento;
		this.valorpagamento = valorpagamento;
		this.idVenda = id;
		this.cliente = cliente;
		this.corretor = corretor;
		this.imovel = imovel;
	}
	public void setId(int id) {
		this.idVenda = id;
	}
	public int getId() {
		return idVenda;
	}
	public void setPreco(int novoValor) {
		this.valorpagamento = novoValor;
	}
	public int getPreco() {
		return valorpagamento;
	}
	public Corretor getCorretor() {
		return this.corretor;
	}
	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Imovel getImovel() {
		return this.imovel;
	}
	public void setImove(Imovel imovel) {
		this.imovel = imovel;
	}
}
