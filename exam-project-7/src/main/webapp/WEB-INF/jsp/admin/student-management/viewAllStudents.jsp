<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <jsp:include page="../shared/header.jsp" />

<body>

	<div class="col-md-12 col-sm-12 ">
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
								data-toggle="modal" data-target="#addAccountModal"
								id="modal-box">Account</button></a>
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
									<table class="table table-bordered" id="tblAccount">
										<thead>
											<tr>
												<td>S.No</td>
												<td>F.Name</td>
												<td>M.name</td>
												<td>L.Name</td>
												<td>Phone</td>
												<td>Address</td>
											</tr>
										</thead>
										<tbody id="account_data">
										</tbody>
									</table>
								</div>
								<div class="loader" id="loader" hidden style="margin-left: 40%;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>

	<jsp:include page="../shared/footer.jsp" />
	<script>
	
	
	$("select").select2(
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
				type : "GET",
				delay : 250,
				data : function(params) {
				    console.log("params="   + params.term);
				    //console.log("params="+params.page);
				    return {
					val : params.term,
					page : params.page
				    };
				},
				processResults : function(data,
					params) {
				    //console.log("data=" + data);
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
		    var select_val = selected_element.val();
		    alert("name="+ selectedValues[select_val]);
		    console.log("Student Id=" + select_val);
		    gettingPreviousAccount(select_val);
		});
	function formatRepo(repo) {
	    if (repo.loading)
		return repo.text;
	    var markup = '<option value='+repo.id+'>'
		    + repo.name + '</option>';
	    console.log("repo.text=" + repo.text);
	    return markup;
	}
	function formatRepoSelection(repo) {
	    return repo.name || repo.text;
	}
	</script>