package es.uco.pw.servlet;

import es.uco.pw.business.managers.GestorReservas;
import es.uco.pw.business.DTO.BonoDTO;
import es.uco.pw.business.DTO.ReservaAdultosDTO;
import es.uco.pw.business.DTO.ReservaFamiliarDTO;
import es.uco.pw.business.DTO.ReservaInfantilDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
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
 * Clase modifyKartServlet para modificar un kart del sistema
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Silvia Roldán Flores
 * @author Carlos Rivero Talavera
 * @version 1.0
 */

@WebServlet(name = "addReservaBono", urlPatterns = "/addReservaBono")
public class addReservaBonoServlet extends HttpServlet {

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
    } else if (customerBean.getTypeUser().equals(UsuarioDTO.type.administrador)) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/adminHome.jsp");
      dispatcher.include(request, response);
    } else {
      GestorReservas gestor = GestorReservas.getInstance();

      int id = Integer.parseInt(request.getParameter("BonoId"));
      
      BonoDTO bono = gestor.findBono(id);

      if (bono != null) {
    	  
    	  if(bono.getTypeRes().equals(BonoDTO.type.adultos)) {
    		  ReservaAdultosDTO reserva = new ReservaAdultosDTO();
    		  reserva.setBonoId(id);
    		  reserva.setDate(request.getParameter("date"));
    		  if(bono.getSession() == 5) {
    			  String dat = reserva.getDate();
    			  String año = dat.substring(0, 3);
    			  String mes = dat.substring(5, 6);
    			  String dia = dat.substring(8, 9);
    			  String fecha = año + "-" + mes + "-" + dia;
    			    
    			  bono.setCaducity(fecha);
    		  }
    		  bono.setSession(bono.getSession() - 1);
    		  reserva.setPistId(request.getParameter("pista"));
    		  reserva.setDuration(Integer.parseInt(request.getParameter("duration")));
    		  if(reserva.getDuration() == 60) {
    			  reserva.setPrice(20);
    		  }
    		  else if(reserva.getDuration() == 90) {
    			  reserva.setPrice(30);
    		  }
    		  else {
    			  reserva.setPrice(40);
    		  }
    		  reserva.setUserId(customerBean.getEmailUser());
    		  reserva.setDiscount(5);
    		  reserva.setnParticipants(Integer.parseInt(request.getParameter("nAdult")));
    		  
    		  gestor.hacerReservaBonoAdultos(reserva);
    		  gestor.modificarBono(bono, id);
    	  }
    	  
    	  else if(bono.getTypeRes().equals(BonoDTO.type.infantil)) {
    		  ReservaInfantilDTO reserva = new ReservaInfantilDTO();
    		  reserva.setBonoId(id);
    		  reserva.setDate(request.getParameter("date"));
    		  if(bono.getSession() == 5) {
    			  bono.setCaducity(request.getParameter("date"));
    		  }
    		  int aux = bono.getSession();
    		  bono.setSession((aux - 1));
    		  reserva.setPistId(request.getParameter("pista"));
    		  reserva.setDuration(Integer.parseInt(request.getParameter("duration")));
    		  if(reserva.getDuration() == 60) {
    			  reserva.setPrice(20);
    		  }
    		  else if(reserva.getDuration() == 90) {
    			  reserva.setPrice(30);
    		  }
    		  else {
    			  reserva.setPrice(40);
    		  }
    		  reserva.setUserId(customerBean.getEmailUser());
    		  reserva.setDiscount(5);
    		  reserva.setnChildren(Integer.parseInt(request.getParameter("nPart")));
    		  
    		  gestor.hacerReservaBonoInfantil(reserva);
    		  gestor.modificarBono(bono, id);
    	  }
    	  
    	  else {
    		  ReservaFamiliarDTO reserva = new ReservaFamiliarDTO();
    		  reserva.setBonoId(id);
    		  reserva.setDate(request.getParameter("date"));
    		  if(bono.getSession() == 5) {
    			  bono.setCaducity(request.getParameter("date"));
    		  }
    		  bono.setSession(bono.getSession() - 1);
    		  reserva.setPistId(request.getParameter("pista"));
    		  reserva.setDuration(Integer.parseInt(request.getParameter("duration")));
    		  if(reserva.getDuration() == 60) {
    			  reserva.setPrice(20);
    		  }
    		  else if(reserva.getDuration() == 90) {
    			  reserva.setPrice(30);
    		  }
    		  else {
    			  reserva.setPrice(40);
    		  }
    		  reserva.setUserId(customerBean.getEmailUser());
    		  reserva.setDiscount(5);
    		  reserva.setnAdults(Integer.parseInt(request.getParameter("nAdults")));
    		  reserva.setnChildren(Integer.parseInt(request.getParameter("nChilds")));
    		  
    		  gestor.hacerReservaBonoFamiliar(reserva);
    		  gestor.modificarBono(bono, id);
    	  }
    	  
      } else {
        RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/errorAddingReserva.html");
        dispatcher.include(request, response);
      }

      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/listReservas.jsp");
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
    } else if (customerBean.getTypeUser().equals(UsuarioDTO.type.administrador)) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/adminHome.jsp");
      dispatcher.include(request, response);
    } else {
      String search = request.getParameter("BonoId");

      customerBean.setSearch(search);

      session.setAttribute("customerBean", customerBean);

      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/addReservaBono.jsp");
      dispatcher.include(request, response);
    }
  }
}