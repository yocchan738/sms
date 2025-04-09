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
	<form action="/sms/studentmanagement/insert/commit" method="post">
		学生名　:<input type="text" name="name"><br>
		学校名　:<select name="school_id">
		<c:forEach var="s" items="${school_list }">
			<option value="${s.school_id}">${s.school_name}</option>
		</c:forEach>
		</select><br>
		クラス名:<select name="class_id">
		<c:forEach var="c" items="${class_list }">
			<option value="${c.class_id}">${c.class_name}</option>
		</c:forEach>
		</select><br>
		<input type="submit" value="確定">
	</form></div>
</body>
</html>