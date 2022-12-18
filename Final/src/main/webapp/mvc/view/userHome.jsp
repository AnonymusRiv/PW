<%@page import="es.uco.pw.business.DTO.KartDTO"%>
<%@page import="es.uco.pw.business.managers.GestorPistas"%>
<%@page import="es.uco.pw.business.DTO.PistaDTO"%>
<%@page import="es.uco.pw.business.DTO.ReservaAdultosDTO"%>
<%@page import="es.uco.pw.business.DTO.ReservaInfantilDTO"%>
<%@page import="es.uco.pw.business.DTO.ReservaFamiliarDTO"%>
<%@page import="es.uco.pw.business.managers.GestorReservas"%>
<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
	GestorReservas gestorReservas = GestorReservas.getInstance();
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
		<%
			String nextPage = "";
			String mensajeNextPage = "";
			if (customerBean != null
					&& customerBean.getTypeUser().equals(UsuarioDTO.type.cliente)) {
		%>
	</div>
	<!--end of preloading-->
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
						<li><a style="color: #DCF836" href="index.jsp">Inicio</a></li>
						<li><a href="userProfile">Perfil</a></li>
						<li class="dropdown first"><a
							class="btn btn-default dropdown-toggle lv1"
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
	<!-- Welcome mensaje -->
	<div class="hero common-hero">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="hero-ct">
						<h1>
							Bienvenido de nuevo:
							<jsp:getProperty property="emailUser" name="customerBean" /></h1>
						<ul class="breadcumb">
							<li class="active"><a href="#">Hoy es: </a></li>
							<li><%=formatter6.format(new java.util.Date())%></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- List section-->
	<div class="page-single">
		<div class="container">
			<div class="row ipad-width2">
				<div class="col-md-9 col-sm-12 col-xs-12">
					<h1 style="color: white">Próximas reservas:</h1>
					<br></br>
					<%
							ArrayList<ReservaAdultosDTO> res1 = gestorReservas.reservasFuturasAdultos();
							ArrayList<ReservaInfantilDTO> res2 = gestorReservas.reservasFuturasInfantil();
							ArrayList<ReservaFamiliarDTO> res3 = gestorReservas.reservasFuturasFamiliar();
							
					%>
					<div class="row">
						<%
							String fecha=formatter4.format(new java.util.Date());
							for (int i = 0; i < res1.size(); i++) {
								if(res1.get(i).getUserId().equals(customerBean.getEmailUser())){
									if(res1.get(i).getDate().compareTo(fecha)>0){
						%>
						<div class="col-md-12">
							<div class="ceb-item-style-2">
								<div class="ceb-infor">
								
										<p><%="Reserva Adultos: " %></p>
										<p><%="ID: " + res1.get(i).getId()%></p>
										<p><%="Fecha: " + res1.get(i).getDate()%></p>
										
								</div>
							</div>
						</div>
						<%		
									}
								}
							}
						%>
						<div class="row">
						<%
							for (int i = 0; i < res2.size(); i++) {
								if(res2.get(i).getUserId().equals(customerBean.getEmailUser())){
									if(res2.get(i).getDate().compareTo(fecha)>0){
						%>
						<div class="col-md-12">
							<div class="ceb-item-style-2">
								<div class="ceb-infor">
								
										<p><%="Reserva Infantil: " %></p>
										<p><%="ID: " + res2.get(i).getId()%></p>
										<p><%="Fecha: " + res2.get(i).getDate()%></p>
										
								</div>
							</div>
						</div>
						<%
									}
								}
							}
						%>
						<div class="row">
						<%
							for (int i = 0; i < res3.size(); i++) {
								if(res3.get(i).getUserId().equals(customerBean.getEmailUser())){
									if(res3.get(i).getDate().compareTo(fecha)>0){
						%>
						<div class="col-md-12">
							<div class="ceb-item-style-2">
								<div class="ceb-infor">
								
										<p><%="Reserva Familiar: " %></p>
										<p><%="ID: " + res3.get(i).getId()%></p>
										<p><%="Fecha: " + res3.get(i).getDate()%></p>
										
								</div>
							</div>
						</div>
						<%
									}
								}
							}
						%>
					</div>
				</div>
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
						Av. de Rabanales, s/n,<br>14014 C&oacute;rdoba
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
		} else {
			if (customerBean.getTypeUser().equals(UsuarioDTO.type.administrador)) {
				nextPage = "mvc/view/adminHome.jsp";
	%>
	<jsp:forward page="<%=nextPage%>">
		<jsp:param value="<%=mensajeNextPage%>" name="message" />
	</jsp:forward>
	<%
		} else {
				nextPage = "../../index.jsp";
	%>
	<jsp:forward page="<%=nextPage%>">
		<jsp:param value="<%=mensajeNextPage%>" name="message" />
	</jsp:forward>
	<%
		}
		}
	%>
</body>

<!-- userfavoritelist14:04-->
</html>