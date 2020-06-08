package br.com.porkrinho.controller.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.controller.Logica;

@WebServlet("/Usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String parametro = request.getParameter("logica");
	        String nomeDaClasse = "br.com.controller." + parametro;

	        try {
	            Class classe = Class.forName(nomeDaClasse);

	            Logica logica = (Logica) classe.newInstance();
	            String pagina = logica.executa(request, response);

	            request.getRequestDispatcher(pagina).forward(request, response);

	        } catch (Exception e) { 
	            throw new ServletException("A lógica de negócios causou uma exceção", e);
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
