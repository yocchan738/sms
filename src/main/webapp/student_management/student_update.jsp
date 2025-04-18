<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/parts/header.jsp"></jsp:include>
<jsp:include page="/parts/sidemenu.jsp"></jsp:include>
<div class="main">
<c:forEach var="s" items="${select_student }">
	<c:set var="select_student_id" value="${s.student_id }"/>
	<c:set var="select_student_name" value="${s.student_name }"/>
</c:forEach>
<c:forEach var="c" items="${select_class }">
	<c:set var="select_class_id" value="${c.class_id }"/>
</c:forEach>
<c:forEach var="sch" items="${select_school }">
	<c:set var="select_school_id" value="${sch.school_id }"/>
</c:forEach>
<div>
    <h2>学生情報の更新</h2>
    <form action="/sms/studentmanagement/update/commit" method="post">
		<input type="hidden" name="student_id" value="${select_student_id }">
        お名前：
        <input type="text" name="student_name" value="${select_student_name}">
<br>

        クラス名：
        <select name="class_id">
            <c:forEach var="c" items="${class_list}">
                <option value="${c.class_id}" ${c.class_id eq select_class_id ? "selected" : "" }>${c.class_name}</option>
            </c:forEach>
        </select><br>

        学校名：
        <select name="school_id">
            <c:forEach var="a" items="${school_list}">
                <option value="${a.school_id}" ${a.school_id eq select_school_id ? "selected" : "" }>${a.school_name}</option>
            </c:forEach>
        </select><br>

        <input type="submit" value="確定">
    </form>
</div>

</div>
<jsp:include page="/parts/footer.jsp"></jsp:include>
