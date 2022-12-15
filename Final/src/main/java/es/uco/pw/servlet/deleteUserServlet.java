package es.uco.pw.servlet;

import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.managers.GestorUsuarios;
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
 * Clase deleteUserServlet para borrar un usuario del sistema
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Silvia Roldán Flores
 * @author Carlos Rivero Talavera
 * @version 1.0
 */

@WebServlet(name = "deleteUser", urlPatterns = "/deleteUser")
public class deleteUserServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = 1L;

  /**
   * Borra un usuario del sistema
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
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userNotFound.html");
      dispatcher.include(request, response);
	} else if (customerBean.getTypeUser().equals(UsuarioDTO.type.cliente)) {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("mvc/view/userHome.jsp");
		dispatcher.include(request, response);
	} else {
      GestorUsuarios gestorUsuario = GestorUsuarios.getInstance();
      gestorUsuario.deleteUsuario(request.getParameter("mail"));
      RequestDispatcher dispatcher = request.getRequestDispatcher("listarUsuarios");
      dispatcher.include(request, response);
    }
  }
}