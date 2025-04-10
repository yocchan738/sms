<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/parts/header.jsp"></jsp:include>
<jsp:include page="/parts/sidemenu.jsp"></jsp:include>
<div class="main">
<c:forEach var="sa" items="${list_sum_avg }">
	<c:set var="student_name" value="${sa.student_name }"/>
	<c:set var="sum" value="${sa.score_sum }"/>
	<c:set var="avg" value="${sa.score_avg }"/>
</c:forEach>
<h1>${student_name }</h1>
<table border="1">
<thead>
<tr>
<th>科目名</th>
<th>点数</th>
</tr>
</thead>
<tbody>
<c:forEach var="s" items="${list }">
	<tr>
	<td>${s.subject_name }</td>
	<td>${s.score_value }</td>
	</tr>
</c:forEach>
<tr>
	<th>合計</th>
	<td>${sum }</td>
</tr>
<tr>
	<th>平均</th>
	<td>${avg }</td>
</tr>
</tbody>
</table>
</div>
<jsp:include page="/parts/footer.jsp"></jsp:include>