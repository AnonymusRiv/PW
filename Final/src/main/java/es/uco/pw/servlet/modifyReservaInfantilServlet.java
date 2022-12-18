package es.uco.pw.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.DTO.KartDTO;
import es.uco.pw.business.DTO.ReservaAdultosDTO;
import es.uco.pw.business.DTO.ReservaFamiliarDTO;
import es.uco.pw.business.DTO.ReservaInfantilDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.managers.GestorPistas;
import es.uco.pw.business.managers.GestorReservas;
import es.uco.pw.display.javabean.CustomerBean;

/**
 * Servlet implementation class userProfileServlet
 */
@WebServlet(name="modifyReservaInfantil", urlPatterns="/modifyReservaInfantil")
public class modifyReservaInfantilServlet extends HttpServlet {
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
		    	GestorReservas gestorReservas = GestorReservas.getInstance();
			      ArrayList<ReservaInfantilDTO> reservasI = gestorReservas.reservasFuturasInfantil();
			      ReservaInfantilDTO reserva = null;
			      int id = Integer.parseInt(request.getParameter("ReservaId"));
			      for(int i=0; i<reservasI.size(); i++) {
				  	  if(reservasI.get(i).getId() == id) {
				  		 reserva = reservasI.get(i);
				  	  }
				    }
			      if(reserva != null) {
			    	  reserva.setPistId(request.getParameter("pista"));
				      reserva.setDate(request.getParameter("date"));
				      int duration = Integer.parseInt(request.getParameter("duration"));
				      reserva.setDuration(duration);
				      if(duration == 60) {
				    	  reserva.setPrice(20);
				      }
				      else if(duration == 90) {
				    	  reserva.setPrice(30);
				      }
				      else {
				    	  reserva.setPrice(40);
				      }
				      reserva.setnChildren(Integer.parseInt(request.getParameter("nPart")));
				      gestorReservas.modificarReservaIndividualInfantil(reserva, id);		      }
		      
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
		    	String search = request.getParameter("ReservaId");

		      customerBean.setSearch(search);

		      session.setAttribute("customerBean", customerBean);

		      RequestDispatcher dispatcher = request.getRequestDispatcher("mvc/view/modifyReserva.jsp");
		      dispatcher.include(request, response);
		    }
		  }
		}