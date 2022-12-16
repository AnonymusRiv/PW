package es.uco.pw.servlet;

import es.uco.pw.business.managers.GestorPistas;
import es.uco.pw.business.DTO.KartDTO;
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
  private static final long serialVersionUID = -1L;

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
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userNotFound.html");
      dispatcher.include(request, response);
    } else if (customerBean.getTypeUser().equals(UsuarioDTO.type.cliente)) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userHome.jsp");
      dispatcher.include(request, response);
    } else {
    	GestorPistas gestorPistas = GestorPistas.getInstance();

        int id = Integer.parseInt(request.getParameter("KartId"));
        
        KartDTO kart = gestorPistas.findKart(id);

        if (kart != null) {
      	  
      	  kart.setpistaId(request.getParameter("pista"));
            if(kart.getpistaId() != "") {
          	  kart.setStat(KartDTO.status.reservado);
            }
            else {
          	  kart.setStat(KartDTO.status.disponible);
            }
          gestorPistas.asociarKartsAPista(kart, id);
        } else {
          RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/errorAddingKart.html");
          dispatcher.include(request, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/listKarts.jsp");
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
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userNotFound.html");
      dispatcher.include(request, response);
    } else if (customerBean.getTypeUser().equals(UsuarioDTO.type.cliente)) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userHome.jsp");
      dispatcher.include(request, response);
    } else {
    	 String search = request.getParameter("KartId");

      customerBean.setSearch(search);

      session.setAttribute("customerBean", customerBean);

      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/asociarKaP.jsp");
      dispatcher.include(request, response);
    }
  }
}