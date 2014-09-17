package br.org.catolicasc.algorithm;

import java.util.List;

import br.org.catolicasc.model.Bloco;
import br.org.catolicasc.model.Processo;
 
public class NextFit {
	
	public NextFit(List<Bloco> blocos, List<Processo> processos) {
				
		for (Processo processo : processos) {
			
			for (int numeroLastIndice = 0; numeroLastIndice < blocos.size(); numeroLastIndice++) {

				if ((blocos.get(numeroLastIndice).getTamanho() >= processo.getTamanho()) && (blocos.get(numeroLastIndice).getLivre())) {

					System.out.println("Alocado processo " + processo.getId() + "(" + processo.getTamanho() + "k) " 
							+ " para o bloco " + blocos.get(numeroLastIndice).getId() + "(" + blocos.get(numeroLastIndice).getTamanho() + "k)");
					
					blocos.get(numeroLastIndice).setTamanho(blocos.get(numeroLastIndice).getTamanho() - processo.getTamanho());
					blocos.get(numeroLastIndice).setLivre(false);
					
					break;
				} else {
					
					System.out.println("Não há mais memória suficiente ou o bloco ja esta ocupado por outro processo.");
					System.out.println("Processo: " + processo.getId() + " Tamanho: " + processo.getTamanho());
					System.out.println("Bloco: " + blocos.get(numeroLastIndice).getId() + " Tamanho: " + blocos.get(numeroLastIndice).getTamanho());					
				}
			}
		}
	}
}
