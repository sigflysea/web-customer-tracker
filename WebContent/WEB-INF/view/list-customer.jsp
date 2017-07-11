<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css"
  		rel="stylesheet"
  		href="${pageContext.request.contextPath}/resources/css/style.css" />


</head>
<body>
 <div id="wrapper">
 	<div id="header">
 	<h2> CRM- Customer Relationship Manager </h2>
 	
 	</div>
 
 
 
 </div>
 
 
 <div id="container">
    <div id="content">
    <!-- add button for new customer-->
   <input type="button" value="Add Customer"
   		onclick="window.location.href='showFormForAdd'; return faluse;"
   		class="add-button"
   		/> 
    
    
    <!--  add html table -->
    <table>
    	<tr>
    	   <th>First Name</th>
    	   <th>Last Name</th>
    	   <th>Email</th>
    	   
    	
    	</tr>
    	
    	<c:forEach var="tempC" items="${customers}" >
    	<tr>
    	
    	<td>${tempC.firstName}</td>
    	<td>${tempC.lastName}</td>
    	<td>${tempC.email}</td>
    	
    	</tr>
    	</c:forEach>
    	
    	
    
    </table>
    
    </div>
 
 </div>
 
 
 
 
</body>

</html>