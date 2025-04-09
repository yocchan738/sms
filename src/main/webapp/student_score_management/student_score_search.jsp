<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form action="/sms/studentscoremanagement/list" method="post">
		<select name="student_id">
			<c:forEach var="s" items="${list }">
				<option value="${s.student_id}">${s.student_name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="送信">
	</form></div>

</body>
</html>