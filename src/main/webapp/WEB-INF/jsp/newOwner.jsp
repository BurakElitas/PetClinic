<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="owner" method="post">
		First Name:<form:input path="firstName"/>
		<form:errors path="firstName" cssStyle="color:red"></form:errors>
		Last Name:<form:input path="lastName"/>
		<form:errors path="lastName"  cssStyle="color:red"></form:errors>
		<form:button name="submit">Create</form:button>
	</form:form>
</body>
</html>