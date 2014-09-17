package br.org.catolicasc.algorithm;

import java.util.List;

import br.org.catolicasc.model.Bloco;
import br.org.catolicasc.model.Processo;

public class FirstFit {

	public FirstFit(List<Bloco> blocos, List<Processo> processos) {
		for (Processo processo : processos) {

			for (Bloco bloco : blocos) {

				if ((bloco.getTamanho() >= processo.getTamanho()) && (bloco.getLivre())) {

					System.out.println("Alocado processo " + processo.getId() + "(" + processo.getTamanho() + "k) " 
							+ " para o bloco " + bloco.getId() + "(" + bloco.getTamanho() + "k)");
					
					bloco.setTamanho(bloco.getTamanho() - processo.getTamanho());
					bloco.setLivre(false);
					
					break;
				} else {
					
					System.out.println("Não há mais memória suficiente ou o bloco ja esta ocupado por outro processo.");
					System.out.println("Processo: " + processo.getId() + " Tamanho: " + processo.getTamanho());
					System.out.println("Bloco: " + bloco.getId() + " Tamanho: " + bloco.getTamanho());					
				}
			}
		}
	}
}
 