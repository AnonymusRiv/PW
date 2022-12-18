package es.uco.pw.servlet;

import es.uco.pw.business.DTO.BonoDTO;
import es.uco.pw.business.DTO.ReservaAdultosDTO;
import es.uco.pw.business.DTO.ReservaFamiliarDTO;
import es.uco.pw.business.DTO.ReservaInfantilDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.managers.GestorReservas;
import es.uco.pw.display.javabean.CustomerBean;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Clase deletePistaServlet para borrar una pista del sistema
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Silvia Roldán Flores
 * @author Carlos Rivero Talavera
 * @version 1.0
 */

@WebServlet(name = "deleteReservaAdmin", urlPatterns = "/deleteReservaAdmin")
public class deleteReservaAdminServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = 1L;

  /**
   * Borra una pista del sistema
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
				.getRequestDispatcher("/mvc/view/userHome.jsp");
		dispatcher.include(request, response);
	} else {
      GestorReservas gestor = GestorReservas.getInstance();
      int id = Integer.parseInt(request.getParameter("ReservaId"));
      ArrayList<ReservaInfantilDTO> infantiles = gestor.reservasFuturasInfantil();
      ArrayList<ReservaFamiliarDTO> familiares = gestor.reservasFuturasFamiliar();
      ArrayList<ReservaAdultosDTO> adultos = gestor.reservasFuturasAdultos();
      ArrayList<BonoDTO> bonos = gestor.getBonos();
      for(int i=0; i<infantiles.size(); i++) {
    	  if(infantiles.get(i).getId() == id) {
    		  if(infantiles.get(i).getBonoId() == 0) {
    			  gestor.deleteReservaInfantil(infantiles.get(i));
    			  break;
    		  }
    		  else {
    			  for(int j=0; j<bonos.size(); j++) {
    				  if(bonos.get(j).getId() == infantiles.get(i).getBonoId()) {
    					  gestor.deleteReservaInfantil(infantiles.get(i));
    					  BonoDTO bono = bonos.get(j);
    					  bono.setSession(bono.getSession() + 1);
    					  gestor.modificarBono(bono, bono.getId());
    					  break;
    				  }
    			  }
    		  }
    	  }
      }
      for(int i=0; i<familiares.size(); i++) {
    	  if(familiares.get(i).getId() == id) {
    		  if(familiares.get(i).getBonoId() == 0) {
    			  gestor.deleteReservaFamiliar(familiares.get(i));
    			  break;
    		  }
    		  else {
    			  for(int j=0; j<bonos.size(); j++) {
    				  if(bonos.get(j).getId() == familiares.get(i).getBonoId()) {
    					  gestor.deleteReservaFamiliar(familiares.get(i));
    					  BonoDTO bono = bonos.get(j);
    					  bono.setSession(bono.getSession() + 1);
    					  gestor.modificarBono(bono, bono.getId());
    					  break;
    				  }
    			  }
    		  }
    	  }
      }
      for(int i=0; i<adultos.size(); i++) {
    	  if(adultos.get(i).getId() == id) {
    		  if(adultos.get(i).getBonoId() == 0) {
    			  gestor.deleteReservaAdultos(adultos.get(i));
    			  break;
    		  }
    		  else {
    			  for(int j=0; j<bonos.size(); j++) {
    				  if(bonos.get(j).getId() == adultos.get(i).getBonoId()) {
    					  gestor.deleteReservaAdultos(adultos.get(i));
    					  BonoDTO bono = bonos.get(j);
    					  bono.setSession(bono.getSession() + 1);
    					  gestor.modificarBono(bono, bono.getId());
    					  break;
    				  }
    			  }
    		  }
    	  }
      }
      
      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/listReservasAdmin.jsp");
      dispatcher.include(request, response);
    }
  }
}