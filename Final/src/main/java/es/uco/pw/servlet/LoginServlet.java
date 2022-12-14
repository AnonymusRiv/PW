package es.uco.pw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import es.uco.pw.business.managers.GestorUsuarios;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.display.javabean.CustomerBean;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Inicia sesión con los datos de un formulario
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return none
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    HttpSession session = request.getSession(true);
	    CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");

	    if (gestorUsuarios.loginUser(email, password)) {
	      UsuarioDTO usuario = gestorUsuarios.findUser(email);
	      if (customerBean == null) {
	        customerBean = new CustomerBean();
	      }

	      customerBean.setEmailUser(email);
	      customerBean.setTypeUser(usuario.getType());

	      session.setAttribute("customerBean", customerBean);

	      if (usuario.getType().equals("cliente")) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userHome.jsp");
	        dispatcher.include(request, response);
	      } else {RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/adminHome.jsp");
	        dispatcher.include(request, response);
	      }

	    } else {
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userNotFound.html");
	      dispatcher.include(request, response);
	    }
	}

}
