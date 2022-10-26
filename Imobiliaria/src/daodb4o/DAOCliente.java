package daodb4o;


import java.util.ArrayList;
import java.util.List;

import com.db4o.query.Query;

import model.Cliente;
import model.Corretor;

public class DAOCliente  extends DAO<Cliente>{

	public Cliente read (Object chave) {
		int id = (Integer) chave;	
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("idCliente").constrain(id);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public void create(Cliente obj){
		int novoId = super.gerarId();  	//gerar novo id da classe
		obj.setId(novoId);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( obj );
	}
	public List<String> consultarRendaMaior() {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("renda").constrain(1000).greater();

		List<Cliente> clientes = q.execute();
		List<String> nomes = new ArrayList<>();
		
		for (Cliente c : clientes)
			nomes.add(c.getNome());

		// return q.execute().size();
		return nomes;
	}
	public List<Cliente> readAll(String nome){
		manager.ext().purge();  	//limpar cache do manager
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("nome").constrain(nome);	//nome like texto
		return q.execute();
	}
}



