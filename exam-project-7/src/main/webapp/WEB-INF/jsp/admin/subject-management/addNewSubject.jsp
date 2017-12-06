
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	isELIgnored="false"%>


<jsp:include page="../shared/header.jsp" />


<!-- Success message -->
<div class="alert alert-success" role="alert" id="success_message"></div>

<!-- Content Area -->
<div id="page-content-wrapper">


	<!-- Content Area -->
	<ol class="breadcrumb">
		<li><a href="${cp}/home"><span class="glyphicon glyphicon-home"> Home </span></a></li>
		<li><a><span class="glyphicon glyphicon-user black"> Add-Subjects </span></a></li>
	</ol>

	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading main-color-bg">Add Subject</div>
			<div class="panel-body"></div>


			<form class="well form-horizontal" action=" " method="post" id="contact_form">
				<fieldset>

					<!-- Form Name -->
					<legend>Contact Us Today!</legend>

					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-4 control-label">Subject Name</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-book"></i></span> <input
									name="subject_name" placeholder="Enter Subject Name" class="form-control" type="text">
							</div>
						</div>
					</div>

					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-4 control-label">Subject Code</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> <input
									name="subject_code" placeholder="Enter Subject Code" class="form-control" type="text">
							</div>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2" for="id_title">Subject Credit</label>
						<div class="col-md-8">

							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder="Enter Subject theory_credit" type="text"
										name="theory_cr">
								</div>
							</div>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder="Enter Subject tutorial_credit" type="text"
										name="tutorial_cr">
								</div>
							</div>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2" for="id_title">Subject Marks</label>
						<div class="col-md-8">

							<div class="col-md-3 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder="Enter Internal_theory marks" type="text"
										name="internal_theory">
								</div>
							</div>
							<div class="col-md-3 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder="Enter Internal_practical marks" type="text"
										name="internal_practical">
								</div>
							</div>
							<div class="col-md-3 inputGroupContainer">
								<div class="input-group">
									<input class="form-control" placeholder=" Enter Final_theory marks" type="text"
										name="final_theory">
								</div>
							</div>
						</div>
					</div>


					<!-- Select Basic -->
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2" for="id_title">Subject Program</label>
						<div class="col-md-8">
							<div class="col-md-3 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span> <select
										required class="form-control" id="p-faculty-box" name="faculty_id">
									</select>
								</div>
							</div>

							<div class="col-md-3 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span> <select
										required class="form-control" id="p-program-box" name="program_id" required>
									</select>
								</div>
							</div>
						</div>
						</div>


						<!-- radio checks -->
						<div class="form-group">
							<label class="col-md-4 control-label">This Subject is avilable ?</label>
							<div class="col-md-4">

								<div class="form-group">
									<div class="radio">
										<label> <input type="radio" value=0 name="status" checked required> Yes
										</label>
									</div>

									<div class="radio">
										<label> <input type="radio" value=1 name="status" required> No
										</label>
									</div>
								</div>

							</div>
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
    $(document).ready(function () {

        load_faculty(event, "p-faculty-box");

        $("#p-faculty-box").change(function (event) {
            load_program(event, "p-program-box");
        });

        $("#contact_form").bootstrapValidator({
            // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
            feedbackIcons : {
                valid : "glyphicon glyphicon-ok",
                invalid : "glyphicon glyphicon-remove",
                validating : "glyphicon glyphicon-refresh"
            },
            fields : {
                subject_name : {
                    validators : {
                        stringLength : {
                            min : 2
                        },
                        notEmpty : {
                            message : "Please Enter Subject Name"
                        }
                    }
                },
                subject_code : {
                    validators : {
                        stringLength : {
                            min : 3
                        },
                        notEmpty : {
                            message : "Please Enter Subject Code"
                        }
                    }
                },
                theory_cr : {
                    validators : {
                        stringLength : {
                            max : 1
                        },
                        integer : {
                            message : "Please Enter Number"
                        }
                    }
                },
                tutorial_cr : {
                    validators : {
                        stringLength : {
                            max : 1
                        },
                        integer : {
                            message : "Please Enter Number"
                        }
                    }
                },
                internal_theory : {
                    validators : {
                        stringLength : {
                            max : 3
                        },
                        integer : {
                            message : "Please Enter Number"
                        }
                    }
                },
                internal_practical : {
                    validators : {
                        stringLength : {
                            max : 3
                        },
                        integer : {
                            message : "Please Enter Number"
                        }
                    }
                },
                final_theory : {
                    validators : {
                        stringLength : {
                            max : 3
                        },
                        integer : {
                            message : "Please Enter Number"
                        }
                    }
                }
            }
        })

        .on("success.form.bv", function (e) {

            // Prevent form submission
            e.preventDefault();

            var data = $('#contact_form').serializeArray();
            console.log(data);

            //Add in additional data to the original form data:
			/*
            data.push({
                name : 'programId',
                value : 1
            }, {
                name : 'batchyear',
                value : 2013
            });  */

            $.ajax({
                url : window.context + "/ApiStudent/SearchStudentsByProgram",
                method : "POST",
                dataType : 'json',
                contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                cache : true,
                success : function (data) {
                    var message = "Subject has been added Successfully";
                    $("#success_message").html(message);
                    alert("Thanks for the submission!");
                    $("#contact_form")[0].reset();
                },
                error : function () {
                    alert("Error...!!!");
                }
            });

        });
    });
</script>

<jsp:include page="../shared/footer.jsp" />