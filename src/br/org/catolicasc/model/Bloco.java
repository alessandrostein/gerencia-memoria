package br.org.catolicasc.model;

public class Bloco {

	private int id;
	private int tamanho;	
	
	
	public Bloco() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bloco(int id, int tamanho) {
		super();
		this.id = id;
		this.tamanho = tamanho;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}	

}
