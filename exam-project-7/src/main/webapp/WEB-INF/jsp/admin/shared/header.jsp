<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cp" scope="application">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html>
<html lang="en">
<head>

<spring:url value="/assets/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="/assets/css/style.css" var="style" />
<spring:url value="/assets/css/sidebar.css" var="sidebar" />
<spring:url value="/assets/css/select2.min.css" var="select2" />
<spring:url value="/assets/css/select2-bootstrap.min.css" var="select23" />
<spring:url value="/assets/css/bootstrap-editable.css" var="tableEditable" />
<spring:url value="/assets/font-awesome/css/font-awesome.min.css" var="fontAwasome" />
<spring:url value="/assets/css/style-responsive.css"
	var="styleresponsive" />
<spring:url value="/assets/css/profile.css" var="profile" />

<spring:url value="/assets/js/extraJs/jquery-3.2.1.min.js" var="jqueryJs" />
<spring:url value="/assets/js/extraJs/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/assets/js/default.js" var="defaultJs" />
<spring:url value="/assets/js/custome/custome_editableJs.js" var="custome_editableJs" />

<spring:url value="/assets/js/custome/reUsableJs.js" var="re-usableJs" />

<spring:url value="/assets/css/extraCss/datatables.min.css"
	var="datatablescss" />
	
<spring:url value="/assets/js/extraJs/datatables.min.js"
	var="datatablesJs" />
<spring:url value="/assets/js/select2.min.js"
	var="select2Js" />
	
	<spring:url value="/assets/js/bootstrap-editable.min.js"
	var="editableJs" />
	
	


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
<link href="${select2}" rel="stylesheet">
<link href="${select23}" rel="stylesheet">
<link href="${tableEditable}" rel="stylesheet">
<link href="${fontAwasome}" rel="stylesheet">



<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${datatablesJs}"></script>
<script src="${defaultJs}"></script>
<script src="${select2Js}"></script>
<script src="${editableJs}"></script>
<script src="${custome_editableJs}"></script>
<script src="${re-usableJs}"></script>

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