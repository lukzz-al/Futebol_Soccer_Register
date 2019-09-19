package br.uninove.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.modelo.JogadoresDao;

@WebServlet("/removerjogador.do")
public class RemoverJogadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String rg = request.getParameter("rg");
		
		JogadoresDao.Remover(rg);
		
		response.sendRedirect("http://localhost:8080/Projeto_Integrado/mostrartodos.do");
		
	}

}
