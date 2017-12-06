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
									<option value="" disabled selected>Select Subject</option>
								</select>
							</div>
							
							

						</div>
					</div>
					<br>
				
					<div class="row">
						<div class="col-sm-12">
						<div class="form-group col-sm-6" style="margin-bottom: 0px;">
								<select required class="form-control" name="subject_id"
									id="p-Exam-Type-box">
									<option value="" disabled selected> Select Exam Type</option>
								</select>
							</div>
							
							<div class="form-group col-sm-6" style="margin-bottom: 0px;">
								<select required class="form-control" name="semester"
									id="p-semester-box">
									<option value="" disabled selected> select Semester </option>
									<option value="1" > 1</option>
									<option value="2" > 2</option>
									<option value="3" >3 </option>
									<option value="4" >4 </option>
									<option value="5" >5 </option>
									<option value="6" >6 </option>
									<option value="7" >7 </option>
									<option value="8" >8 </option>
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
var subjectId;
var examTypeId;
var examTypeName;
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
		
		$("#p-subject-box").change(function(event) {
			load_exam_type(event, "p-Exam-Type-box");
		});
		
		$("#p-Exam-Type-box").change(function(event) {
			
			var getid = event.target.id;
			 examTypeId  = $('#' + getid).find(":selected").val();
			 examTypeName=$('#' + getid).find(":selected").text();
			//alert("examTypeId = "+examTypeId+" "+examTypeName+ " "+subjectId);
		});
		
		
		
		$("#searchbtnClicked").click(function(event) {
			
			
			var url=window.context + "/ApiSubject/GetSubjectByProgram";
			var method="GET";
			var data="";
			loadExamInformation(url,method,data);
		});
		
	});
	
	
	
	
	function load_exam_type(event,target){
		var getid = event.target.id;
		subjectId  = $('#' + getid).find(":selected").val();
		$.ajax({
			url : window.context + "/ApiExam_type/GetAllExam_type",
			method : "GET",
			dataType : 'json',
			cache : true,
			success : function(data) {
				var json = data;
				//console.log("json size=" + data.length);
				var content = '';
				content += "<option selected='true' > Select Exam Type </option>"
				for (var i = 0; i < data.length; i++) {
					var examTypeName = data[i].type_name;
					var examTypeNameId = data[i].exam_type_id;
					//console.log("faculty name =" + facultyName);

					content += '<option value='+examTypeNameId+'>' + examTypeName + '</option>';
				}
				$('#' + target).html(content);
			},
			error : function() {
				alert("Error...!!!");
			}
		});
	}

	function load_subject(e, target) {
		var getid = e.target.id;
		var id = $('#' + getid).find(":selected").val();
		$.ajax({
			url : window.context + "/ApiSubject/GetSubjectByParameters1/" + id,
			method : "GET",
			dataType : 'json',
			cache : true,
			success : function(data) {
				
				console.log("batch size=" + JSON.stringify(data));
				
				var content = '';
				content += "<option selected='true' > Select Subject </option>"
				for (var i = 0; i < data.length; i++) {
					content += '<option value='+data[i].subject_id +'>' + data[i].subject_name + '</option>';
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