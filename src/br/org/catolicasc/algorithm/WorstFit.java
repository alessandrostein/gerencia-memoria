package br.org.catolicasc.algorithm;

import java.util.List;

import br.org.catolicasc.model.Bloco;
import br.org.catolicasc.model.Processo;

// Aloca o maior valor;
public class WorstFit {

	public WorstFit(List<Bloco> blocos, List<Processo> processos) {
		
		int indexMaiorBloco = 0;
		for (Processo processo : processos) {
			System.out.println("Processo " + processo.getId() + " com tamanho de " + processo.getTamanho());

			for (Bloco bloco : blocos) {
				if ((bloco.getTamanho() > blocos.get(indexMaiorBloco)
						.getTamanho())) {
					indexMaiorBloco = bloco.getId();
					System.out.println("Maior bloco é o " + bloco.getId()
							+ " com o tamanho de " + bloco.getTamanho());
				}
			}

			if ((blocos.get(indexMaiorBloco).getTamanho() >= processo
					.getTamanho()) && (blocos.get(indexMaiorBloco).getLivre())) {

				System.out.println("Alocado processo " + processo.getId() + "("
						+ processo.getTamanho() + "k) " + " para o bloco "
						+ blocos.get(indexMaiorBloco).getId() + "("
						+ blocos.get(indexMaiorBloco).getTamanho() + "k)");

				blocos.get(indexMaiorBloco).setTamanho(
						blocos.get(indexMaiorBloco).getTamanho()
								- processo.getTamanho());
				blocos.get(indexMaiorBloco).setLivre(false);

			} else {

				System.out.println("Não há mais memória suficiente ou ja esta ocupada.");
				System.out.println("Processo: " + processo.getId()
						+ " Tamanho: " + processo.getTamanho());
				System.out.println("Bloco: "
						+ blocos.get(indexMaiorBloco).getId() + " Tamanho: "
						+ blocos.get(indexMaiorBloco).getTamanho());
			}
		}
	}
}
