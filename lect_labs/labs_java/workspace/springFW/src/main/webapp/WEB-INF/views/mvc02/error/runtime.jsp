<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
		</head>
		<body>
				<h1>ERROR PAGE</h1>
				<p>처리 중 오류가 발생하였습니다. 담당자에게 문의하세요</p>
				
				<!--  
					URL : ${url }
					Exception : ${exception.message}
					<c:forEach items="${exception.stackTrace}" var="ste">    ${ste} </c:forEach>	오류 전체를 보고싶을때 
				-->
		</body>
</html>