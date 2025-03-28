<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生情報の更新</title>
</head>
<body>

<div>
    <h2>学生情報の更新</h2>
    <form action="/sms/studentmanegement/studentupdatecomit" method="post">

        お名前：
        <input type="text" name="student_name" value="${student.student_name}">
<br>

        クラス名：
        <select name="class_id">
            <c:forEach var="c" items="${class_list}">
                <option value="${c.class_id}">${c.class_name}</option>
            </c:forEach>
        </select><br>

        学校名：
        <select name="school_id">
            <c:forEach var="a" items="${school_list}">
                <option value="${a.school_id}">${a.school_name}</option>
            </c:forEach>
        </select><br>

        <input type="submit" value="確定">
    </form>
</div>

</body>
</html>
