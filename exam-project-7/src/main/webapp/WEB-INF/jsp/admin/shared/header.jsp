<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cp" scope="application">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html>
<html lang="en">
<head>

<spring:url value="/assets/css/extraCss/bootstrap.min.css" var="bootstrap" />
<spring:url value="/assets/css/style.css" var="style" />
<spring:url value="/assets/css/sidebar.css" var="sidebar" />
<spring:url value="/assets/css/style-responsive.css"
	var="styleresponsive" />
<spring:url value="/assets/css/profile.css" var="profile" />

<spring:url value="/assets/js/extraJs/jquery-3.2.1.min.js" var="jqueryJs" />
<spring:url value="/assets/js/extraJs/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/assets/js/default.js" var="defaultJs" />

<spring:url value="/assets/css/extraCss/datatables.min.css"
	var="datatablescss" />
	
<spring:url value="/assets/js/extraJs/datatables.min.js"
	var="datatablesJs" />



<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MIS</title>

<!-- Bootstrap core CSS -->
<link href="${bootstrap }" rel="stylesheet">
<link href="${style }" rel="stylesheet">
<link href="${sidebar }" rel="stylesheet">
<link href="${styleresponsive }" rel="stylesheet">
<link href="${profile}" rel="stylesheet">
<link href="${datatablescss}" rel="stylesheet">


<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${datatablesJs}"></script>
<script src="${defaultJs}"></script>


<script>
	window.context = '${cp}';
</script>
</body>

</head>
<body>
	<!-- --------------------------------------  -->
	<div class="container-fluid dashboard-container">
		<div class="row">
			<header id="dashboard-header">

				<!-- Side-bar toggler -->

				<!-- Dash info display -->
				<div class="hidden-xs pull-left" id="dash-info">
					<h4>
						<a href="#menu-toggle" class="btn btn-default menu-toggle">Toggle
							Menu</a> <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						Dashboard <small>Manage</small>

					</h4>
				</div>

				<!-- Dashboard search bar -->
				<div class="search-field pull-left">
					<input type="text" placeholder="search" class="form-control">
				</div>
			</header>
		</div>
	</div>

	<div id="wrapper">
		<div id="sidebar-wrapper">
			<jsp:include page="admin-sidemenu.jsp" />
		</div>


		<!-- ------------------------------------------ -->