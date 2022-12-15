package es.uco.pw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.display.javabean.CustomerBean;

/**
 * Clase userProfile del sistema
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Silvia Roldán Flores
 * @author Carlos Rivero Talavera
 * @version 1.0
 */

/**
 * Servlet implementation class userProfileServlet
 */
@WebServlet(name="userProfile", urlPatterns="/userProfile")
public class userProfileServlet extends HttpServlet {
	
	/** Serial ID */
	private static final long serialVersionUID = 1L;
       
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
		    RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userProfile.jsp");
		     	dispatcher.include(request, response);
		}
	}
}
