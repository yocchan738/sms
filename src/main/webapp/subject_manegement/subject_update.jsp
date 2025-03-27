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
 		<c:forEach var="s" items="${subject_select_id }">
 			<c:set var="select_subject_id" value="${s.subject_id }"/>
 		</c:forEach>
 		<c:forEach var="t" items="${teacher_select_id }">
 			<c:set var="select_teacher_id" value="${t.teacher_id }"/>
 		</c:forEach>
	<div>
	変更する科目や教員名を選択してください。<br>
	<form action="/sms/subjectmanegement/update/commit" method="post">
 科目名:<select name="subject_id">
		<c:forEach var="s" items="${subject_list}">
			<option value="${s.subject_id}" ${s.subject_id eq select_subject_id ? "selected" : "" }>${s.subject_name}</option>
		</c:forEach>
		</select><br>
 教員名:<select name="teacher_id">
		<c:forEach var="t" items="${teacher_list}">
			<option value="${t.teacher_id}" ${t.teacher_id eq select_teacher_id ? "selected" : "" }>${t.teacher_name}</option>
		</c:forEach>
		</select><br>
		<input type="submit" value="確定">
	</form></div>
</body>
</html>