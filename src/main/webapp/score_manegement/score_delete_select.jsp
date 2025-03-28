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
	<p>選択してください</p>
	<form action="/sms/scoremanegement/delete/commit" method="post">
		<select name="score_id">
		<c:forEach var="s" items="${list_scores }">
			<option value="${s.score_id }">${s.student_name }:${s.subject_name }</option>
		</c:forEach>
		</select><br>
		<input type="submit" value="確定">
	</form></div>
</body>
</html>