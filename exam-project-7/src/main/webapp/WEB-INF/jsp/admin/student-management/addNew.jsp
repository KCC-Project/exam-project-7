
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	isELIgnored="false"%>


<jsp:include page="../shared/header.jsp" />

<div class="alert alert-success" role="alert" id="success_message"></div>

<!-- Content Area -->
<div id="page-content-wrapper">


	<!-- Content Area -->
	<ol class="breadcrumb">
		<li><a href="${cp}/home"><span class="glyphicon glyphicon-home"> Home </span></a></li>
		<li><a><span class="glyphicon glyphicon-user black"> Add-Students </span></a></li>
	</ol>

	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading main-color-bg">Add Student</div>
			<div class="panel-body">

				<form class='form-horizontal' role='form' id="add-student-form">
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2' for='id_program'>Title</label>
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
						<label class='control-label col-md-2 col-md-offset-2' for='id_title'>Name</label>
						<div class='col-md-8'>

							<div class='col-md-3 indent-small'>
								<div class='form-group internal'>
									<input class='form-control' name='first_name' id='id_first_name' placeholder='First Name' type='text'
										required />
								</div>
							</div>
							<div class='col-md-3 indent-small'>
								<div class='form-group internal'>
									<input class='form-control' id='id_middle_name'  name='middle_name' placeholder='Middle Name' type='text' />
								</div>
							</div>
							<div class='col-md-3 indent-small'>
								<div class='form-group internal'>
									<input class='form-control' id='id_last_name'  name='last_name' placeholder='Last Name' type='text' required />
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2' for='id_username'>Username</label>
						<div class='col-md-8'>
							<div class='col-md-5'>
								<div class='form-group internal'>
									<input class='form-control col-md-8' id='id_username'  name='username' placeholder='Username' type='text' required />
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2' for='id_password'>Password</label>
						<div class='col-md-8'>
							<div class='col-md-5'>
								<div class='form-group internal'>
									<input class='form-control col-md-8' id='id_password'  name='password' placeholder='Password' type='text'
										required />
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2' for='id_email'>Contact</label>
						<div class='col-md-6'>
							<div class='form-group'>
								<div class='col-md-11'>
									<input class='form-control' id='id_email'  name='email' placeholder='E-mail' type='text' />
								</div>
							</div>
							<div class='form-group internal'>
								<div class='col-md-11'>
									<input class='form-control' id='id_phone'  name='phone' placeholder='Phone: (xxx) - xxx xxxx' type='text' />
								</div>
							</div>
							<div class='form-group internal'>
								<div class='col-md-11'>
									<input class='form-control' id='id_phone'  name='address' placeholder='Address' type='text' required />
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2' for='id_dob'>Date Of Birth</label>
						<div class='col-md-8'>
							<div class='col-md-3'>
								<div class='form-group internal input-group'>
									<input class='form-control datepicker' id='id_dob'  name='date_of_birth' /> <span class='input-group-addon'>
										<i class='glyphicon glyphicon-calendar'></i>
									</span>
								</div>
							</div>
							<label class='control-label col-md-2' for='id_gender'>Gender</label>
							<div class='col-md-3'>
								<div class='form-group internal'>
									<div class="form-group">
										<div class="radio">
											<label> <input type="radio" value=1 name="gender" required> Male
											</label>
										</div>

										<div class="radio">
											<label> <input type="radio" value=0 name="gender" required> Female
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2' for='id_equipment'>Current
							Semester</label>
						<div class='col-md-8'>
							<div class='col-md-3'>
								<div class='form-group internal'>
									<select class='form-control' id='id_equipment'  name='semester_no'>
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
									<div class="form-group">
										<div class="radio">
											<label> <input type="radio" value=0 name="status" checked required>
												Active
											</label>
										</div>

										<div class="radio">
											<label> <input type="radio" value=0 name="status" required> Inactive
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class='form-group'>
						<label class='control-label col-md-2 col-md-offset-2' for='id_pets'>Image</label>
						<div class='col-md-8'>

							<input name="myFile" type="file"  name='image'>


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

<script>
$(document).ready(function () {
    
    $("#add-student-form").bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons : {
            valid : "glyphicon glyphicon-ok",
            invalid : "glyphicon glyphicon-remove",
            validating : "glyphicon glyphicon-refresh"
        },
        fields : {
            first_name : {
                validators : {
                    stringLength : {
                        min : 2
                    },
                    notEmpty : {
                        message : "Please Enter Student First Name"
                    }
                }
            },
            last_name : {
                validators : {
                    stringLength : {
                        min : 2
                    },
                    notEmpty : {
                        message : "Please Enter Student Last Name"
                    }
                }
            }
        }
    })

    .on("success.form.bv", function (e) {

        // Prevent form submission
        e.preventDefault();

        var data = $('#add-student-form').serializeArray();
        console.log(data);

        $.ajax({
            url : window.context + "/ApiStudent/SaveStudent",
            method : "POST",
            dataType : 'json',
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            cache : true,
            success : function (data) {
                var message = "Student has been added Successfully";
                $("#success_message").html(message);
                alert("Thanks for the submission!");
                $("#add-student-form")[0].reset();
            },
            error : function () {
                alert("Error...!!!");
            }
        });

    });
});
</script>

<jsp:include page="../shared/footer.jsp" />