//bootstrap switch js


/*
 * call this function just after fetching data from server, eg:
 * loadJsonData(load, {json_data}, {html_table_id}
 */
function loadJsonData(callback) {
	alert(callback);
	callback(arguments[1], arguments[2]);
}

function load(results, target_table_id) {
	var data = results;

	var cols = [];

	var exampleRecord = results[0];

	// get keys in object. This will only work if your statement remains true
	// that all objects have identical keys
	var keys = Object.keys(exampleRecord);

	// for each key, add a column definition
	keys.forEach(function(k) {
		cols.push({
			title : k,
			data : k
		// optionally do some type detection here for render function
		});
	});
	cols
			.push({
				title : "Option",
				data : null,
				"defaultContent" : "<button class='btn btn-success edit'>Click!</button>"
			});

	// initialize DataTables
	var table = $('#' + target_table_id + '').DataTable({
		columns : cols
	});

	// add data and draw
	table.rows.add(data).draw();
	enableEdit("faculty_table");
}

function enableEdit(target_table_id) {
	$(document).ready(function() {

		var table = $('#' + target_table_id + '').DataTable();

		$('#' + target_table_id + ' tbody').on('click', '.edit', function() {
			var data = table.row($(this).parents('tr')).data();
			alert(data['faculty_id'] + "'s name is: " + data['faculty_name']);
		});

	});
}
