<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이렇게 하면 이 페이지가 컨트롤러단의 역할을 한다.  --%>

    <%-- servic단이 됨  --%>
<jsp:useBean id="calc" class="app.labs.servlet.CalcBean"/> <%-- action tag --%>

<jsp:setProperty name="calc" property="*" />
<%-- bean의 이름과 폼필드의 name이 같다면 자동으로 setter가 호출되어 자동으로 입력된다.  --%>
<%
	calc.calculate();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Servlet 계산기</h3>
		<form name="form1" action="calc2.jsp" method="post" >
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
		<h3>결과: <jsp:getProperty property="result" name="calc"/></h3> 
		<h3>결과: ${calc.result}</h3> <%-- 표현식(EL)  --%>
	</body>
</html>