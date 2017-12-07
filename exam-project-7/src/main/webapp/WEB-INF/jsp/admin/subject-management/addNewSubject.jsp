
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


			<form id="add-subject-form" method="post" class="form-horizontal well">

				<div class="form-group">
					<label class="col-md-3 control-label">Subject name</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="subject_name" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Subject code</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="subject_code" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Subject Credit</label>
					<div class="col-md-9">
						<div class="col-md-6">
							Theory_Credit<input type="text" class="form-control" name="theory_cr" />
						</div>
						<div class="col-md-6">
							Tutorial_Credit<input type="text" class="form-control" name="tutorial_cr" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Subject Marks</label>
					<div class="col-md-9">
						<div class="col-md-4">
							Internal_theory<input type="text" class="form-control" name="internal_theory" />
						</div>
						<div class="col-md-4">
							Internal_practical<input type="text" class="form-control" name="internal_practical" />
						</div>
						<div class="col-md-4">
							Final_theory<input type="text" class="form-control" name="final_theory" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-3 control-label">Syllabus File</label>
					<div class="col-md-9">
						<input type="file" class="form-control" name="syllabus_file" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Program</label>
					<div class="col-md-9">
						<select required class="form-control" id="all-program-box" name="program_id">
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Available</label>
					<div class="col-md-9">
						<label> Yes <input type="radio" value=0 name="status">
						</label> <label> No <input type="radio" value=1 name="status">
						</label>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<button type="submit" id="addSubject" class="btn btn-info btn-block">Save</button>
					</div>
				</div>
			</form>


		</div>


	</div>
</div>

<script>
    $(document).ready(function () {

        load_all_program("all-program-box");
        
        $("#add-subject-form").bootstrapValidator({
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

            var data = $('#add-subject-form').serializeArray();
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
                    $("#add-subject-form")[0].reset();
                },
                error : function () {
                    alert("Error...!!!");
                }
            });

        });
        
        
    });
</script>

<jsp:include page="../shared/footer.jsp" />