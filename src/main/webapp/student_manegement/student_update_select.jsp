<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>ok</title>
</head>
<body>
    <div>
    <p>データを更新する学生を選んでください</p><br>
    <form action="/sms/studentmanegement/studentupdate" method="post">
        <select name="id">
            <c:forEach var="s" items="${list }">
                学生名 :<option value="${s.student_id}">${s.student_name}</option><br>
            </c:forEach>
        </select>
        <input type="submit" value="送信">
    </form>

    </div>
</body>
</html>
