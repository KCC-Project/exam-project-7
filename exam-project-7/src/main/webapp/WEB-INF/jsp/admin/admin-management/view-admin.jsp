<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" scope="application">${pageContext.request.contextPath}</c:set>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <c:if test = "${ empty sessionScope.adminUserName }">
         <c:redirect url = "/index "/>
      </c:if>
          
<jsp:include page="../shared/header.jsp" />

<div id="page-content-wrapper">
	<ol class="breadcrumb">
		<li><a href="admin-dashboard.jsp"><span
				class="glyphicon glyphicon-home"> Home</span></a></li>
		<li><a><span class="glyphicon glyphicon-education black">
					Setting</span></a></li>
					<li><a><span class="glyphicon glyphicon-education black">
					Admin</span></a></li>

	</ol>
	<!--=============================================Main Containt===============================  -->
	<div class="box box-default with-border">
		<div>
			<div style="margin: 0px; padding-left: 20px; height: 35px;">
				<a><button type="button" class="btn btn-info pull-right"
						data-toggle="modal" id="modal-box-vew-all-admin">View
						All</button></a>
				<div class="col-xs-3"
					style="margin-left: -34px; /* border: 2px solid black; */ height: 37px;">
					<div class="form-group">
						<div class="input-group" id="sel1div">
							<select class="form-control" id="sel1"></select> <span
								class="input-group-addon"> <i class="fa fa-search"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="col-xs-7 " id="sembtn"></div>
			</div>
		</div>
	</div>


	<table id="view_admin"
		class="table table-hover table-striped table-responsive"
		cellspacing="0" width="100%">
		<thead>
			<tr class="info">
				<th>Id</th>
				<th>Name</th>
				<th>Password</th>
				<th>Status</th>
				<th>Option</th>
			</tr>
		</thead>
	</table>


	<!--=========================================================================================  -->
	
</div>
<!--=========================================================================================  -->
<jsp:include page="../shared/footer.jsp" />
<script>
	$(document).ready(function() {
		
		var url1=window.context + "/ApiAdmin/SearchAdmin";
		var method1="POST";
		var url2=window.context + "/ApiAdmin/GetAdmin";
		var method2="GET";
		var placeholder="Admin";
		select2Function(url1,url2,method1,method2,placeholder,loadAdminInformation);
		
	
		$("#modal-box-vew-all-admin").click(function(event) {
			var url = window.context + "/ApiAdmin/GetAllAdmin";
			var method = "GET";
			var data = "";
			loadAdminInformation(url, method, data);
		});
	});

	

	function loadAdminInformation(url, method, data) {
		$('#view_admin').DataTable({
			destroy : true,
			paging : true,
			searching : true,
			"processing" : true,
			"serverSide" : false,
			"ajax" : {
				"url" : url,
				"type" : method,
				"data" : data,
				"dataSrc" : "",
				"dataType" : "json",
				"async" : false
			},
			"columns" : [ {
				"data" : "admin_id"
			}, {
				"data" : "admin_username"
			},  {
				"data" : "admin_password"
			},{
				data : null,
				render : function(data, type, row) {
					console.log(JSON.stringify(data));
					var statusStatus = "";

					if (data.status == 1) {
						statusStatus = "Active";
					} else if (data.status == 0) {
						statusStatus = "Not Active";
					}

					return '' + statusStatus + '';
				},
			}, {
				data : null,
				render : function(data, type, row) {
					return '<button class="btn btn-success editBtns">Edit</button>';
				},
			} ]
		});

		// edit buttons on subjects row
		$('#view_admin tbody').on('click', '.editBtns', function() {
			var table = $("#view_admin").DataTable();
			var data = table.row($(this).parents('tr')).data();
			console.log(data);
			alert(data['admin_username'] + "' id is: " + data['admin_id']);
		});
	}
</script>