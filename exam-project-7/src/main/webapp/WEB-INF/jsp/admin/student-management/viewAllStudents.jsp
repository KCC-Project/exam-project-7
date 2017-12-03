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
			<!--====================================================Table==================================================================  -->
			<div class="box box-primary with-border" style="margin-top: 10px;">
				<div class="row with-border" style="overflow: hidden;">
					<div class="col-lg-12 ">
						<h3 style="margin: 0px; padding-left: 20px; height: 35px;">
							<span class="hidden-xs"
								style="position: absolute; margin-top: 5px; color: #3c8dbc"><i
								class="fa fa-graduation-cap"></i> Student View</span> <span
								class="visible-xs"
								style="position: absolute; margin-top: 5px; color: #3c8dbc"><i
								class="fa fa-graduation-cap"></i> Student View</span>

							<button
								class="btn-sm btn btn-default pull-right viewAccountDetail"
								style="margin-top: 5px; margin-right: 10px;"
								title="View Account Details" data-toggle="modal"
								data-target="#viewAccountDetail" id="#viewAccountDetail">
								<i class="fa fa-eye"></i>
							</button>
						</h3>
					</div>
				</div>
				<!-- Regular exam -->
				<div class="box-body " style="margin-bottom: 4px;">
					<div id="accordion" class="box-group">
						<div class="panel box box-default">
							<div class="box-header with-border">
								<br>
								<div class="table-responsive">
									<table class="table table-bordered" id="tblStudent">
										<thead>
											<tr class="info">
												<td>S.No</td>
												<td>F.Name</td>
												<td>M.name</td>
												<td>L.Name</td>
												<td>Phone</td>
												<td>Address</td>
											</tr>
										</thead>
										<tbody id="load_student_info">
										</tbody>
									</table>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
