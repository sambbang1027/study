<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	String result1 = (String)request.getAttribute("result");
%>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Servlet 계산기</h3>
		<form name="form1" action="${pageContext.request.contextPath}/CalcServlet" method="post" >
			<input type="number" name="num1" size="5" required />
			<select name="operator" >
				<option value="+" selected>+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select>
			<input type="number" name="num2" size="5" required />
			<button type="submit">계산</button>
			<button type="reset">초기화</button>
		</form>
		<h3>결과: <%=result1 %></h3>
		<h3>결과: ${result}</h3> <%-- 표현식(EL) --%>
	</body>
</html>