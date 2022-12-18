<%@page import="es.uco.pw.business.DTO.KartDTO"%>
<%@page import="es.uco.pw.business.managers.GestorPistas"%>
<%@page import="es.uco.pw.business.DTO.PistaDTO"%>
<%@page import="es.uco.pw.business.DTO.ReservaAdultosDTO"%>
<%@page import="es.uco.pw.business.DTO.ReservaInfantilDTO"%>
<%@page import="es.uco.pw.business.DTO.ReservaFamiliarDTO"%>
<%@page import="es.uco.pw.business.managers.GestorReservas"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="customerBean" scope="session"
	class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%@ page
	import="java.text.SimpleDateFormat,es.uco.pw.business.DTO.UsuarioDTO,es.uco.pw.business.managers.DBmanager,es.uco.pw.business.managers.GestorUsuarios,java.util.ArrayList"%>
<html>
<%
	SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy");
	request.setCharacterEncoding("UTF-8");
	SimpleDateFormat formatter5 = new SimpleDateFormat(
		"dd-MM-yyyy HH:mm");
	GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
	GestorReservas gestorReservas = GestorReservas.getInstance();
	GestorPistas gestorPistas = GestorPistas.getInstance();
	ArrayList<PistaDTO> pistas = gestorPistas.getPistas();
	ArrayList<ReservaAdultosDTO> reservasA = gestorReservas.reservasFuturasAdultos();
	ArrayList<ReservaFamiliarDTO> reservasF = gestorReservas.reservasFuturasFamiliar();
	ArrayList<ReservaInfantilDTO> reservasI = gestorReservas.reservasFuturasInfantil();
	String search = customerBean.getSearch();
	String filter = customerBean.getFilter();
	
	ReservaAdultosDTO reservaA = null;
	ReservaFamiliarDTO reservaF = null;
	ReservaInfantilDTO reservaI = null;
	
	for(int i=0; i<reservasA.size(); i++) {
  	  if(reservasA.get(i).getId() == Integer.parseInt(search)) {
  		 reservaA = reservasA.get(i);
  	  }
    }
	for(int i=0; i<reservasF.size(); i++) {
	  	  if(reservasF.get(i).getId() == Integer.parseInt(search)) {
	  		 reservaF = reservasF.get(i);
	  	  }
	    }
	for(int i=0; i<reservasI.size(); i++) {
	  	  if(reservasI.get(i).getId() == Integer.parseInt(search)) {
	  		 reservaI = reservasI.get(i);
	  	  }
	    }
%>
<!-- moviegridfw07:38-->
<head>
<!-- Basic need -->
<title>UCOkarts</title>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<link rel="profile" href="#">
<link rel="icon" type="image/x-icon" href="images/favicon.ico">

<!--Google Font-->
<link rel="stylesheet"
	href='http://fonts.googleapis.com/css?family=Dosis:400,700,500|Nunito:300,400,600' />
<!-- Mobile specific meta -->
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone-no">

<!-- CSS files -->
<link rel="stylesheet" href="css/plugins.css">
<link rel="stylesheet" href="css/style.css">


