package br.org.catolicasc.algorithm;

import java.util.List;

import br.org.catolicasc.model.Bloco;
import br.org.catolicasc.model.Processo;
 
public class NextFit {
	
	public NextFit(List<Bloco> blocos, List<Processo> processos) {
		
		int numeroLastIndice = 0;
		
		for (Processo processo : processos) {
			
			for (int i = numeroLastIndice; i < blocos.size(); i++) {

				if ((blocos.get(i).getTamanho() > processo.getTamanho()) && (blocos.get(i).getLivre())) {

					System.out.println("Alocado processo " + processo.getId() + "(" + processo.getTamanho() + "k) " 
							+ " para o bloco " + blocos.get(i).getId() + "(" + blocos.get(i).getTamanho() + "k)");
					
					blocos.get(i).setTamanho(blocos.get(i).getTamanho() - processo.getTamanho());
					blocos.get(i).setLivre(false);
					numeroLastIndice = i;
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
