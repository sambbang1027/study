<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Session</h3>
		<%
			String userName = (String)session.getAttribute("user_name");
			if(session.isNew() || userName == null ){
		%>
		<form method="post" action="${pageContext.request.contextPath}/SessionEx">
            성명: <input type="text" name="user_name" required> 
            <button type="submit">로그인</button>
        </form>
		<%
			}
				session.removeAttribute("user_name");
				/*  하나하나 선택해 지울 때 */
				session.invalidate(); 
				/*  현재 클라이언트 정보를 전체 지울 때 */
		%>
		
		<h4>Session Info : <%=userName %></h4>
		
	</body>
</html>