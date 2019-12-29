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

<div id="content">

<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>email</th>
</tr>
<c:forEach var="tempCustomers" items="${customers}">

<tr>
<td>${tempCustomers.firstName}</td>
<td>${tempCustomers.firstName}</td>
<td>${tempCustomers.email}</td>
</tr>
</c:forEach> 





</table>

</div>


</div>


</div>

</body>

</html>