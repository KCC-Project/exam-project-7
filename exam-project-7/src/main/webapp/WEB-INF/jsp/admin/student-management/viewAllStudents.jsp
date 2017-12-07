<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="../shared/header.jsp" />

<div id="page-content-wrapper">
	<ol class="breadcrumb">
		<li><a href="admin-dashboard.jsp"><span
				class="glyphicon glyphicon-home"> Home</span></a></li>
		<li><a><span class="glyphicon glyphicon-education black">
					view</span></a></li>

	</ol>
	<!--=============================================Main Containt===============================  -->
	<div class="box box-default with-border">
		<div>
			<div style="margin: 0px; padding-left: 20px; height: 35px;">
				<a><button type="button" class="btn btn-info pull-right"
						data-toggle="modal" data-target="#searchStudentModal"
						id="modal-box">Filter</button></a>
				<div class="col-xs-3"
					style="margin-left: -34px; /* border: 2px solid black; */ height: 37px;">
					<div class="form-group">
						<div class="input-group">
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


	<table id="view_student" class="table table-hover table-striped table-responsive"
		cellspacing="0" width="100%">
		<thead>
			<tr class="info">
				<th>Id</th>
				<th>Image</th>
				<th>Name</th>
				<th>Username</th>
				<th>Gender</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Email</th>
				<th>current Semester</th>
				<th>Status</th>
				<th>Option</th>
			</tr>
		</thead>
	</table>


	<!--=========================================================================================  -->
	<div class="modal fade" id="searchStudentModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Students Search</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-12">
							<div class="col-sm-4">
								<div class="form-group " style="margin-bottom: 0px;">
									<select required class="form-control" id="p-faculty-box"
										name="faculty_id">
									</select>
								</div>
							</div>
							<div class="form-group col-sm-4" style="margin-bottom: 0px;">
								<select required class="form-control" id="p-program-box"
									name="program_id">
									<option value="" disabled selected>Select Programme</option>
								</select>
							</div>
							<div class="form-group col-sm-4" style="margin-bottom: 0px;">
								<select required class="form-control" name="batch_id"
									id="p-batch-box">
									<option value="" disabled selected>Select Batch</option>
								</select>
							</div>

						</div>
					</div>
					<br>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-success"
							id="searchbtnClicked" data-dismiss="modal">Search</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--=========================================================================================  -->
<jsp:include page="../shared/footer.jsp" />
<script>
	var programId = 0;
	var batchyear = 0;

	$(document).ready(function() {

		$("#modal-box").click(function(event) {
			load_faculty(event, "p-faculty-box");
		});
		$("#p-faculty-box").change(function(event) {
			load_program(event, "p-program-box");
		});
		$("#p-program-box").change(function(event) {
			load_batch_year(event, "p-batch-box");
		});
		$("#searchbtnClicked").click(function(event) {
			load_student(event, "student-batch-box");
		});
		$("#student-batch-box").change(function(event) {
			var getid = event.target.id;
			var id = $('#' + getid).find(":selected").val();
			loadStudentInformation(id);
		});
		$("#p-batch-box").change(function(event) {
			var getid = event.target.id;
			var id = $('#' + getid).find(":selected").val();
			batchyear = id;
		});
		
		
		//For select 2 initialization
		var url1=window.context + "/ApiStudent/SearchStudent";
		var method1="POST";
		var url2= window.context + "/ApiStudent/GetStudent";
		var method2="GET";
		var placeholder="Student";
		select2Function(url1,url2,method1,method2,placeholder,loadStudentInformation);

	});


	function load_batch_year(e, target) {
		var getid = e.target.id;
		var id = $('#' + getid).find(":selected").val();
		programId = id;
		$.ajax({
			url : window.context + "/ApiStudentsProgram/GetStudentsProgramByProgramId/" + id,
			method : "GET",
			dataType : 'json',
			cache : true,
			success : function(data) {
				//console.log("simple data=" + data);
				//console.log("batch size=" + JSON.stringify(data));
				var lengt = data.length;
				var duplicateYear = [];
				var content = '';
				content += "<option selected='true' > Select Batch </option>"
				for (var i = 0; i < data.length; i++) {

					duplicateYear[i] = data[i].batch_year;
					var batch_yearDate = data[i].batch_year;
					var batch_yearId = data[i].student_program_id;
					//console.log("batch_yearDate name ="	+ batch_yearDate);

				}

				var uniqueYear = duplicateYear.filter(function(x, i, a) {
					return a.indexOf(x) == i;
				});

				for (var i = 0; i < uniqueYear.length; i++) {
					//batchyear = uniqueYear[i];
					content += '<option value='+uniqueYear[i] +'>' + uniqueYear[i] + '</option>';
				}

				$('#' + target).html(content);
			},
			error : function() {
				alert("Error...!!!");
			}
		});
	}

	function load_student(e, target) {
		//alert(programId);
		//alert(batchyear);
		var url = window.context + "/ApiStudent/SearchStudentsByProgram";
		var method = "POST";
		//var data = "{'programId':'" + programId + "','batchyear':'" + batchyear + "'}";
		var data = {"programId":  programId  ,"batchyear":  batchyear };
		loadStudentInformation(url,method,data);
	}

	

	
</script>