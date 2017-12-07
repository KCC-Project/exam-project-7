
//url1 for search Param ,url2 for get getting data with the help of selected id, fxn calling datatable load 
function select2Function(url1,url2,method1,method2,placeholder,fxn){
		$("select").select2({
			theme : "bootstrap",
			width : "auto"
		});

		$("#sel1").select2({
			theme : "bootstrap",
			width : "100%",
			//width:auto,
			height : "10px",
			minimumInputLength : 3,
			placeholder : "Search "+placeholder,
			ajax : {
				url :url1 ,
				dataType : 'json',
				type : method1,
				delay : 400,
				data : function(params) {
					//console.log("params="   + params.term);
					return {
						val : params.term,
						page : params.page
					};
				},
				processResults : function(data, params) {
					console.log("returned data from server =" + JSON.stringify(data));
					//   console.log("full name = " + data.first_name + " "+data.last_name);
					//.log("id= " + data.s_id);
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
			//console.log(selected_element);
			var select_val = selected_element.val();
			//console.log("program Id=" + select_val);
			//alert(select_val);
			var url3 = url2 +"/"+select_val;
			var method3 = method2;
			var data3 = "";
			fxn(url3, method3, data3);
		});

		function formatRepo(repo) {
			// console.log("formated repo=" + JSON.stringify(repo));
			if (repo.loading)
				return repo.text;
			var markup = '<option value='+repo.id+'>' + repo.name + '</option>';
			return markup;
		}
		function formatRepoSelection(repo) {
			return repo.name || repo.text;
		}
	}

function load_faculty(e, target) {
		$.ajax({
			url : window.context + "/ApiFaculty/GetAllFaculty",
			method : "GET",
			dataType : 'json',
			cache : true,
			success : function(data) {
				var json = data;
				//console.log("json size=" + data.length);
				var content = '';
				content += "<option selected='true' > Select Faculty </option>"
				for (var i = 0; i < data.length; i++) {
					var facultyName = data[i].faculty_name;
					var facultyId = data[i].faculty_id;
					//console.log("faculty name =" + facultyName);

					content += '<option value='+facultyId+'>' + facultyName + '</option>';
				}
				$('#' + target).html(content);
			},
			error : function() {
				alert("Error...!!!");
			}
		});
	}
	function load_program(e, target) {
		var getid = e.target.id;
		var id = $('#' + getid).find(":selected").val();
		$.ajax({
			url : window.context + "/ApiProgram/GetProgramByFacultyId/" + id,
			method : "GET",
			dataType : 'json',
			cache : true,
			success : function(data) {

				//console.log("program size=" + JSON.stringify(data));
				var content = '';
				content += "<option selected='true' > Select Program </option>"
				for (var i = 0; i < data.length; i++) {
					var programeName = data[i].program_name;
					var programeId = data[i].program_id;
					//console.log("faculty name =" + programeName);

					content += '<option value='+programeId+'>' + programeName + '</option>';
				}
				$('#' + target).html(content);
			},
			error : function() {
				alert("Error...!!!");
			}
		});
	}
	
	
	function loadStudentInformation(url, method, data) {
		// Initializing Datatable
		$('#view_student').DataTable({
			 destroy: true,
			 paging: true,
			    searching: true,
			"processing" : true,
			"serverSide" : false,
			"ajax" : {
				"url" : url,
				"type" : method,
				"data": data,
				"dataSrc" : "",
				"dataType" : "json",
				"async" : false
			},
			"columns" : [ {
				"data" : "s_id"
			}, {
				"data" : "first_name"
			}, {
				data : null,
				render : function(data, type, row) {
					console.log(JSON.stringify(data));
					var full_name = "";
					full_name +=data.first_name+ " ";
					if(data.middle_name  == undefined){
						
					}else{
						full_name += data.middle_name+ " ";
					}
					full_name += data.last_name;
					// Combine the two data
					return '' + full_name + '';
				},
			}, {
				"data" : "username"
			}, {
				data : null,
				render : function(data, type, row) {
					// Combine the two data
					if (data.gender == 1) {
						return 'Male';
					} else {
						return 'Female';
					}
				},
			}, {
				"data" : "date_of_birth"
			}, {
				"data" : "address"
			}, {
				"data" : "phone"
			}, {
				"data" : "email"
			}, {
				"data" : "current_semester"
			}, {
				"data" : "status"
			}, {
				data : null,
				render : function(data, type, row) {
					return '<button class="btn btn-success editBtns">Edit</button>';
				},
			} ]
		});

		// edit buttons on subjects row
		$('#view_student tbody').on('click', '.editBtns', function() {
			var table = $("#view_student").DataTable();
			var data = table.row($(this).parents('tr')).data();
			console.log(data);
			alert(data['username'] + "' id is: " + data['s_id']);
		});

	}
	
	
