

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<jsp:include page="../shared/header.jsp" />

<!-- Content Area -->
<div id="page-content-wrapper">

<table id="example" class="display" width="100%">
      </table>
<div id="demo">
</div>


	<script>
function createNode(element) {
    return document.createElement(element);
}

function append(parent, el) {
  return parent.appendChild(el);
}

const ul = document.getElementById('authors');
const url = 'https://randomuser.me/api/?results=10';
fetch(url)
.then((resp) => resp.json())
.then(function(data) {
  let authors = data.results;
    
    callbackTester (load, authors);
})
.catch(function(error) {
  console.log(error);
});   




function callbackTester (callback) {
alert(callback);
  callback (arguments[1]);
}
function load(author){
var data = author;

$(document).ready( function () {
var cols = [];

var exampleRecord = data[0];

//get keys in object. This will only work if your statement remains true that all objects have identical keys
var keys = Object.keys(exampleRecord);

//for each key, add a column definition
keys.forEach(function(k) {
  cols.push({
    title: k,
    data: k
    //optionally do some type detection here for render function
  });
});

//initialize DataTables
var table = $('#example').DataTable({
  columns: cols
});

//add data and draw
table.rows.add(data).draw();
 $('#example tbody').on( 'click', 'tr', function () {
      if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
      }
      else {
          table.$('tr.selected').removeClass('selected');
          $(this).addClass('selected');
      }
  } );

  $('#button').click( function () {
      table.row('.selected').remove().draw( false );
  } );
});
}
</script>


</div>

<jsp:include page="../shared/footer.jsp" />