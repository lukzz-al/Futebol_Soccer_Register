package br.uninove.modelo;


public class Time {

	private String nm_time;
	private char posicao;
	private double salario;
	private int camisa;
	private double contrato;
	
	
	

	public double getContrato() {
		return contrato;
	}
	public void setContrato(double contrato) {
		this.contrato = contrato;
	}
	public String getNm_time() {
		return nm_time;
	}
	public void setNm_time(String nm_time) {
		this.nm_time = nm_time;
	}
	public char getPosicao() {
		return posicao;
	}
	public void setPosicao(char posicao) {
		this.posicao = posicao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getCamisa() {
		return camisa;
	}
	public void setCamisa(int camisa) {
		this.camisa = camisa;
	}
	
	
}
