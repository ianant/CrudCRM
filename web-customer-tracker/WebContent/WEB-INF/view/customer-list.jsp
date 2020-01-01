<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div id=button">

<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'" class="add-button"/>
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
<c:url var="tempCust" value="/customer/getTheCustomer">
<c:param name="customerID" value="${tempCustomers.id}"></c:param>
</c:url>

<tr>
<td>${tempCustomers.firstName}</td>
<td>${tempCustomers.lastName}</td>
<td>${tempCustomers.email}</td>
<td><a href="${tempCust}">Update</a>
</tr>
</c:forEach> 





</table>

</div>


</div>


</div>

</body>

</html>