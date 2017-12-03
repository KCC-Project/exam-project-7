
$(".menu-toggle").click(function(e) {
	e.preventDefault();
	$("#wrapper").toggleClass("toggled");
});


/* call this function just after fetching data from server, eg: loadJsonData(load, {json_data}, {html_table_id} */
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

	// initialize DataTables
	var table = $('#'+target_table_id+'').DataTable({
		columns : cols
	});

	// add data and draw
	table.rows.add(data).draw();
	enableEdit(target_table_id);
}

function enableEdit(target_table_id) {
	$(document).ready(
			function() {

				var oTable = $('#'+target_table_id+'').DataTable();

				$('#'+target_table_id+'').on('click', 'tr', function() {
					$(this).toggleClass('selected');
					var pos = oTable.row(this).index();
					var row = oTable.row(pos).data();
					console.log(row);
				});

				$('#edit').click(
						function() {
							var oData = oTable.rows('.selected').data();

							for (var i = 0; i < oData.length; i++) {
								alert("Name: " + oData[i][0] + " data2: "
										+ oData[i][1] + " data3: "
										+ oData[i][2]);
							}

						});

			});
}
