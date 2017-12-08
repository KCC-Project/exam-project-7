

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



 

<c:set var="cpp" scope="application">${pageContext.request.contextPath}</c:set>
 <c:if test = "${ empty sessionScope.adminUserName }">
         <c:redirect url = "${cpp } "/>
      </c:if>
<jsp:include page="../jsp/admin/shared/header.jsp" />

<body>
        
        <!-- Content Area -->
        <div id="page-content-wrapper">
          

         
    </div>
    

	<jsp:include page="../jsp/admin/shared/footer.jsp" />