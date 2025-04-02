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
<table border="1">
<thead>
<tr>
<th>学生ID</th>
<th>学生名</th>
<th>学校名</th>
<th>クラス名</th>
</tr>
</thead>
<tbody>
<c:forEach var="s" items="${list }">
	<tr>
	<th>${s.student_id }</th>
	<td>${s.student_name }</td>
	<td>${s.school_name }</td>
	<td>${s.class_name }</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>