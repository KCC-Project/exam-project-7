

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<jsp:include page="./shared/header.jsp" />

<body>
        
        <!-- Content Area -->
        <div id="page-content-wrapper">
          
			<c:if test="${homeClicked==true}">
				<%@ include file="admin-dashboard.jsp"%>
			</c:if>
         
    </div>
    

	<jsp:include page="./shared/footer.jsp" />