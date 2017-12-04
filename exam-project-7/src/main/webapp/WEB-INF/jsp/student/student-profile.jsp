<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<jsp:include page="../student/student-header.jsp" />


<div id="page-content-wrapper">


	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading main-color-bg">Profile</div>
			<div class="panel-body">

				<div
					class="col-lg-4 col-sm-8 col-sm-offset-2 col-lg-offset-0 profile-info ">
					<h4 class="text-center">FullName: Shrawan Adhikari</h4>
					<div align="center" class="profile-userpic">
						<img alt="User Pic" src="${cp}/assets/images/greenworld.jpg"
							class="img-responsive">
					</div>
					<h6 class="text-center">usertype: Administrator</h6>
				</div>

				<div class="col-lg-4 col-sm-6 profile-info">
					<p>Full Name: Shrawan Adhikari</p>
					<p>Address: Kathmandu, Nepal</p>
					<p>Email: shrawan.adhikari.31@gmail.com</p>
					<p>Mobile:</p>
					<p>DateJoined:</p>
				</div>

				<div class="col-lg-4 col-sm-6 profile-info">
					<span class="h4"><i class="icon_pin_alt"></i>Roles: Password
						Reset, error reporting</span>
					<p>username: @shrawan_adhikari</p>
					<p>
						<i class="fa fa-twitter">email: shrawan.adhikari.31@gmail.com</i>
					</p>

					<br> <br>
					<p class="h4">
						<em>Bio: One of the developer of this college management
							system.</em>
					</p>
				</div>

			</div>
		</div>
	</div>

	<div class="panel">
		<div class="panel-heading">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#recent-activity">
						<i class="glyphicon glyphicon-home"></i> Daily Activity
				</a></li>
				<li><a data-toggle="tab" href="#profile"> <i
						class="glyphicon glyphicon-user"></i> Profile
				</a></li>
				<li class=""><a data-toggle="tab" href="#edit-profile"> <i
						class="icon-envelope"></i> Edit Profile
				</a></li>
			</ul>
		</div>

		<div class="panel-body">
			<div class="tab-content">
				<div id="recent-activity" class="tab-pane active">
					<div class="profile-activity">

						<div class="event-info">
							<ul>
								<li><a href="#"><img
										class="event-uploader-image pull-left" src="me.jpg" alt=""></a>
								</li>
								<li>
									<p class="small">
										<a href="#">{uloader name}</a> at {time, date}
									</p>
								</li>
								<li><p>All the UI design must be completed within,
										2017/08/20</p></li>
							</ul>
						</div>
						<div class="event-info">
							<ul>
								<li><a href="#"><img
										class="event-uploader-image pull-left" src="me.jpg" alt=""></a>
								</li>
								<li>
									<p class="small">
										<a href="#">Shrawan Adhikari</a> at {10:05PM 2017/08/06}
									</p>
								</li>
								<li><p>All the UI design must be completed within,
										2017/08/20</p></li>
							</ul>
						</div>


					</div>
				</div>

				<!-- profile -->
				<div id="profile" class="tab-pane">
					<div class="panel">
						<div class="panel-body profile-panel">
							<div class="table-responsive">
								<table class="table table-default">
									<thead>
										<tr>
											<th>FirstName: {first username}</th>
											<th>MiddleName: {middle name}</th>
											<th>LastName: {last name}</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Address</td>
											<td>Text</td>
											<td>phone</td>
										</tr>
										<tr>
											<td>Cell 3</td>
											<td>Text</td>
											<td>Cell 4</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- edit-profile -->
				<div id="edit-profile" class="tab-pane">
					<div class="panel">
						<div class="panel-body profile-panel"></div>
					</div>
				</div>

			</div>
		</div>
	</div>

</div>


<script>
	
		</script>


</div>
</body>
</html>