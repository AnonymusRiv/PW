package es.uco.pw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.DTO.BonoDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.managers.GestorReservas;
import es.uco.pw.display.javabean.CustomerBean;


/**
 * Servlet implementation class userProfileServlet
 */
@WebServlet(name="addBono", urlPatterns="/addBono")
public class addBonoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(
		    HttpServletRequest request,
		    HttpServletResponse response
		  )
		    throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
		    HttpSession session = request.getSession(true);
		    CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");

		    if (customerBean == null || customerBean.getEmailUser().equals("")) {
		      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userNotFound.html");
		      dispatcher.include(request, response);
		    } else if (customerBean.getTypeUser().equals(UsuarioDTO.type.administrador)) {
		      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/adminHome.jsp");
		      dispatcher.include(request, response);
		    } else {
		      GestorReservas gestorReservas = GestorReservas.getInstance();

		      BonoDTO bono = new BonoDTO();
		      bono.setUserID(customerBean.getEmailUser());
		      bono.setSession(5);
		      String aux = request.getParameter("type");
		      if(aux.equals("infantil")) {
		    	  bono.setTypeRes(BonoDTO.type.infantil);
		      }
		      else if(aux.equals("familiar")) {
		    	  bono.setTypeRes(BonoDTO.type.familiar);
		      }
		      else {
		    	  bono.setTypeRes(BonoDTO.type.adultos);
		      }
		      
		      gestorReservas.registrarBono(bono);

		      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userHome.jsp");
		      dispatcher.include(request, response);
		    }
		  }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    HttpSession session = request.getSession(true);
		CustomerBean customerBean = (CustomerBean) session.getAttribute(
	      "customerBean"
	    );

		if (customerBean == null || customerBean.getEmailUser().equals("")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userNotFound.html");
		      dispatcher.include(request, response);
		} 
		else {
		    RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/controllers/addBono.jsp");
		     	dispatcher.include(request, response);
		}
	}
}
