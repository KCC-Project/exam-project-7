

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<jsp:include page="../shared/header.jsp" />

<!-- Content Area -->
<div id="page-content-wrapper">
	<button id="edit">Edit</button>
	<table id="faculty_table" class="table table-hover table-striped" width="100%">
	</table>
	<div id="demo"></div>


	<script>

const url = window.context +"/ApiFaculty/GetAllFaculty";

// setting header type
var myHeaders = new Headers();
myHeaders.append("Accept", "application/json");

// describing request
var myInit = { method: 'GET',
               headers: myHeaders,
               cache: 'default' };
// setting up the final request variable
var myRequest = new Request(url, myInit);


// fetch api,  
fetch(myRequest)
.then((resp) => resp.json())
.then(function(data) {
  let results = data;
    
  /* create datatable as per json format and load it into given table id */
    loadJsonData (load, results, "faculty_table");
   
 // var dataArray =  
   //if(dataArray){
	 //  alert( data['faculty_id'] +"'s name is: "+ data[ 'faculty_name' ] );
   //}
  /* --------- */
})
.catch(function(error) {
  console.log(error);
});   


</script>


</div>

<jsp:include page="../shared/footer.jsp" />