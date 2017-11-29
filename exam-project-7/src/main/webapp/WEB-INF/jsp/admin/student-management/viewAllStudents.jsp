<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
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
					</tr>
				</tfoot>
				
				<tbody>
				<tr>
					<th>s-Id</th>
						<td>first_name</td>
						<td>middle_name</td>
						<td>last_name</td>
						<td>Date_of_birth</td>
						<td>phone</td>
						<td>address</td>
						<td>city</td>
						<td>district</td>
						<td>zipcode</td>
				</tr>
				</tbody>
				 
			</table>
			
			<script>
			$('#viewStudents').DataTable( {
		        "processing": true,
		        "serverSide": true,
		        "ajax": {
		            "url": "http://localhost:8080/exam-system/json/students/all",
		            "type": "GET"
		        },
		        "columns": [
		        	{ "data": "s_id" },
		            { "data": "first_name" },
		            { "data": "middle_name" },
		            { "data": "last_name" },
		            { "data": "date_of_birth" },
		            { "data": "phone" },
		            { "data": "address" },
		            { "data": "city" },
		            { "data": "zipcode" },
		        ]
		    } );
			
			</script>