package daodb4o;


import java.util.ArrayList;
import java.util.List;

import com.db4o.query.Query;

import model.Corretor;

public class DAOCorretor  extends DAO<Corretor>{

	public Corretor read (Object chave) {
		int creci = (Integer) chave;	
		Query q = manager.query();
		q.constrain(Corretor.class);
		q.descend("creci").constrain(creci);
		List<Corretor> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public void create(Corretor obj){
		int novoCreci = super.gerarId();  	//gerar novo id da classe
		obj.setCreci(novoCreci);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( obj );
	}
	
	public List<String> consultarVendasCorretor() {
		Query q = manager.query();
		q.constrain(Corretor.class);
		q.descend("qntdVendas").constrain(3).smaller().not();
		
		List<Corretor> corretores = q.execute();
		List<String> nomes = new ArrayList<>();
		
		for (Corretor c : corretores)
			nomes.add(c.getNome());

		// return q.execute().size();
		return nomes;
	}
}



