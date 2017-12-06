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
				
			</div>
		</div>
	</div>


	<table id="view_exam"
		class="table table-hover table-striped table-responsive"
		cellspacing="0" width="100%">
		<thead>
			<tr class="info">

				<th>Id</th>
				<th>Subject Name</th>
				<th>Exam Type</th>
				<th>Programe/Semester</th>
				<th>F.M</th>
				<th>P.M</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Status</th>
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
								<select required class="form-control" name="subject_id"
									id="p-subject-box">
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
	

	$(document).ready(function() {

		$("#modal-box").click(function(event) {
			load_faculty(event, "p-faculty-box");
		});
		$("#p-faculty-box").change(function(event) {
			load_program(event, "p-program-box");
		});
		$("#p-program-box").change(function(event) {
			load_subject(event, "p-subject-box");
		});
		
		$("#searchbtnClicked").click(function(event) {
			
			
			var url=window.context + "/ApiSubject/GetSubjectByProgram";
			var method="GET";
			var data="";
			loadExamInformation(url,method,data);
		});
		
	});

	function load_subjects(e, target) {
		var getid = e.target.id;
		var id = $('#' + getid).find(":selected").val();
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
	
	function loadExamInformation(url, method, data) {
		//alert(url+"  "+method+  +data);
		$('#view_exam').DataTable({
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
				"data" : "exam_id"
			}, {
				"data" : "subject_name"
			}, {
				"data" : "type_name"
			}, {
				data : null,
				render : function(data, type, row) {
					console.log(JSON.stringify(data));
					var statusStatus = "";

					if (data.status == 1) {
						statusStatus = "Running";
					} else if (data.status == 0) {
						statusStatus = "Not Running";
					}

					return '' + statusStatus + '';
				},
			}, {
				"data" : "full_marks"
			},
			{
				"data" : "pass_marks"
			},
			{
				"data" : "time_from"
			},
			{
				"data" : "time_to"
			}, {
				data : null,
				render : function(data, type, row) {
					console.log(JSON.stringify(data));
					var statusStatus = "";

					if (data.status == 1) {
						statusStatus = "Coming/Running";
					} else if (data.status == 0) {
						statusStatus = "Finished";
					}

					return '' + statusStatus + '';
				},
			},
			{
				data : null,
				render : function(data, type, row) {
					return '<button class="btn btn-success editBtns">Edit</button>';
				},
			} ]
		});

		// edit buttons on subjects row
		$('#view_exam tbody').on('click', '.editBtns', function() {
			var table = $("#view_exam").DataTable();
			var data = table.row($(this).parents('tr')).data();
			console.log(data);
			alert(data['exam_id'] + "' id is: " + data['exam_id']);
		});
	}

</script>