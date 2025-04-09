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
	<form action="/sms/subjectmanagement/insert/commit" method="post">
		科目名　:<input type="text" name="subject_name"><br>
		教員名　:<select name="teacher_id">
		<c:forEach var="s" items="${list }">
			<option value="${s.teacher_id}">${s.teacher_name}</option>
		</c:forEach>
		</select><br>
		<input type="submit" value="確定">
	</form></div>
</body>
</html>