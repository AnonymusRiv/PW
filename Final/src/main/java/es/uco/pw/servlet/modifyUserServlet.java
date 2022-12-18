package es.uco.pw.servlet;

import es.uco.pw.business.managers.GestorUsuarios;
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
 * Clase modifyUserServlet para modificar un usuario del sistema
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Silvia Roldán Flores
 * @author Carlos Rivero Talavera
 * @version 1.0
 */

@WebServlet(name = "modifyUser", urlPatterns = "/modifyUser")
public class modifyUserServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = 1L;

  /**
   * Modifica un usuario proveniente de un formulario
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
    } else {
      GestorUsuarios gestorUsuario = GestorUsuarios.getInstance();

      String mail = customerBean.getEmailUser();
      UsuarioDTO usuario = gestorUsuario.findUser(mail); 

      if (usuario!=null) {

    	  usuario.setName(request.getParameter("name"));
    	  usuario.setPassword(request.getParameter("password"));
    	  String año=request.getParameter("year");
    	  String mes=request.getParameter("month");
    	  String dia=request.getParameter("day");
    	  usuario.setDateOfBirth(año + "-" + mes + "-" + dia);
        gestorUsuario.modificarUsuario(usuario, mail);
      } else {
        RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/errorAddingPista.html");
        dispatcher.include(request, response);
      }

      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/userProfile.jsp");
      dispatcher.include(request, response);
    }
  }

  /**
   * Redirige al usuario a la vista para modificar un usuario
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
    } else {
      String search = request.getParameter("name");

      customerBean.setSearch(search);

      session.setAttribute("customerBean", customerBean);

      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/modifyUser.jsp");
      dispatcher.include(request, response);
    }
  }
}