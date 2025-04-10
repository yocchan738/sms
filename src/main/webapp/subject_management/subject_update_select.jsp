<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/parts/header.jsp"></jsp:include>
<jsp:include page="/parts/sidemenu.jsp"></jsp:include>
<div class="main">
	変更する科目を選択してください。<br>
	<form action="/sms/subjectmanagement/update" method="get">
 科目名:<select name="subject_id">
		<c:forEach var="s" items="${subject_list}">
			<option value="${s.subject_id}">${s.subject_name}</option>
		</c:forEach>
		</select><br>
		<input type="submit" value="確定">
	</form></div>
<jsp:include page="/parts/footer.jsp"></jsp:include>