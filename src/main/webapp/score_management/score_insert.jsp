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
	<form action="/sms/scoremanagement/insert/commit" method="post">
		生徒名　:<select name="student_id">
		<c:forEach var="s" items="${list_student }">
			<option value="${s.student_id }">${s.student_name }</option>
		</c:forEach>
		</select><br>
		科目名　:<select name="subject_id">
		<c:forEach var="s" items="${list_subject }">
			<option value="${s.subject_id}">${s.subject_name}</option>
		</c:forEach>
		</select><br>
		点数　：<input type="text" name="score_value"><br>
		<input type="submit" value="確定">
	</form></div>
</body>
</html>