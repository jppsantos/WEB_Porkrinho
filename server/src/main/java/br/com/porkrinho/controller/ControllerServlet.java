package br.com.porkrinho.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String parametro = request.getParameter("logica");
	        String nomeDaClasse = "br.com.controller." + parametro;

	        try {
	            Class classe = Class.forName(nomeDaClasse);

	            Logica logica = (Logica) classe.getConstructor().newInstance();
	            String pagina = logica.executa(request, response);

	            request.getRequestDispatcher(pagina).forward(request, response);

	        } catch (Exception e) { 
	            throw new ServletException("A lógica de negócios causou uma exceção", e);
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}