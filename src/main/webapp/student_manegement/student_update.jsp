<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <div>
        <h2>学生情報の更新</h2>
            <form action="/sms/studentmanegement/studentchange" method="post">
                <input type="hidden" name="id" value="${s.student_id }">

                <label for="name">お名前　：</label>
                <input type="text" name="name" value="${s.student_name }">
                    
                </input>
                <br>

                <label for="course">クラス名：</label>
                クラス名:<select name="class_id">
						<c:forEach var="c" items="${class_list }">
							<option value="${c.class_id}">${c.class_name}</option>
						</c:forEach>
						</select><br>
				学校名　:<select name="school_id">
						<c:forEach var="s" items="${school_list }">
							<option value="${s.school_id}">${s.school_name}</option>
						</c:forEach>
						</select><br>
                <input type="submit" value="確定">
	</form></div>
</body>
</html>