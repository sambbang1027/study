<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>JSTL(JSP Standard Tag Library)</h2>
		
		<%--  변수  --%>
		<c:set var="msg" value="안녕하세요" />
		<h3>${msg}</h3>
		<h3><c:out value="${msg }"/></h3>		
		<c:remove var="msg" />
		
		<%-- exception이 발생할만한 것들은 캐치태그에 넣는다  --%>
		<c:catch var="ex">
		<%
			int c = 1/0;
		%>
		</c:catch>
		<h3>${ex }</h3>
		
		
		<%-- js를 이용해서 dom handling  --%>
		<c:set var="a" value="1" />
		<c:if test="${a > 0 }" >
			<h3>${a }는 0보다 큽니다</h3>
		</c:if>
		
		<%-- switch 문이라고 생각하면 된다 choose - when- otherwise  --%>
		<c:set var="b" value="사과" />
		<c:choose>
			<c:when test="${ b == '사과' }">
				<h3>사과</h3>
			</c:when>
			<c:otherwise>
				<h3>과일이 아닙니다</h3>
			</c:otherwise>
			
		</c:choose>
		

	</body>
</html>