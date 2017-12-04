
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
		<div class="panel panel-default">
			<div class="panel-heading main-color-bg">Add Student</div>
			<div class="panel-body">

				<form class='form-horizontal' role='form'>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2'
							for='id_program'>Title</label>
						<div class='col-md-2'>
							<select class='form-control' id='id_program'>
								<option>Mr</option>
								<option>Ms</option>
								<option>Mrs</option>
								<option>Miss</option>
							</select>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2'
							for='id_title'>Name</label>
						<div class='col-md-8'>

							<div class='col-md-3 indent-small'>
								<div class='form-group internal'>
									<input class='form-control' id='id_first_name'
										placeholder='First Name' type='text'>
								</div>
							</div>
							<div class='col-md-3 indent-small'>
								<div class='form-group internal'>
									<input class='form-control' id='id_middle_name'
										placeholder='Middle Name' type='text'>
								</div>
							</div>
							<div class='col-md-3 indent-small'>
								<div class='form-group internal'>
									<input class='form-control' id='id_last_name'
										placeholder='Last Name' type='text'>
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2'
							for='id_username'>Username</label>
						<div class='col-md-8'>
							<div class='col-md-5'>
								<div class='form-group internal'>
									<input class='form-control col-md-8' id='id_username'
										placeholder='Username' type='text'>
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2'
							for='id_password'>Password</label>
						<div class='col-md-8'>
							<div class='col-md-5'>
								<div class='form-group internal'>
									<input class='form-control col-md-8' id='id_password'
										placeholder='Password' type='text'>
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2'
							for='id_email'>Contact</label>
						<div class='col-md-6'>
							<div class='form-group'>
								<div class='col-md-11'>
									<input class='form-control' id='id_email' placeholder='E-mail'
										type='text'>
								</div>
							</div>
							<div class='form-group internal'>
								<div class='col-md-11'>
									<input class='form-control' id='id_phone'
										placeholder='Phone: (xxx) - xxx xxxx' type='text'>
								</div>
							</div>
							<div class='form-group internal'>
								<div class='col-md-11'>
									<input class='form-control' id='id_phone' placeholder='Address'
										type='text'>
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2' for='id_dob'>Date
							Of Birth</label>
						<div class='col-md-8'>
							<div class='col-md-3'>
								<div class='form-group internal input-group'>
									<input class='form-control datepicker' id='id_dob'> <span
										class='input-group-addon'> <i
										class='glyphicon glyphicon-calendar'></i>
									</span>
								</div>
							</div>
							<label class='control-label col-md-2' for='id_gender'>Gender</label>
							<div class='col-md-3'>
								<div class='form-group internal'>
									<div class='make-switch' data-on-text="Female"
										data-off-text='MALE' id='id_slide_switch'>
										<input id='id_slide' type='checkbox' value='chk_hydro'
											name="id_slide" class="probeProbe">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2'
							for='id_equipment'>Current Semester</label>
						<div class='col-md-8'>
							<div class='col-md-3'>
								<div class='form-group internal'>
									<select class='form-control' id='id_equipment'>
										<option>Select Semester</option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
										<option>7</option>
										<option>8</option>
									</select>
								</div>
							</div>
							<div class='col-md-9'>
								<div class='form-group internal'>
									<label class='control-label col-md-3' for='id_status'>Status</label>
									<div class='make-switch' data-off-label='IN'
										data-on-label='OUT' id='id_slide_switch'>
										<input id='id_slide' type='checkbox' value='chk_hydro'
											name="id_slide" class="probeProbe">
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2'
							for='id_pets'>Image</label>
						<div class='col-md-8'>

							<input name="myFile" type="file">
					
						
						</div>
						
					</div>
					
<div class="row">
<div class="col-md-2 col-md-offset-5">
<input type="submit" value="Submit" class="btn btn-primary">
</div>
</div>
				</form>
			</div>
		</div>
	</div>
</div>


<jsp:include page="../shared/footer.jsp" />