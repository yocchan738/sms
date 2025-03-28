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
 		<c:forEach var="s" items="${select_student }">
 			<c:set var="select_student_id" value="${s.student_id }"/>
 		</c:forEach>
 		<c:forEach var="sub" items="${select_subject }">
 			<c:set var="select_subject_id" value="${sub.subject_id }"/>
 		</c:forEach>
 		<c:forEach var="sc" items="${select_scores }">
 			<c:set var="select_score_id" value="${sc.score_id }"/>
 			<c:set var="select_score_value" value="${sc.score_value }"/>
 		</c:forEach>
	<div>
	変更する学生、教員、点数を入力してください。<br>
	<form action="/sms/scoremanegement/update/commit" method="post">
		<input type="hidden" name="score_id" value="${select_score_id }">
 学生名:<select name="student_id">
		<c:forEach var="s" items="${list_student}">
			<option value="${s.student_id}" ${s.student_id eq select_student_id ? "selected" : "" }>${s.student_name}</option>
		</c:forEach>
		</select><br>
 教員名:<select name="subject_id">
		<c:forEach var="sub" items="${list_subject}">
			<option value="${sub.subject_id}" ${sub.subject_id eq select_subject_id ? "selected" : "" }>${sub.subject_name}</option>
		</c:forEach>
		</select><br>
 点数　:<input type="text" name="score_value" value="${select_score_value }">
		<input type="submit" value="確定">
	</form></div>
</body>
</html>