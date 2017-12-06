

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	isELIgnored="false"%>


<jsp:include page="../shared/header.jsp" />

<!-- Content Area -->
<div id="page-content-wrapper">

	<ol class="breadcrumb">
		<li><a href="${cp}/home"><span class="glyphicon glyphicon-home"> Home </span></a></li>
		<li><a><span class="glyphicon glyphicon-user black"> View Subject </span></a></li>
	</ol>


	<div class="box box-default with-border">
		<div>
			<div style="margin: 0px; padding-left: 20px; height: 35px;">
				<a><button type="button" class="btn btn-info pull-right" data-toggle="modal"
						data-target="#searchSubjectModal" id="modal-box">Filter</button></a>
				<div class="col-xs-3" style="margin-left: -34px; /* border: 2px solid black; */ height: 37px;">
					<div class="form-group">
						<div class="input-group">
							<select class="form-control" id="sel1"></select> <span class="input-group-addon"> <i
								class="fa fa-search"></i>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!--=========================================================================================  -->
	<div class="modal fade" id="searchSubjectModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Subject Search</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-12">
							<div class="col-sm-6">
								<div class="form-group " style="margin-bottom: 0px;">
									<select required class="form-control" id="p-faculty-box" name="faculty_id">
									</select>
								</div>
							</div>
							<div class="form-group col-sm-6" style="margin-bottom: 0px;">
								<select required class="form-control" id="p-program-box" name="program_id">
									<option value="" disabled selected>Select Program</option>
								</select>
							</div>
							<div class="col-sm-12 form-group">
								<h4 class="text-danger">The fields Below are Optional</h4>
							</div>

							<div class="row form-group">
								<div class="col-sm-4">
									<label class="control-label">Subject Name</label>
									<div class="input-group">
										<input name="s_subject_name" placeholder="Enter Subject Name" class="form-control"
											type="text">
									</div>
								</div>

								<div class="col-sm-4">
									<label class=" control-label">Subject Code</label>
									<div class="input-group">
										<input name="s_subject_code" placeholder="Enter Subject code" class="form-control"
											type="text">
									</div>
								</div>
								<div class="col-sm-4">
									<label>Semester no.: </label> <select class="form-control" id="s-semester-no"
										name="s_semester_no">
										<option value="" selected>Select Semester</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
									</select>
								</div>

							</div>

						</div>
					</div>
					<br>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-success" id="searchbtnClicked" data-dismiss="modal">Search</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="editSubjectModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Subject Search</h4>
				</div>
				<div class="modal-body">

					<form class="well form-horizontal" action=" " method="post" id="contact_form">
						<fieldset>

							<!-- Form Name -->
							<legend>Contact Us Today!</legend>

							<!-- Text input-->

							<div class="form-group">
								<label class="col-md-4 control-label">Subject Name</label>
								<div class="col-md-4 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i class="glyphicon glyphicon-book"></i></span> <input
											name="subject_name" placeholder="Enter Subject Name" class="form-control" type="text">
									</div>
								</div>
							</div>

							<!-- Text input-->

							<div class="form-group">
								<label class="col-md-4 control-label">Subject Code</label>
								<div class="col-md-4 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> <input
											name="subject_code" placeholder="Enter Subject Code" class="form-control" type="text">
									</div>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="control-label col-md-2 col-md-offset-2" for="id_title">Subject Credit</label>
								<div class="col-md-8">

									<div class="col-md-4 inputGroupContainer">
										<div class="input-group">
											<input class="form-control" placeholder="Enter Subject theory_credit" type="text"
												name="theory_cr">
										</div>
									</div>
									<div class="col-md-4 inputGroupContainer">
										<div class="input-group">
											<input class="form-control" placeholder="Enter Subject tutorial_credit" type="text"
												name="tutorial_cr">
										</div>
									</div>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="control-label col-md-2 col-md-offset-2" for="id_title">Subject Marks</label>
								<div class="col-md-8">

									<div class="col-md-3 inputGroupContainer">
										<div class="input-group">
											<input class="form-control" placeholder="Enter Internal_theory marks" type="text"
												name="internal_theory">
										</div>
									</div>
									<div class="col-md-3 inputGroupContainer">
										<div class="input-group">
											<input class="form-control" placeholder="Enter Internal_practical marks" type="text"
												name="internal_practical">
										</div>
									</div>
									<div class="col-md-3 inputGroupContainer">
										<div class="input-group">
											<input class="form-control" placeholder=" Enter Final_theory marks" type="text"
												name="final_theory">
										</div>
									</div>
								</div>
							</div>


							<!-- Select Basic -->
							<div class="form-group">
								<label class="control-label col-md-2 col-md-offset-2" for="id_title">Subject Program</label>
								<div class="col-md-8">
									<div class="col-md-3 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span> <select
												required class="form-control" id="p-faculty-box" name="faculty_id">
											</select>
										</div>
									</div>

									<div class="col-md-3 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span> <select
												required class="form-control" id="p-program-box" name="program_id" required>
											</select>
										</div>
									</div>
								</div>
							</div>


							<!-- radio checks -->
							<div class="form-group">
								<label class="col-md-4 control-label">This Subject is avilable ?</label>
								<div class="col-md-4">

									<div class="form-group">
										<div class="radio">
											<label> <input type="radio" value=0 name="status" checked required> Yes
											</label>
										</div>

										<div class="radio">
											<label> <input type="radio" value=1 name="status" required> No
											</label>
										</div>
									</div>

								</div>
							</div>


							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label"></label>
								<div class="col-md-4">
									<button type="submit" class="btn btn-warning">
										Send <span class="glyphicon glyphicon-send"></span>
									</button>
								</div>
							</div>
						</fieldset>
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>



	<table id="view_subject" class="table table-hover table-striped" cellspacing="0" width="100%">
		<thead>
			<tr class="info">
				<th>Id</th>
				<th>Subject_name</th>
				<th>Subject_code</th>
				<th>Subject_credit</th>
				<th>Subject_marks</th>
				<th>Syllabus_file</th>
				<th>Program_id</th>
				<th>Semester_no</th>
				<th>Option</th>
			</tr>
		</thead>
	</table>

	<script>
        var programId = 0;

        $(document).ready(function () {

            // hiding table view
            //$("#view_subject").hide();
            $("#modal-box").click(function (event) {
                load_faculty(event, "p-faculty-box");
            });

            $("#p-faculty-box").change(function (event) {
                load_program(event, "p-program-box");
            });

            $("#searchbtnClicked").click(function (event) {
                load_subject(event);
            });

            // when view all subject button is clicked
            $("#view-all-subject").click(function () {
                if (confirm('Do you want to load All Subjects ? ')) {
                    var url = window.context + "/ApiSubject/GetAllSubject";
                    var method = "GET";
                    var data = "";
                    loadSubjectInformation(url, method, data);
                } else {
                    return false;
                }
            });

            //For select 2 initialization
            var url1 = window.context + "/ApiSubject/SearchSubject";
            var method1 = "POST";
            var url2 = window.context + "/ApiSubject/GetSubject";
            var method2 = "GET";
            var placeholder = "Subject Name";
            select2Function(url1, url2, method1, method2, placeholder, loadSubjectInformation);

        });

        function load_subject(e) {
            //alert(programId);
            //alert(batchyear);
            var semester_no = $('#s-semester-no').val();
            var url = window.context + "/ApiSubject/SearchSubject";
            var method = "POST";
            var data = "{'programId':'" + programId + "','semester_no':'" + semester_no + "'}";

            loadSubjectInformation(url, method, data);
        }

        // when load all subject is clicked
        function loadSubjectInformation(url, method, data) {
            // Initializing Datatable
            $('#view_subject').DataTable({
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
                    "data" : "subject_id"
                }, {
                    "data" : "subject_name"
                }, {
                    "data" : "subject_code"
                }, {
                    data : null,
                    render : function (data, type, row) {
                        console.log(data);
                        // Combine the two data
                        return 'Theory_credit: ' + data.theory_cr + '</br> Tutorial_credit: ' + data.tutorial_cr;
                    },
                }, {
                    data : null,
                    render : function (data, type, row) {
                        // Combine the two data
                        return 'Internal Theory: ' + data.internal_theory + '</br> Practical Marks: ' + data.internal_practical + '</br>  Final Theory: ' + data.final_theory;
                    },
                }, {
                    "data" : "syllabus_file",
                    render : function (data, type, row) {
                        // Combine the two data
                        return '<a href='+window.context +'file/'+data+'>view Syllabus</a>';
                    },
                }, {
                    "data" : "program_id",
                    render : function (data, type, row) {
                        return '<a href='+ window.context +'/program/'+data+'>Program_id: ' + data + '</a>';
                    },
                }, {
                    "data" : "semester_no"
                }, {
                    data : null,
                    render : function (data, type, row) {
                        return '<button class="btn btn-success editBtns">Click!</button>';
                    },
                } ]
            });

            // edit buttons on subjects row
            $('#view_subject tbody').on('click', '.editBtns', function () {
                var table = $("#view_subject").DataTable();
                var data = table.row($(this).parents('tr')).data();
                console.log(data);
                $('#editSubjectModal').modal('show');
            });

        }
    </script>


</div>

<jsp:include page="../shared/footer.jsp" />