package br.org.catolicasc.model;

public class Bloco {

	private int id;
	private int tamanho;	
	private boolean livre;
	
	public Bloco() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bloco(int id, int tamanho, boolean livre) {
		super();
		this.id = id;
		this.tamanho = tamanho;
		this.livre = livre;
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
	public boolean getLivre(){
		return livre;
	}
	public void setLivre(boolean livre){
		this.livre = livre;
	}

}
