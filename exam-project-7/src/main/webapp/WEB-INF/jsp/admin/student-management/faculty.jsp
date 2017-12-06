<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../shared/header.jsp" />

<div id="page-content-wrapper">
	<ol class="breadcrumb">
		<li><a href="${cp}/home""><span class="glyphicon glyphicon-home"> Home</span></a></li>
		<li><a><span class="glyphicon glyphicon-education black"> Education</span></a></li>
		<li><a><span class="glyphicon glyphicon-education black"> Faculty</span></a></li>

	</ol>


	<table id="view_faculty" class="table table-hover table-striped table-responsive" cellspacing="0"
		width="100%">
		<thead>
			<tr class="info">
				<th>Id</th>
				<th>Faculty_name</th>
				<th>Status</th>
				<th>Option</th>
			</tr>
		</thead>
	</table>

	<div class="modal fade" id="faculty-edit-modal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit Faculty</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<h4 class="faculty_id">Id: {id} - {faculty_name}</h4>
					</div>

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
					<br>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-success" id="updateClicked" data-dismiss="modal">Update</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<!--=========================================================================================  -->
<jsp:include page="../shared/footer.jsp" />
<script>
    $(document).ready(function () {
        
        $('#faculty-edit-modal').modal({ show: false})

        var url = window.context + "/ApiFaculty/GetAllFaculty";
        var method = "GET";
        var data = "";
        loadFacultyInformation(url, method, data);

        function loadFacultyInformation(url, method, data) {
            $('#view_faculty').DataTable({
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
                    "data" : "faculty_id"
                }, {
                    "data" : "faculty_name"
                }, {
                    "data" : "status"
                }, {
                    data : null,
                    render : function (data, type, row) {
                        return '<button class="btn btn-success editBtns">Edit</button>';
                    },
                } ]
            });

            // edit buttons on subjects row
            $('#view_faculty tbody').on('click', '.editBtns', function () {
                var table = $("#view_faculty").DataTable();
                var data = table.row($(this).parents('tr')).data();
                $('#faculty-edit-modal').modal('show');
                alert(data['faculty_name'] + "' id is: " + data['faculty_id']);

            });
        }

    });
</script>