

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<jsp:include page="../shared/header.jsp" />

<!-- Content Area -->
<div id="page-content-wrapper">
	<table id="view_subject" class="table table-hover table-striped" cellspacing="0" width="100%">
		<thead>
			<tr>
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
		<tfoot>
			<tr>
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
		</tfoot>
	</table>


	<script>
        $(document).ready(function () {
            $('#view_subject').DataTable({
                "processing" : true,
                "serverSide" : true,
                "ajax" : {
                    "url" : window.context + "/ApiSubject/GetAllSubject",
                    "type" : "GET",
                    "dataSrc": "",
                    "contentType": "application/json",
                    "dataType": "json"
                },
                "columns" : [ {
                    "data" : "subject_id"
                }, {
                    "data" : "subject_name"
                }, {
                    "data" : "subject_code"
                }, {
                    data: null,
                    render: function ( data, type, row ) {
                        // Combine the two data
                        return 'Theory_credit: '+data.theory_cr+'</br> Tutorial_credit: '+data.tutorial_cr;
                    },
                }, {
                    data: null,
                    render: function ( data, type, row ) {
                        // Combine the two data
                        return 'Internal Theory: '+data.internal_theory+'</br> Practical Marks: '+data.internal_practical+'</br>  Final Theory: '+data.final_theory;
                    },
                }, {
                    "data" : "syllabus_file",
                    render: function ( data, type, row ) {
                        // Combine the two data
                        return '<a href='+window.context +'file/'+data+'>view Syllabus</a>';
                    },
                }, {
                    "data" : "program_id",
                    render: function ( data, type, row ) {
                        return '<a href='+ window.context +'/program/'+data+'>Program_id: '+data+'</a>';
                    },
                }, {
                    "data" : "semester_no"
                }, {
                    data: null,
                    render: function ( data, type, row ) {
                        return '<button class="btn btn-success editBtns">Click!</button>';
                    },
                } ]
            });
            
            $('#view_subject tbody').on( 'click', '.editBtns', function () {
                var table = $("#view_subject").DataTable();
                 var data = table.row( $(this).parents('tr') ).data();
                 console.log(data);
                 alert( data['subject_name'] +"' id is: "+ data[ 'subject_id' ] );
             } );
            
            
        });
    </script>


</div>

<jsp:include page="../shared/footer.jsp" />