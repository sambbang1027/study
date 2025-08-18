<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Scope2</h3>
		<ol>
			<li>Application Scope : <%=application.getAttribute("counter") %></li>
			<li>Session Scope : <%=session.getAttribute("counter") %></li>
			<li>Request Scope: : <%=request.getAttribute("type") %></li>
			<li>Page Scope : <%=pageContext.getAttribute("type") %></li>
		</ol>
		
		
	</body>
</html>