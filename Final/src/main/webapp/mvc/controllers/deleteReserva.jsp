<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="customerBean" scope="session"
	class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%@ page
	import="java.util.Date,java.text.SimpleDateFormat,es.uco.pw.business.DTO.ReservaInfantilDTO,es.uco.pw.business.DTO.ReservaFamiliarDTO,es.uco.pw.business.DTO.ReservaAdultosDTO,es.uco.pw.business.DTO.UsuarioDTO,es.uco.pw.business.managers.DBmanager,es.uco.pw.business.managers.GestorUsuarios,es.uco.pw.business.managers.GestorReservas,es.uco.pw.business.DTO.KartDTO,java.util.ArrayList"%>
<html>
<%
	SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy");
	request.setCharacterEncoding("UTF-8");
	SimpleDateFormat formatter5 = new SimpleDateFormat(
			"dd-MM-yyyy HH:mm");
	SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
	GestorReservas gestorReservas = GestorReservas.getInstance();
	ArrayList<ReservaAdultosDTO> resA = gestorReservas.reservasFuturasAdultos();
	ArrayList<ReservaFamiliarDTO> resF = gestorReservas.reservasFuturasFamiliar();
	ArrayList<ReservaInfantilDTO> resI = gestorReservas.reservasFuturasInfantil();
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
			if (customerBean != null) {
				String search = customerBean.getSearch();
				String filter = customerBean.getFilter();
		%>
		<jsp:setProperty property="search" value="" name="customerBean" />
		<jsp:setProperty property="filter" value="" name="customerBean" />
	
	
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
					<h1 style="color: white">Reservas de Adultos:</h1>
					<br></br>
					<div class="row">
					
						<%
							Date hoy= new Date();
							String fecha=formatter4.format(new java.util.Date(hoy.getTime()+8640000));
							for (int i = 0; i < resA.size(); i++) {
								if(resA.get(i).getUserId().equals(customerBean.getEmailUser())){
									if(resA.get(i).getDate().compareTo(fecha)>0){
						%>
						<div class="col-md-12">
							<div class="ceb-item-style-2">
								<div class="ceb-infor">
										<p><%="ID de la reserva: " + resA.get(i).getId()%></p>
										<p><%="Bono: " + resA.get(i).getBonoId()%></p>
										<p><%="Fecha: " + resA.get(i).getDate()%></p>
										<p><%="Duración: " + resA.get(i).getDuration()%></p>
										<p><%="Precio: " + resA.get(i).getPrice()%></p>
										<p><%="Descuento: " + resA.get(i).getDiscount()%></p>
										<p><%="ID de la pista: " + resA.get(i).getPistId()%></p>
										<p><%="Nº de participantes: " + resA.get(i).getnParticipants()%></p>
										<p><%="Estado: Por realizar"%></p>
										<hr>
										<a class="redbtn"
											href=<%="modifyReservaAdulto?ReservaId="
											+ resA.get(i).getId()%>
											style="border: none;  background-color: orange" type="submit">Modificar</a>
											&nbsp;
										<a class="redbtn"
											href=<%="deleteReserva?ReservaId="
											+ resA.get(i).getId()%>
											style="border: none" type="submit">Cancelar</a> <br></br>
								</div>
							</div>
						</div>
					</div>
					<%
									}
								}
							}
					%>
					
					<h1 style="color: white">Reservas Familiares:</h1>
					<br></br>
					<div class="row">
						<%
						for (int i = 0; i < resF.size(); i++) {
							if(resF.get(i).getUserId().equals(customerBean.getEmailUser())){
								if(resF.get(i).getDate().compareTo(fecha)>0){
						%>
						<div class="col-md-12">
							<div class="ceb-item-style-2">
								<div class="ceb-infor">
										<p><%="ID de la reserva: " + resF.get(i).getId()%></p>
										<p><%="Bono: " + resF.get(i).getBonoId()%></p>
										<p><%="Fecha: " + resF.get(i).getDate()%></p>
										<p><%="Duración: " + resF.get(i).getDuration()%></p>
										<p><%="Precio: " + resF.get(i).getPrice()%></p>
										<p><%="Descuento: " + resF.get(i).getDiscount()%></p>
										<p><%="ID de la pista: " + resF.get(i).getPistId()%></p>
										<p><%="Nº de niñ@s: " + resF.get(i).getnChildren()%></p>
										<p><%="Nº de adultos: " + resF.get(i).getnAdults()%></p>
										<p><%="Estado: Por realizar"%></p>
										<hr>
										<a class="redbtn"
											href=<%="modifyReservaFamiliar?ReservaId="
											+ resF.get(i).getId()%>
											style="border: none;  background-color: orange" type="submit">Modificar</a>
											&nbsp;
										<a class="redbtn"
											href=<%="deleteReserva?ReservaId="
											+ resF.get(i).getId()%>
											style="border: none" type="submit">Cancelar</a> <br></br>
								</div>
							</div>
						</div>
					</div>
					<%
								}
							}
						}
					%>
					<h1 style="color: white">Reservas Infantiles:</h1>
					<br></br>
					<div class="row">
						<%
						for (int i = 0; i < resI.size(); i++) {
							if(resI.get(i).getUserId().equals(customerBean.getEmailUser())){
								if(resI.get(i).getDate().compareTo(fecha)>0){
						%>
						<div class="col-md-12">
							<div class="ceb-item-style-2">
								<div class="ceb-infor">
										<p><%="ID de la reserva: " + resI.get(i).getId()%></p>
										<p><%="Bono: " + resI.get(i).getBonoId()%></p>
										<p><%="Fecha: " + resI.get(i).getDate()%></p>
										<p><%="Duración: " + resI.get(i).getDuration()%></p>
										<p><%="Precio: " + resI.get(i).getPrice()%></p>
										<p><%="Descuento: " + resI.get(i).getDiscount()%></p>
										<p><%="ID de la pista: " + resI.get(i).getPistId()%></p>
										<p><%="Nº de participantes: " + resI.get(i).getnChildren()%></p>
										<p><%="Estado: Por realizar"%></p>
										<hr>
										<a class="redbtn"
											href=<%="modifyReservaInfantil?ReservaId="
											+ resI.get(i).getId()%>
											style="border: none;  background-color: orange" type="submit">Modificar</a>
											&nbsp;
										<a class="redbtn"
											href=<%="deleteReserva?ReservaId="
											+ resI.get(i).getId()%>
											style="border: none" type="submit">Cancelar</a> <br></br>
								</div>
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