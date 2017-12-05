$(document).ready(function () {
    $("#faculty_select_box").select2({
        tags : true,
        multiple : true,
        ajax : {
            url : window.context + "/ApiFaculty/GetAllFaculty",
            dataType : "json",
            type : "GET",
            data : function (params) {
                var queryParameters = {
                    term : params.term
                };
                return queryParameters;
            },
            processResults : function (data) {
                return {
                    results : $.map(data, function (item) {
                        return {
                            text : item.faculty_name,
                            id : item.faculty_id
                        };
                    })
                };
            }
        }
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
            },
            program : {
                validators : {
                    stringLength : {
                        max : 1,
                        message : "You can select only one program"
                    },
                    notEmpty : {
                        message : "Please Select Program that Subject Belongs to"
                    }
                }
            }
        }
    })

    .on("success.form.bv", function (e) {
        $("#success_message").slideDown({
            opacity : "show"
        }, "slow"); // Do something ...
        $("#contact_form").data("bootstrapValidator").resetForm();

        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data("bootstrapValidator");

        // Use Ajax to submit form data
        $.post($form.attr("action"), $form.serialize(), function (result) {
            console.log(result);
        }, "json");
    });
});
