package br.uninove.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.modelo.Jogadores;
import br.uninove.modelo.JogadoresDao;

@WebServlet("/mostrartodos.do")
public class MostrarTodosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Jogadores> jog_list = JogadoresDao.mostrarTodos();
		request.setAttribute("lista_de_jogadores", jog_list);
		request.getRequestDispatcher("lista_de_jogadores.jsp").forward(request, response);
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
