<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Title here</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<td>ID </td>
				<td>First Name</td>
				<td>Last Name</td>
			</tr>
			
		</thead>
		<hr/>
			<c:forEach items="${owners}" varStatus="status" var="owner">
				<tr bgcolor="${status.index %2== 0 ? 'white':'lightgray'}">
					<td>${owner.id}</td>
					<td>${owner.firstName}</td>
					<td>${owner.lastName}</td>
				</tr>
			</c:forEach>
		
	</table>
	<c:if test="${not empty message }">
		<div style="color:blue">
			${message}
		</div>
	</c:if>
</body>
</html>