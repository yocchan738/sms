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
<th>科目名</th>
<th>教員名</th>
</tr>
</thead>
<tbody>
<c:forEach var="s" items="${list }">
	<tr>
	<td>${s.subject_name }</td>
	<td>${s.teacher_name }</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>