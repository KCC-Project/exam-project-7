<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../shared/header.jsp" />

<div id="page-content-wrapper">
	<ol class="breadcrumb">
		<li><a href="${cp}/home""><span class="glyphicon glyphicon-home"> Home</span></a></li>
		<li><a><span class="glyphicon glyphicon-education black"> Education</span></a></li>
		<li><a><span class="glyphicon glyphicon-education black"> Program</span></a></li>

	</ol>
	<!--=============================================Main Containt===============================  -->
	<div class="box box-default with-border">
		<div>
			<div style="margin: 0px; padding-left: 20px; height: 35px;">
				<a><button type="button" class="btn btn-info pull-right" data-toggle="modal"
						id="modal-box-vew-all-program">View All</button></a>
				<div class="col-xs-3" style="margin-left: -34px; /* border: 2px solid black; */ height: 37px;">
					<div class="form-group">
						<div class="input-group">
							<select class="form-control" id="sel1"></select> <span class="input-group-addon"> <i
								class="fa fa-search"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="col-xs-7 " id="sembtn"></div>
			</div>
		</div>
	</div>


	<table id="view_program" class="table table-hover table-striped table-responsive" cellspacing="0"
		width="100%">
		<thead>
			<tr class="info">
				<th>Id</th>
				<th>Program Name</th>
				<th>Year</th>
				<th>Total Credit</th>
				<th>Status</th>
				<th>Faculty Name</th>
				<th>Option</th>
			</tr>
		</thead>
	</table>



</div>
<!--=========================================================================================  -->
<jsp:include page="../shared/footer.jsp" />
<script>
    $(document).ready(function () {

        var url1 = window.context + "/ApiProgram/SearchProgram";
        var method1 = "POST";
        var url2 = window.context + "/ApiProgram/GetProgram";
        var method2 = "GET";
        var placeholder = "Program";
        select2Function(url1, url2, method1, method2, placeholder, loadProgramInformation);

        $("#modal-box-vew-all-program").click(function (event) {
            var url = window.context + "/ApiProgram/GetAllProgram";
            var method = "GET";
            var data = "";
            loadProgramInformation(url, method, data);
        });
    });

    function loadProgramInformation(url, method, data) {
        $('#view_program').DataTable({
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
                "data" : "program_id"
            }, {
                "data" : "program_name"
            }, {
                "data" : "program_years"
            }, {
                "data" : "total_credit"
            }, {
                data : null,
                render : function (data, type, row) {
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
                "data" : "faculty_id"
            }, {
                data : null,
                render : function (data, type, row) {
                    return '<button class="btn btn-success editBtns">Edit</button>';
                },
            } ]
        });

        // edit buttons on subjects row
        $('#view_program tbody').on('click', '.editBtns', function () {
            var table = $("#view_program").DataTable();
            var data = table.row($(this).parents('tr')).data();
            console.log(data);
            alert(data['program_name'] + "' id is: " + data['program_id']);
        });
    }
</script>