</head>
<body>
	<!--preloading-->
	<div id="preloader">
		<img class="logo" src="images/logo1.png" alt="" width="119"
			height="58">
		<div id="status">
			<span></span> <span></span>
		</div>
		</div>
		<!--end of preloading-->
		
		<%
		String nextPage = "";
		String mensajeNextPage = "";
		if (customerBean != null
				&& customerBean.getTypeUser().equals(UsuarioDTO.type.cliente)) {
		%>
		
	
	
	<!-- BEGIN | Header -->
	<header class="ht-header">
		<div class="container">
			<nav class="navbar navbar-default navbar-custom">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header logo">
					<div class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<div id="nav-icon1">
							<span></span> <span></span> <span></span>
						</div>
					</div>
					<a href="index.jsp"><img class="logo" src="images/logo1.png"
						alt="" width="119" height="58"></a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse flex-parent"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav flex-child-menu menu-left">
						<li class="hidden"><a href="#page-top"></a></li>
						<li><a href="index.jsp">Inicio</a></li>
						<li><a href="userProfile">Perfil</a></li>
						<li class="dropdown first"><a
							class="btn btn-default dropdown-toggle lv1"
							style="color: #DCF836"
							data-toggle="dropdown"> Reservas <i
								class="fa fa-angle-down" aria-hidden="true"></i>
						</a>
							<ul class="dropdown-menu level1">
								<li><a href="addReserva">Crear reserva</a></li>
								<li><a href="listReservas">Ver reservas</a></li>
								<li><a href="listdeleteReserva">Cancelar/Modificar reservas</a></li>
							</ul></li>
							<li class="dropdown first"><a
							class="btn btn-default dropdown-toggle lv1"
							data-toggle="dropdown"> Bonos <i
								class="fa fa-angle-down" aria-hidden="true"></i>
						</a>
							<ul class="dropdown-menu level1">
								<li><a href="addBono">Adquirir Bono</a></li>
								<li><a href="listBono">Ver Bonos</a></li>
								<li><a href="listaddReservaBono">Hacer reserva en bono</a></li>
							</ul></li>
							<li><a href="listarPistaDisponible">Pistas</a></li>
					</ul>
					<form method="get" autocomplete="off" action="logout">
						<ul class="nav navbar-nav flex-child-menu menu-right">
							<li><button class="redbtn" style="border: none"
									type="submit">Cerrar sesión</button></li>
						</ul>
					</form>
				</div>
				<!-- /.navbar-collapse -->
			</nav>
		</div>
	</header>
	<!-- END | Header -->

	<div class="hero user-hero">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="hero-ct">
						<h1>Modificar Reserva</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="page-single">
		<div class="container">
			<div class="row ipad-width">
				<div class="col-md-3 col-sm-12 col-xs-12">
					</div>
					<div class="col-md-9 col-sm-12 col-xs-12">
						<div class="form-style-1 user-pro">
							
									<% if(reservaA != null){ %>
									<form method="post" action="modifyReservaAdulto" class="user">
										<div class="col-md-6 form-it">
											<label>Id</label> <select name="ReservaId">
												<option value=<%=reservaA.getId()%>><%=reservaA.getId()%></option>
											</select>
										</div>
										<div class="col-md-6 form-it">
											<label for="dateOfBirth"> Fecha de la reserva: <input type="date"
												name="date" required="required" />
											</label>
										</div>
										<div class="col-md-6 form-it">
											<label>Duración</label> <select name="duration">
												<option value="60">60</option>
												<option value="90">90</option>
												<option value="120">120</option>
											</select>
										</div>
										<div class="col-md-6 form-it">
											<label>Pistas</label> <select name="pista">
											<% for(int i=0; i<pistas.size(); i++){
												if(pistas.get(i).getDif().equals(PistaDTO.dificulty.adultos)){
												%>
												<option value=<%=pistas.get(i).getName() %>><%= pistas.get(i).getName() %></option>
												<%}	}%>
											</select>
										</div>
										<div class="col-md-6 form-it">
											<label>Nº de participantes</label>
												<input type="number" name="nPart" min="1"
													placeholder="1" />
										</div>
										<div class="row">
											<div class="col-md-6 form-it">
												<hr>
												<input class="submit" type="submit" value="Guardar" />
											</div>
										</div>
										</form>
									
									<%}else if(reservaI != null){ %>
									<form method="post" action="modifyReservaInfantil" class="user">
									<div class="col-md-6 form-it">
											<label>Id</label> <select name="ReservaId">
												<option value=<%=reservaI.getId()%>><%=reservaI.getId()%></option>
											</select>
										</div>
										<div class="col-md-6 form-it">
											<label for="dateOfBirth"> Fecha de la reserva: <input type="date"
												name="date" required="required" />
											</label>
										</div>
										<div class="col-md-6 form-it">
										<label>Duración</label> <select name="duration">
											<option value="60">60</option>
											<option value="90">90</option>
											<option value="120">120</option>
											</select>
										</div>
										<div class="col-md-6 form-it">
										<label>Pistas</label> <select name="pista">
											<% for(int i=0; i<pistas.size(); i++){
											if(pistas.get(i).getDif().equals(PistaDTO.dificulty.infantil)){
												%>
											<option value=<%=pistas.get(i).getName() %>><%= pistas.get(i).getName() %></option>
											<%}	}%>
										</select>
										</div>
										<div class="col-md-6 form-it">
											<label>Nº de niños</label>
											<input type="number" name="nPart" min="1"
												placeholder="1" />
										</div>
										<div class="row">
										<div class="col-md-6 form-it">
											<hr>
											<input class="submit" type="submit" value="Guardar" />
										</div>
										</div>
									</form>
									<% }else{ %>
									<form method="post" action="modifyReservaFamiliar" class="user">
									<div class="col-md-6 form-it">
											<label>Id</label> <select name="ReservaId">
												<option value=<%=reservaF.getId()%>><%=reservaF.getId()%></option>
											</select>
										</div>
								<div class="col-md-6 form-it">
								<label for="dateOfBirth"> Fecha de la reserva: <input type="date"
									name="date" required="required" />
								</label>
							</div>
							<div class="col-md-6 form-it">
								<label>Duración</label> <select name="duration">
										<option value="60">60</option>
										<option value="90">90</option>
										<option value="120">120</option>
									</select>
								</div>
									<div class="col-md-6 form-it">
									<label>Pistas</label> <select name="pista">
									<% for(int i=0; i<pistas.size(); i++){
										if(pistas.get(i).getDif().equals(PistaDTO.dificulty.familiar)){
										%>
										<option value=<%=pistas.get(i).getName() %>><%= pistas.get(i).getName() %></option>
										<%}	}%>
									</select>
								</div>
								<div class="col-md-6 form-it">
									<label>Nº de adultos</label>
									<input type="number" name="nAdults" min="1"
										placeholder="1" />
								</div>
								<div class="col-md-6 form-it">
									<label>Nº de niños</label>
									<input type="number" name="nChilds" min="1"
										placeholder="1" />
								</div>
								<div class="row">
									<div class="col-md-6 form-it">
										<hr>
										<input class="submit" type="submit" value="Guardar" />
									</div>
								</div>
							</form>
									<%} %>
					
								</div>
						</div>
					</div>   
				</div>   
			
			</div>
	<!-- end of list section-->
	<!-- footer section-->
	<footer class="ht-footer">
		<br></br>
		<div class="container">
			<div class="flex-parent-ft">
				<a><img class="logo" src="images/logo1.png" alt=""></a>
				<div class="flex-child-ft item2">
					<br></br>
					<h4>Recursos</h4>
					<ul>
						<li><a href="#">Acerca de</a></li>
						<li><a href="#">Foros</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Centro de ayuda</a></li>
					</ul>     
				</div>
				
<div class="flex-child-ft item3">
					<br></br>
					<h4>Legal</h4>
					<ul>
						<li><a href="#">Terminos de uso</a></li>
						<li><a href="#">Pol&iacute;tica de privacidad</a></li>
						<li><a href="#">Seguridad</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item4">
					<br></br>
					<h4>Cuenta</h4>
					<ul>
						<li><a href="#">Mi cuenta</a></li>
						<li><a href="#">Lista de seguimiento</a></li>
						<li><a href="#">Colecciones</a></li>
						<li><a href="#">Gu&iacute;a del usuario</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item5">
					<br></br>
					<h4>Contacto</h4>
					<p>
						Av. de Medina Azahara, 5,<br>14071 C&oacute;rdoba
					</p>
					<p>
						Ll&aacute;manos: <a href="#">(+34) 957 218 000</a>
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- end of footer section-->
	<script src="js/jquery.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/plugins2.js"></script>
	<script src="js/custom.js"></script>
	<%
		}
	%>
</body>

<!-- userfavoritelist14:04-->
</html>