
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
					Add-Subjects </span></a></li>
	</ol>

	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading main-color-bg">Add Subject</div>
			<div class="panel-body"></div>


			<form class="well form-horizontal" action=" " method="post"
				id="contact_form">
				<fieldset>

					<!-- Form Name -->
					<legend>Contact Us Today!</legend>

					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-4 control-label">Subject Name</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-book"></i></span> <input name="first_name"
									placeholder="Subject Name" class="form-control" type="text">
							</div>
						</div>
					</div>

					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-4 control-label">Subject Code</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="last_name"
									placeholder="Subject Code" class="form-control" type="text">
							</div>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2"
							for="id_title">Subject Credit</label>
						<div class="col-md-8">

							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder="theory_credit"
										type="text" name="theory_cr">
								</div>
							</div>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder="tutorial_credit"
										type="text" name="tutorial_cr">
								</div>
							</div>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2"
							for="id_title">Subject Marks</label>
						<div class="col-md-8">

							<div class="col-md-3 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder="Internal_theory"
										type="text" name="internal_theory">
								</div>
							</div>
							<div class="col-md-3 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder="Internal_practical"
										type="text" name="internal_practical">
								</div>
							</div>
							<div class="col-md-3 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder="Final_theory"
										type="text" name="final_theory">
								</div>
							</div>
						</div>
					</div>


					<!-- Select Basic -->

					<div class="form-group">
						<label class="col-md-4 control-label">Program</label>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-list"></i></span> <select name="program"
									class="form-control" id="faculty_select_box">

								</select>
							</div>
						</div>
					</div>



					<!-- radio checks -->
					<div class="form-group">
						<label class="col-md-4 control-label">This Subject is avilable ?</label>
						<div class="col-md-4">

							<div class="form-group">
								<div class="radio">
									<label> <input type="radio" name="status" checked required>
										Yes
									</label>
								</div>

								<div class="radio">
									<label> <input type="radio" name="status" required>
										No
									</label>
								</div>
							</div>

						</div>
					</div>

					<!-- Success message -->
					<div class="alert alert-success" role="alert" id="success_message">
						Success <i class="glyphicon glyphicon-thumbs-up"></i> Subject add request made, we will get back to you shortly.
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
		</div>


	</div>
</div>

<script>
	$(document).ready(function() {
						$("#faculty_select_box").select2(
										{
											tags : true,
											multiple : true,
											ajax : {
												url : window.context
														+ "/ApiFaculty/GetAllFaculty",
												dataType : "json",
												type : "GET",
												data : function(params) {

													var queryParameters = {
														term : params.term
													}
													return queryParameters;
												},
												processResults : function(data) {
													return {
														results : $
																.map(
																		data,
																		function(
																				item) {
																			return {
																				text : item.faculty_name,
																				id : item.faculty_id
																			}
																		})
													};
												}
											}
										});

						$('#contact_form').bootstrapValidator(
										{
											// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
											feedbackIcons : {
												valid : 'glyphicon glyphicon-ok',
												invalid : 'glyphicon glyphicon-remove',
												validating : 'glyphicon glyphicon-refresh'
											},
											fields : {
												first_name : {
													validators : {
														stringLength : {
															min : 2,
														},
														notEmpty : {
															message : 'Please Enter Subject Name'
														}
													}
												},
												last_name : {
													validators : {
														stringLength : {
															min : 3,
														},
														notEmpty : {
															message : 'Please Enter Subject Code'
														}
													}
												},
												theory_cr : {
													validators : {
														stringLength : {
															max : 1,
														},
														integer : {
															message : 'Please Enter Number'
														}
													}
												},
												tutorial_cr : {
													validators : {
														stringLength : {
															max : 1,
														},
														integer : {
															message : 'Please Enter Number'
														}
													}
												},
												internal_theory : {
													validators : {
														stringLength : {
															max : 3,
														},
														integer : {
															message : 'Please Enter Number'
														}
													}
												},
												internal_practical : {
													validators : {
														stringLength : {
															max : 3,
														},
														integer : {
															message : 'Please Enter Number'
														}
													}
												},
												final_theory : {
													validators : {
														stringLength : {
															max : 3,
														},
														integer : {
															message : 'Please Enter Number'
														}
													}
												},
												program : {
													validators : {
														stringLength : {
															max : 1,
															message : 'You can select only one program'
														},
														notEmpty : {
															message : 'Please Select Program that Subject Belongs to'
														}
													}
												},

											}
										})
								.on(
										'success.form.bv',
										function(e) {
											$('#success_message').slideDown({
												opacity : "show"
											}, "slow") // Do something ...
											$('#contact_form').data(
													'bootstrapValidator')
													.resetForm();

											// Prevent form submission
											e.preventDefault();

											// Get the form instance
											var $form = $(e.target);

											// Get the BootstrapValidator instance
											var bv = $form
													.data('bootstrapValidator');

											// Use Ajax to submit form data
											$.post($form.attr('action'), $form
													.serialize(), function(
													result) {
												console.log(result);
											}, 'json');
										});
					});
</script>

<jsp:include page="../shared/footer.jsp" />