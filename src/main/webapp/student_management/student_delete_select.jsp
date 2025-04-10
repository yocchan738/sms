<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/parts/header.jsp"></jsp:include>
<jsp:include page="/parts/sidemenu.jsp"></jsp:include>
<div class=main">
<h2>削除したい学生を選択してください。</h2><br>
	<div>
		<form action="/sms/studentmanagement/delete/commit" method="post">
			<select name="id">
				<c:forEach var="s" items="${student_list }">
                学生名 :<option value="${s.student_id}">${s.student_name}</option>
					<br>
				</c:forEach>
			</select> <input type="submit" value="送信">
		</form>

	</div>
</div>
<jsp:include page="/parts/footer.jsp"></jsp:include>