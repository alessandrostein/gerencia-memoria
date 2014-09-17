package br.org.catolicasc.algorithm;

import java.util.List;

import br.org.catolicasc.model.Bloco;
import br.org.catolicasc.model.Processo;

public class BestFit {

	public BestFit(List<Bloco> blocos, List<Processo> processos) {

		int indexMenorBloco = 0;
		boolean first;
		for (Processo processo : processos) {
			System.out.println("Processo " + processo.getId()
					+ " com tamanho de " + processo.getTamanho());

			first = true;
			for (Bloco bloco : blocos) {

				if (bloco.getLivre()) {

					if (first) {
						indexMenorBloco = bloco.getId();
						first = false;
					}

					if (bloco.getTamanho() <= blocos.get(indexMenorBloco)
							.getTamanho()) {
						indexMenorBloco = bloco.getId();
					}
				}

			}

			if ((blocos.get(indexMenorBloco).getTamanho() >= processo
					.getTamanho()) && (blocos.get(indexMenorBloco).getLivre())) {

				System.out.println("Alocado processo " + processo.getId() + "("
						+ processo.getTamanho() + "k) " + " para o bloco "
						+ blocos.get(indexMenorBloco).getId() + "("
						+ blocos.get(indexMenorBloco).getTamanho() + "k)");

				blocos.get(indexMenorBloco).setTamanho(
						blocos.get(indexMenorBloco).getTamanho()
								- processo.getTamanho());
				blocos.get(indexMenorBloco).setLivre(false);

			} else {

				System.out
						.println("Não há mais memória suficiente ou ja esta ocupada.");
				System.out.println("Processo: " + processo.getId()
						+ " Tamanho: " + processo.getTamanho());
				System.out.println("Bloco: "
						+ blocos.get(indexMenorBloco).getId() + " Tamanho: "
						+ blocos.get(indexMenorBloco).getTamanho());
			}
		}
	}

}
