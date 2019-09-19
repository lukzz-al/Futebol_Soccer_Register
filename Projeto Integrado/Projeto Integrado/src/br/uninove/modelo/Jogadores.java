package br.uninove.modelo;

import java.util.Date;

public class Jogadores {
	
	private String nome;
	private String rg;
	private int idade;
	private double tamanho;
	private double peso;
	private Date nascimento;
	
	
	private Time times;
	
	
	
	
	public Jogadores(String nome, String rg, int idade, double tamanho, double peso, Date nascimento, Time times) {
		this.nome = nome;
		this.rg = rg;
		this.idade = idade;
		this.tamanho = tamanho;
		this.peso = peso;
		this.nascimento = nascimento;
		this.times = times;
		
	}
	
	public Jogadores() {
		
	}
	
	
	
	
	public Time getTimes() {
		return times;
	}

	public void setTimes(Time times) {
		this.times = times;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	

}
