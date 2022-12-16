package es.uco.pw.servlet;

import es.uco.pw.business.managers.GestorPistas;
import es.uco.pw.business.DTO.PistaDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
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
 * Clase modifyPistaServlet para modificar una pista del sistema
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Silvia Roldán Flores
 * @author Carlos Rivero Talavera
 * @version 1.0
 */

@WebServlet(name = "modifyPista", urlPatterns = "/modifyPista")
public class modifyPistaServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = 1L;

  /**
   * Modifica una pista proveniente de un formulario
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
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userNotFound.html");
      dispatcher.include(request, response);
    } else if (customerBean.getTypeUser().equals(UsuarioDTO.type.cliente)) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userHome.jsp");
      dispatcher.include(request, response);
    } else {
      GestorPistas gestorPistas = GestorPistas.getInstance();

      String name = request.getParameter("PistaId");
      
      PistaDTO pista = gestorPistas.findPista(name);

      if(pista != null) {
    	  
      	String status = request.getParameter("status");
          if(status.equals("false")) {
        	  pista.setStatus(false);
          }
          else {
          	pista.setStatus(true);
          }
          String diff = request.getParameter("difficulty");
          if(diff.equals("infantil")) {
          	pista.setDificulty(PistaDTO.dificulty.infantil);
          }
          else if(diff.equals("familiar")) {
          	pista.setDificulty(PistaDTO.dificulty.familiar);
          }
          else {
          	pista.setDificulty(PistaDTO.dificulty.adultos);
          }
      
      	pista.setMax(Integer.parseInt(request.getParameter("max")));
        gestorPistas.modificarPista(pista, name);
      }
      else {
          RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/errorAddingPista.html");
          dispatcher.include(request, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/listPistas.jsp");
        dispatcher.include(request, response);
      }
    }
 

  /**
   * Redirige al usuario a la vista para modificar una pista
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
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userHome.jsp");
      dispatcher.include(request, response);
    } else {
      String search = request.getParameter("PistaId");

      customerBean.setSearch(search);

      session.setAttribute("customerBean", customerBean);

      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/modifyPista.jsp");
      dispatcher.include(request, response);
    }
  }
}