<br>
<br>
	<!--====================================================Table==================================================================  -->
			<div class="box box-primary with-border" style="margin-top: 10px;">
				<div class="row with-border" style="overflow: hidden;">
					<div class="col-lg-12 ">
						<h3 style="margin: 0px; padding-left: 20px; height: 35px;">
							<span class="hidden-xs"
								style="position: absolute; margin-top: 5px; color: #3c8dbc"><i
								class="fa fa-graduation-cap"></i> Additional Information </span> <span
								class="visible-xs"
								style="position: absolute; margin-top: 5px; color: #3c8dbc"><i
								class="fa fa-graduation-cap"></i> Additional Information </span>
						</h3>
					</div>
				</div>
				<!-- Regular exam -->
				<div class="box-body " style="margin-bottom: 4px;">
					<div id="accordion" class="box-group">
						<div class="panel box box-default">
							<div class="box-header with-border">
								<br>
								<div class="table-responsive">
									<table class="table table-bordered" id="tblStudent_additional">
										<thead>
											<tr class="info">
											
												<td>District</td>
												<td>City</td>
												<td>Email</td>
												<td>DOB</td>
												<td>Registration Date</td>
												<td>Status</td>
												
												
											</tr>
										</thead>
										<tbody id="additional_student_info">
										</tbody>
									</table>
								</div>
							
							</div>
						</div>
					</div>
				</div>
			</div>

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
									<div class="col-sm-3">
										<div class="form-group " style="margin-bottom: 0px;">
											<select required class="form-control" id="p-faculty-box"
												name="faculty_id">
											</select>
										</div>
									</div>
									<div class="form-group col-sm-3" style="margin-bottom: 0px;">
										<select required class="form-control" id="p-program-box"
											name="program_id">
											<option value="" disabled selected>Select Programme</option>
										</select>
									</div>
									<div class="form-group col-sm-3" style="margin-bottom: 0px;">
										<select required class="form-control" name="batch_id"
											id="p-batch-box">
											<option value="" disabled selected>Select Batch</option>
										</select>
									</div>
									<div class="form-group col-sm-3" id="semester-batch"
										style="margin-bottom: 0px;">
										<select required class="form-control" id="Semester_box"
											name="Semester_box">
											<option value="" disabled selected>Select Semester</option>
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
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
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
	
	$(document).ready(function(){
		
		$("#modal-box").click(function(event){ load_faculty(event, "p-faculty-box");});
		$("#p-faculty-box").change(function(event){ load_program(event, "p-program-box"); });
		$("#p-program-box").change(function(event){ load_batch_year(event, "p-batch-box"); });
		
		
		
	});
	function load_faculty(e, target) {
		var url=window.context +"/ApiDepartment/GetAllDepartment";
		var aj=new XMLHttpRequest();
		aj.open("GET", url, true);
		aj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		aj.onreadystatechange=function(){
			if (aj.readyState==4&&aj.status==200) {
				var return_data=aj.responseText;
				alert(return_data);
				//$('#' + target).html(return_data);
			}
		}
		aj.send();
	}
	
	
	$("select").select2({
	    theme : "bootstrap",
	    width : "auto"
	});
	
	$("#sel1").select2(
			{
			    theme : "bootstrap",
			    width : "210px",
			    //width:auto,
			    height : "10px",
			    minimumInputLength : 3,
			    placeholder : "Search for a student",
			    ajax : {
				url : window.context +"/ApiStudent/SearchStudent",
				dataType : 'json',
				type : "POST",
				delay : 400,
				data : function(params) {
				    //console.log("params="   + params.term);
				    return {
					val : params.term,
					page : params.page
				    };
				},
				processResults : function(data,
					params) {
				   // console.log("returned data from server =" + JSON.stringify(data));
				 //   console.log("full name = " + data.first_name + " "+data.last_name);
				    //.log("id= " + data.s_id);
				    params.page = params.page || 1;
				    return {
					results : data,
					pagination : {
					    more : (params.page * 30) < data.total_count
					}
				    };
				},
				cache : true
			    },
			    escapeMarkup : function(markup) {
				return markup;
			    },
			    templateResult : formatRepo,
			    templateSelection : formatRepoSelection
			}).on("change", function(e) {
		    var selected_element = $(e.currentTarget);
		    console.log(selected_element);
		    var select_val = selected_element.val();
		    console.log("Student Id=" + select_val);
		    loadStudentInformation(select_val);
		});
	
	function formatRepo(repo) {
		// console.log("formated repo=" + JSON.stringify(repo));
	    if (repo.loading)
		return repo.text;
	    var markup = '<option value='+repo.id+'>'
		    + repo.name + '</option>';
	    return markup;
	}
	function formatRepoSelection(repo) {
		 return repo.name || repo.text;
	}
	
	function loadStudentInformation(val) {

	    $
		    .ajax({
			url : window.context +"/ApiStudent/GetStudent/"+val,
			method : "GET",
			dataType : 'json',
			cache : true,
			data : {
			    student_id : val
			},
			success : function(data) {
			  //  var obj = JSON.parse(data);
			    console.log("json size=" + JSON.stringify(data));
			    $("#tblStudent").show();
			    
			    
					var content = '';
				
						content += '<tr>';
						content += '<td  class="student_sn">' + 1 + '</td>';
						content += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"text\" class=\"fname\" id='student_name'>"
								+ data.first_name + "</td>";
								content += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"text\" class=\"mname\" id='student_name'>"
								+ data.middle_name + "</td>";	
								content += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"text\" class=\"lname\" id='student_name'>"
								+ data.last_name + "</td>";	
								content += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"number\" class=\"phone\" id='student_name'>"
								+ data.phone + "</td>";	
								content += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"text\" class=\"address\" id='student_name'>"
								+ data.address + "</td>";	
						content += '<tr>';
						
					
					$("#load_student_info").html(content);
				
			
					
					
					
					
					 $("#tblStudent_additional").show();
					var content1 = '';
					
					content1 += '<tr>';
				
					content1 += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"text\" class=\"district\" id='student_name'>"
							+ data.district + "</td>";
							content1 += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"text\" class=\"city\" id='student_name'>"
							+ data.city + "</td>";	
							content1 += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"text\" class=\"email\" id='student_name'>"
							+ data.last_name + "</td>";	
							content1 += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"date\" class=\"dob\" id='student_name'>"
							+ data.date_of_birth + "</td>";	
								
							content1 += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"date\" class=\"regdate\" id='student_name'>"
							+ data.registeredDate + "</td>";	
							content1 += "<td data-pk="+data.s_id+" value="+data.s_id+" data-name=\"student_name\"  data-type=\"number\" class=\"status\" id='student_name'>"
							+ data.status + "</td>";	
					content1 += '<tr>';
			
				$("#additional_student_info").html(content1);
				
				
			},
			error : function() {
			    alert("Error...!!!");
			}
		    });
	}
	
	</script>