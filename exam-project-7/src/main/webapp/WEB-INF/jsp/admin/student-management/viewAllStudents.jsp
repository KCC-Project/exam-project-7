<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <jsp:include page="../shared/header.jsp" />

<body>

	<!-- Content Area -->
	<div id="page-content-wrapper">
    
    <table id="viewStudents" class="table table-striped table-bordered">
				<thead>
					<tr> 
						<th>s-Id</th>
						<th>first_name</th>
						<th>middle_name</th>
						<th>last_name</th>
						<th>Date_of_birth</th>
						<th>phone</th>
						<th>address</th>
						<th>city</th>
						<th>district</th>
						<th>zipcode</th>
						<th>Option</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>s-Id</th>
						<th>first_name</th>
						<th>middle_name</th>
						<th>last_name</th>
						<th>Date_of_birth</th>
						<th>phone</th>
						<th>address</th>
						<th>city</th>
						<th>district</th>
						<th>zipcode</th>
						<th>Option</th>
					</tr>
				</tfoot>
				 
			</table>
			
			<script>
			$('#viewStudents').DataTable( {
		        "processing": true,
		        "serverSide": true,
		        "ajax": {
		        	"contentType": "application/json",
		        	"type": "GET",
		            "url": window.context + "/ApiStudent/GetAllStudent",
		            "dataType": "json",
		            "dataSrc": "",
		        },
		        "columns": [
		        	{ "data": "s_id" },
		            { "data": "first_name" , "defaultContent": "" },
		            { "data": "middle_name" , "defaultContent": "" },
		            { "data": "last_name" , "defaultContent": "" },
		            { "data": "date_of_birth" , "defaultContent": "" },
		            { "data": "phone" , "defaultContent": "" },
		            { "data": "address" , "defaultContent": "" },
		            { "data": "city" , "defaultContent": ""},
		            { "data": "district" , "defaultContent": "" },
		            { "data": "zipcode" , "defaultContent": "" },
		            
		            {
		                "data": null,
		                "defaultContent": "<button class='btn btn-success editBtns'>Edit!</button>",
		                "targets": -1
		              }
		        ]
		    } );
			
			 $('#viewStudents tbody').on( 'click', '.editBtns', function () {
				 var table = $('#viewStudents').DataTable();
			        var data = table.row( $(this).parents('tr') ).data();
			        alert( data[0] +"'s salary is: "+ data[ 1 ] );
			    } );
			
			
			</script>
			
			
			
			</div>

	<jsp:include page="../shared/footer.jsp" />