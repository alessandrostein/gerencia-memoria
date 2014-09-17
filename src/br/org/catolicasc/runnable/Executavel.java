package br.org.catolicasc.runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.org.catolicasc.algorithm.WorstFit;
import br.org.catolicasc.dao.BlocoDao;
import br.org.catolicasc.dao.ProcessoDao;
import br.org.catolicasc.model.Bloco;
import br.org.catolicasc.model.Processo;

public class Executavel {

	Scanner input = new Scanner(System.in);

	private int numProcessos;
	private int numBlocos;

	private static List<Bloco> blocos = new ArrayList<Bloco>();
	private static List<Processo> processos = new ArrayList<Processo>();

	public void menuProcesso() {
		System.out.println("Informe o número de processos:");
		numProcessos = input.nextInt();
	}

	public void menuBloco() {
		System.out.println("Informe o número de blocos:");
		numBlocos = input.nextInt();
	}

	public int getProcessoTamanho(Processo processo) {
		int tamProcesso = 0;
		System.out.println("Informe o tamanho do processo " + processo.getId()
				+ ':');
		tamProcesso = input.nextInt();
		return tamProcesso;
	}

	public int getBlocoTamanho(Bloco bloco) {
		int tamBloco = 0;
		System.out.println("Informe o tamanho do bloco de memoria "
				+ bloco.getId() + ':');
		tamBloco = input.nextInt();
		return tamBloco;
	}

	public void createProcessos(int numero) {
		for (int i = 0; i < numero; i++) {

			Processo processo = new Processo();
			processo.setId(i);
			processo.setTamanho(getProcessoTamanho(processo));

			ProcessoDao processoDao = new ProcessoDao();
			processoDao.criarProcesso(processo);

		}
	}

	
	public void obterBlocos() {
		BlocoDao blocoDao = new BlocoDao();
		blocos = blocoDao.obterBlocos();
	}

	public void obterProcessos() {
		ProcessoDao processoDao = new ProcessoDao();
		processos = processoDao.obterProcessos();
	}

	public void createBlocos(int numero) {
		for (int i = 0; i < numero; i++) {

			Bloco bloco = new Bloco();
			bloco.setId(i);
			bloco.setTamanho(getBlocoTamanho(bloco));
			bloco.setLivre(true);
					
			BlocoDao blocoDao = new BlocoDao();
			blocoDao.criarBloco(bloco);

		}
	}

	public void run() {

		menuBloco();
		menuProcesso();

		createBlocos(numBlocos);
		createProcessos(numProcessos);
		
		obterBlocos();
		obterProcessos();

	}

	public static void main(String args[]) {
		
		Executavel exec = new Executavel();
		exec.run();
		
		//System.out.println("First Fit");
		//FirstFit firstFit = new FirstFit(exec.blocos, exec.processos);
		//System.out.println("");
		
		System.out.println("Worst Fit");
		WorstFit worstFit = new WorstFit(blocos, processos);
		System.out.println("");
		
		//System.out.println("Next Fit");
		//NextFit nextfit = new NextFit(blocos, processos);
		//System.out.println("");
		
		//System.out.println("Best Fit");
		//BestFit bestfit = new BestFit(blocos, processos);
		//System.out.println("");
		
		

	}

}
