
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<jsp:include page="../shared/header.jsp" />


	<!-- Content Area -->
	<div id="page-content-wrapper">


		<!-- Content Area -->
			<ol class="breadcrumb">
				<li><a href="${cp}/home"><span
						class="glyphicon glyphicon-home"> Home </span></a></li>
				<li><a><span class="glyphicon glyphicon-user black">
							Add-Students </span></a></li>
			</ol>
			<div class="panel-group">
				<div class="panel panel-default profile-panel">
					<div class="panel-heading main-color-bg">
						<!-- <a href="addstudents.jsp" class="btn btn-active"> <b><span
								class="glyphicon glyphicon-plus"> Add Students </span></b>
					</a> | <a href="managestudents.jsp" class="btn btn-inactive"> <span
					class="glyphicon glyphicon-pencil"> Manage Students </span>
			</a> -->
					</div>
					<div class="panel-body" id="stu">
						<div class="row">
							<form class="" action="../addStudent"
								enctype="multipart/form-data" method="Post">
								
								<div class="col-lg-4 col-sm-8 col-sm-offset-2 col-lg-offset-0 profile-info ">
									<table class="table tabel-responsive">
										<tr>
											<td>
												<div class="text-center" id="profile-image">
													<img src="me.jpg" alt="image upload">
												</div>
											</td>
										</tr>
										<tr>
											<td><input type="file" id="inputfile" name="filepath"
												class="form-control"></td>
										</tr>
										<tr>
											<td><h3 class="text-center">
													<i><b>Student</b></i>
												</h3></td>
										</tr>
									</table>
								</div>
								<div class="col-lg-4 col-sm-6 profile-info">
									<table class="tabel tabel-responsive">
										<tr>
											<td>Firstname: <span class="astriek">*</span>
											</td>
											<td><input type="text" placeholder="Firstname"
												class="form-control" required name="student_firstname"></td>
										</tr>
										<tr>
											<td>Middle Name:</td>
											<td><input type="text" placeholder="Middlename"
												class="form-control" name="student_middlename"></td>
										</tr>
										<tr>
											<td>LastName: <span class="astriek">*</span>
											</td>
											<td><input type="text" placeholder="Lastname"
												class="form-control" required name="student_Lastname"></td>
										</tr>
										<tr>
											<td>Gender: <span class="astriek">*</span>
											</td>
											<td><label class="radio-inline"><input
													type="radio" name="gender" required value="male">Male</label>
												<label class="radio-inline"><input type="radio"
													name="gender" value="female">Female</label></td>
										</tr>
										<tr>
											<td>ID:</td>
											<td><input type="text" placeholder="ID"
												class="form-control" required name="id" id="studentID"
												onblur="validate();" onkeyup="autoUserPass();"></td>
											<td><span id="Error_ID"
												class="glyphicon glyphicon-remove-circle"
												style="visibility: hidden;"></span></td>
										</tr>
										<tr>
											<td>Phone:</td>
											<td><input type="number" placeholder="Phone"
												class="form-control" name="Mobile"></td>
										</tr>
										<tr>
											<td>Address:</td>
											<td><input type="text" placeholder="Address"
												class="form-control" name="Address" id="address_ID"></td>
										</tr>
										<tr>
											<td>Email:</td>
											<td><input type="email" placeholder="email"
												class="form-control" name="email"></td>
										</tr>
										<tr>
											<td>Enroll Date:</td>
											<td><input type="date" id="date" class="form-control"
												name="date"></td>
										</tr>
									</table>
								</div>
								<div class="col-lg-4 col-sm-6 profile-info">
									<table class="tabel tabel-responsive">
										<tr>
											<td>Faculty: <span class="astriek">*</span>
											</td>
											<td><select required class="form-control"
												id="faculty-box" onChange="load_program();">

											</select></td>
										</tr>

										<tr>
											<td>Programme: <span class="astriek">*</span>
											</td>
											<td><select required class="form-control"
												id="program-box" onChange="load_batch();">
													<option value="" disabled selected>Select
														Programme</option>
											</select></td>
										</tr>

										<tr>
											<td>Batch: <span class="astriek">*</span>
											</td>
											<td><select required class="form-control" id="batch-box">
													<option value="" disabled selected>Select Batch</option>
											</select></td>
										</tr>
										<tr>
											<td>Section:</td>
											<td><select class="form-control" id="sel1">
													<option value="" disabled selected>Select Section</option>
													<option>B01</option>
													<option>B02</option>
											</select></td>
										</tr>
										<tr>
											<td>Username:</td>
											<td><input type="text" placeholder="username"
												class="form-control" name="student_username"
												id="student_username1"></td>
										</tr>
										<tr>
											<td>Password:</td>
											<td><input type="password" class="form-control"
												name="password" placeholder="Password" id="Password1"></td>
										</tr>
										<tr>
											<td>Confirm Password:</td>
											<td><input type="password" class="form-control"
												name="confirm_password" placeholder="Confirm Password"
												id="confirm_password"></td>
										</tr>
										<tr>
											<td>Status: <span class="astriek">*</span>
											</td>
											<td><label class="radio-inline"><input
													type="radio" name="status" required checked value="active">Active</label>
												<label class="radio-inline"><input type="radio"
													name="status" value="inactive">Inactive</label></td>
										</tr>
										<tr>
											<td colspan="2"><input type="submit"
												class="btn btn-success btn-block" value="Submit"></td>
										</tr>
									</table>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- --------------------------------------------------------------- -->
		</div>

	<script type="text/javascript">
			function autoUserPass(){
				
				var id=document.getElementById("studentID").value;

				var url="../ajax_user_password_autofill";
				var idSend="id="+id;
				var aj=new XMLHttpRequest();
				aj.open("POST", url, true);
				aj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				aj.onreadystatechange=function(){
					if (aj.readyState==4&&aj.status==200) {
						var return_data=aj.responseText;
						//alert("from ajax:"+return_data);
						document.getElementById("student_username1").value=return_data;
						document.getElementById("Password1").value=return_data;
						document.getElementById("confirm_password").value=return_data;
						document.getElementById("Error_ID").style.visibility = "hidden";
					}
					}
				aj.send(idSend);
				
			}
			
			</script>


	<jsp:include page="../shared/footer.jsp" />