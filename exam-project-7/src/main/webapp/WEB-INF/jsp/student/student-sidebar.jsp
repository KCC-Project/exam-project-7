<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	isELIgnored="false"%>

<div id="side-menu">
	<div class="profile-userpic">
		<img alt="User Pic" src="${cp}/assets/images/blank_user.png" class="img-responsive">
	</div>
	<div class="profile-usertitle">
		<div class="profile-usertitle-name">
			<p class="student-name" id="full-name"></p></br>
		</div>
		<p class="student-name" id="current-semester"></p>
	</div>


	<a href="${cp }/user" id="view-profile" class="btn btn-success btn-sm profile-viewbtn">View Profile</a>


	<div class="profile-usermenu">
		<ul class="nav">
			<li class="active"><a href="${cp }/user"> <i class="glyphicon glyphicon-home"></i> Overview
			</a></li>
			<li><a href="${cp }/results"> <i class="glyphicon glyphicon-user"></i> Results
			</a></li>
			<li><a href="${cp }/upcoming-exams"> <i class="glyphicon glyphicon-ok"></i> Upcoming Exams
			</a></li>
			<li><a href="${cp }/subjects-details"> <i class="glyphicon glyphicon-flag"></i> Subjects Details
			</a></li>
		</ul>
	</div>
	<!-- END MENU -->
</div>



<script>
    $(document).ready(function () {
        // get student_id from session
        var s_id = 1;

        $.ajax({
            url : window.context + "/ApiStudent/GetStudent/" + s_id,
            method : "GET",
            dataType : 'json',
            cache : true,
            success : function (data) {
                var json = data;
                console.log(data);

                var content = '';
                for (var i = 0; i < data.length; i++) {
                    content += '<p>First Name: ' + data[i].first_name + '</p>';
                    content += '<p>Middle Name: ' + data[i].middle_name + '</p>';
                    content += '<p>Last Name:  ' + data[i].last_name + '</p>';
                    content += '<p>Address:  ' + data[i].address + '</p>';
                    content += '<p>Email: ' + data[i].email + '</p>';
                    $("#first_details").html(content);

                    var full_name = "";
                    full_name += data[i].first_name + " ";
                    if (data[i].middle_name == undefined) {

                    } else {
                        full_name += data[i].middle_name + " ";
                    }
                    full_name += data[i].last_name;

                    $("#full-name").html('<p>' + full_name + '');
                    $("#current-semester").html('<p>Current Semester:'+ data[i].current_semester+ '</p>');

                    $("#side-profile-info").html('<p> Username: ' + data[i].username + '</p>' + '<p><i> email: ' + data[i].email + '</i></p>' + '<p> Phone: ' + data[i].phone + '</p>');
                }
            },
            error : function () {
                alert("Sorry couldnt fetch data some From server");
            }
        });

    });
</script>
