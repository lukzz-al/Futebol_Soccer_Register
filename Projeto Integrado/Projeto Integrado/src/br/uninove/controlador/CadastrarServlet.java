package br.uninove.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.modelo.Jogadores;
import br.uninove.modelo.JogadoresDao;
import br.uninove.modelo.Time;


@WebServlet("/cadastrar.do")
public class CadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nome = request.getParameter("txtnome");
		int idade = Integer.parseInt(request.getParameter("txtidade"));
		String time = request.getParameter("txttime");
		double tamanho = Double.parseDouble(request.getParameter("txttamanho"));
		String rg = request.getParameter("txtrg");
		double peso = Double.parseDouble(request.getParameter("txtpeso"));
		char posicao = request.getParameter("txtposicao").charAt(0);
		double salario = Double.parseDouble(request.getParameter("txtsalario"));
		int camisa = Integer.parseInt(request.getParameter("txtcamisa"));
		int tempo_contrato = Integer.parseInt(request.getParameter("tempocontrato"));
		
		
		
			Time times = new Time();
			times.setCamisa(camisa);
			times.setContrato(salario*tempo_contrato);
			times.setNm_time(time);
			times.setPosicao(posicao);
			times.setSalario(salario);
			
			Jogadores jogador = new Jogadores();
			jogador.setNome(nome);
			jogador.setIdade(idade);
			jogador.setPeso(peso);
			jogador.setRg(rg);
			jogador.setTamanho(tamanho);
			jogador.setTimes(times);
			
			
			JogadoresDao.cadastrar(jogador);
	
		
		
		/*
		System.out.println("Nome: "+ jogador.getNome());
		System.out.println("Time: " + times.getNm_time());
		System.out.println("Idade: " + jogador.getIdade());
		System.out.println("Peso: " + jogador.getPeso());
		System.out.println("RG:" + jogador.getRg());
		System.out.println("Tamanho: " + jogador.getTamanho());
		System.out.println("Camisa: " + times.getCamisa());
		System.out.println("Salario: " + times.getSalario());
		System.out.println("Posicao: " + times.getPosicao());
		System.out.println("Contrato: "+ times.getContrato());
		*/
		
		
		
		
		
		
		
		response.sendRedirect("http://localhost:8080/Projeto_Integrado/mostrartodos.do");
		
	}

}
