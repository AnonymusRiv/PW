package es.uco.pw.servlet;

import es.uco.pw.business.managers.GestorReservas;
import es.uco.pw.display.javabean.CustomerBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Clase deleteReservasServlet para borrar una reserva del sistema
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Silvia Roldán Flores
 * @author Carlos Rivero Talavera
 * @version 1.0
 */

@WebServlet(name = "deleteReserva", urlPatterns = "/deleteReserva")
public class deleteReservasServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = -5782796844904182648L;

  /**
   * Borra una sesión del sistema
   * @param HttpServletRequest request
   * @param HttpServletResponse response
   * @return none
   */

  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    HttpSession session = request.getSession(true);
    CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");

    if (customerBean == null || customerBean.getEmailUser().equals("")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userNotFound.html");
      dispatcher.include(request, response);
	} else if (customerBean.getTypeUser().equals("Cliente")) {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/mvc/view/userHome.jsp");
		dispatcher.include(request, response);
	} else {
      GestorReservas gestorReservas = GestorReservas.getInstance();
      //gestorReservas.deleteReserva(--> falta poner parametro reservas,Integer.parseInt(request.getParameter("userId")));
      RequestDispatcher dispatcher = request.getRequestDispatcher("listReservas");
      dispatcher.include(request, response);
    }
  }
}