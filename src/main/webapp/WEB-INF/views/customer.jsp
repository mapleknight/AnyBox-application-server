<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Customer Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Customer
</h1>

<c:url var="addAction" value="/customer/add" ></c:url>

<form:form action="${addAction}" commandName="customer">
<table>
	<c:if test="${!empty customer.firstName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstName">
				<spring:message text="First Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lastName">
				<spring:message text="Last Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty customer.firstName}">
				<input type="submit"
					value="<spring:message text="Edit Customer"/>" />
			</c:if>
			<c:if test="${empty customer.firstName}">
				<input type="submit"
					value="<spring:message text="Add Customer"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Customers List</h3>
<c:if test="${!empty listCustomers}">
	<table class="tg">
	<tr>
		<th width="80">Customer ID</th>
		<th width="120">FirstName</th>
		<th width="120">Last Name</th>
		<th width="120">Email</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCustomers}" var="customer">
		<tr>
			<td>${customer.id}</td>
			<td>${customer.firstName}</td>
			<td>${customer.lastName}</td>
			<td>${customer.email}</td>
			<td><a href="<c:url value='/edit/${customer.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${customer.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
