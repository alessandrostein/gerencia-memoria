package br.org.catolicasc.dao;
import java.util.ArrayList;
import java.util.List;

import br.org.catolicasc.model.Bloco;

public class BlocoDao {
	
	static List<Bloco> blocos = new ArrayList<Bloco>();
	
	public List<Bloco> obterBlocos() {
		return blocos;
	}
	
	public void criarBloco(Bloco bloco){
		blocos.add(bloco);
	}

}
