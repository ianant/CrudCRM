<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>

Customer list

</title>
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

<div id="wrapper">
<div id="header">

<h2>CRM: Customer Relationship Management System</h2>

</div>
<div id="container">
<div id="button">

<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'" class="add-button"/>
</div>

<div id="button">

<form:form action="search" method="GET">
Search Customer<input type="text" name="theSearchName"/>
<input type="submit" value="search" class="add-button"/>
</form:form>

</div>


<div id="content">

<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Action</th>
</tr>
<c:forEach var="tempCustomers" items="${customers}">
<c:url var="updateCust" value="/customer/getTheCustomer">
<c:param name="customerID" value="${tempCustomers.id}"></c:param>
</c:url>

<c:url var="deleteCust" value="/customer/delete">
<c:param name="customerID" value="${tempCustomers.id}"></c:param>
</c:url>



<tr>
<td>${tempCustomers.firstName}</td>
<td>${tempCustomers.lastName}</td>
<td>${tempCustomers.email}</td>
<td><a href="${updateCust}">Update</a>|<a href="${deleteCust}" 
onclick="if(!(confirm('are you sure you want to delete the customer?'))) return false">Delete</a></td>
</tr>
</c:forEach> 





</table>

</div>


</div>


</div>

</body>

</html>