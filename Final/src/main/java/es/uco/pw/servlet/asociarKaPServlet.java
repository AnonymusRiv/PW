package es.uco.pw.servlet;

import es.uco.pw.business.managers.GestorPistas;
import es.uco.pw.business.DTO.PistaDTO;
import es.uco.pw.display.javabean.CustomerBean;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Clase asociarKaPServlet del sistema
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Silvia Roldán Flores
 * @author Carlos Rivero Talavera
 * @version 1.0
 */

@WebServlet(name = "asociarKaP", urlPatterns = "/asociarKaP")
public class asociarKaPServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = -5782796844904182648L;

  /**
   * Modifica una sesión proveniente de un formulario
   * @param HttpServletRequest request
   * @param HttpServletResponse response
   * @return none
   */

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
      RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userNotFound.html");
      dispatcher.include(request, response);
    } else if (customerBean.getTypeUser().equals("Cliente")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userHome.jsp");
      dispatcher.include(request, response);
    } else {
      GestorPistas gestorPistas = GestorPistas.getInstance();

      String name = request.getParameter("name");

      /*PistaDTO pista = gestorPistas.findPista(name); --> habría que poner un find pista

      if (gestorPistas.setName(name)) {

        gestorPistas.asociarKartsaPista(pista);
      } else {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/errorAdingPista.html");
        dispatcher.include(request, response);
      }*/

      RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/listPistas.jsp");
      dispatcher.include(request, response);
    }
  }

  /**
   * Redirige al usuario a la vista para modificar una sesión
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
      RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userHome.jsp");
      dispatcher.include(request, response);
    } else {
      String search = request.getParameter("name");

      customerBean.setSearch(search);

      session.setAttribute("customerBean", customerBean);

      RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/modifyPista.jsp");
      dispatcher.include(request, response);
    }
  }
}