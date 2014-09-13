package br.org.catolicasc.dao;
import java.util.ArrayList;
import java.util.List;

import br.org.catolicasc.model.Processo;

public class ProcessoDao {

	static List<Processo> processos = new ArrayList<Processo>();
	
	public List<Processo> obterProcessos() {
		return processos;
	}
	
	public void criarProcesso(Processo processo){
		processos.add(processo);
	}
	
}
