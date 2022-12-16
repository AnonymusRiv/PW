package es.uco.pw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.DTO.KartDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.managers.GestorPistas;
import es.uco.pw.display.javabean.CustomerBean;

/**
 * Servlet implementation class userProfileServlet
 */
@WebServlet(name="addReserva", urlPatterns="/addReserva")
public class addReservaServlet extends HttpServlet {
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

		      String type = request.getParameter("type");
		      
		      if(type.equals("infantil")) {
		    	  RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/addReservaInfantil.jsp");
			      dispatcher.include(request, response);
		      }
		      else if(type.equals("familiar")) {
		    	  RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/addReservaFamiliar.jsp");
			      dispatcher.include(request, response);
		      }
		      else {
			      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/addReservaAdulto.jsp");
			      dispatcher.include(request, response);		    	  
		      }

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
		    RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/addTipoReserva.jsp");
		     	dispatcher.include(request, response);
		}
	}
}
