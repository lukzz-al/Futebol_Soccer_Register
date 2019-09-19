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

@WebServlet("/alterarjogador.do")
public class AlterarJogadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rg =  request.getParameter("rg");
		
		Jogadores jog = JogadoresDao.buscarRg(rg);
		
		request.setAttribute("jogadorlocalizado", jog);
		request.getRequestDispatcher("alterarjogador.jsp").forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
		times.setNm_time(time);
		times.setPosicao(posicao);
		times.setSalario(salario);
		times.setContrato(salario*tempo_contrato);
		
		Jogadores jog = new Jogadores();
		jog.setNome(nome);
		jog.setIdade(idade);
		jog.setPeso(peso);
		jog.setRg(rg);
		jog.setTamanho(tamanho);
		jog.setTimes(times);
		
		JogadoresDao.Alterar(jog);
		
		response.sendRedirect("http://localhost:8080/Projeto_Integrado/mostrartodos.do");
	}

}
