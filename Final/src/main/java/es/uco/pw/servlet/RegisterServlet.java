package es.uco.pw.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.managers.GestorUsuarios;
import es.uco.pw.display.javabean.CustomerBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Añadir un usuario al sistema
	 * @param HttpServletRequest request
	 * @param HttpServlet Response response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
	    String type = request.getParameter("type");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String birthday = request.getParameter("dateOfBirth");

		 HttpSession session = request.getSession(true);
		CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
		if (!gestorUsuarios.loginUser(email, password)) {
			UsuarioDTO user = new UsuarioDTO();
		    user.setName(name);
		    user.setPassword(password);
		    user.setEmail(email);
		    user.setDateOfBirth(birthday);
		    java.util.Date now = new java.util.Date();
		    user.setInscription(now);
		    if(type.equals("administrador")) {
		    	user.setType(UsuarioDTO.type.administrador);
		    }
		    else {
		    	user.setType(UsuarioDTO.type.cliente);
		    }
		    
		    try {
				if (gestorUsuarios.registerUser(user)) {
					if (customerBean == null || customerBean.getEmailUser().equals("")) {
						customerBean = new CustomerBean();
						customerBean.setEmailUser(email);
						customerBean.setTypeUser(user.getType());

						session.setAttribute("customerBean", customerBean);
				    	}

				    if (user.getType().equals(UsuarioDTO.type.cliente)) {
				      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userHome.jsp");
				      dispatcher.include(request, response);
				    } else {RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/adminHome.jsp");
				      dispatcher.include(request, response);
				    }
				  } else {
				    RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userAlreadyRegistered.html");
				    dispatcher.include(request, response);
				  }
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    } else {
		      RequestDispatcher dispatcher = request.getRequestDispatcher(
		        "mvc/view/userAlreadyRegistered.html"
		      );
		      dispatcher.include(request, response);
		    }
	}

}
