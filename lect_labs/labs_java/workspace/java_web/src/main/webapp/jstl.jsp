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
		
		
		<%
			String[] list = {"A", "B", "C", "D", "E"};
	    request.setAttribute("list", list);
		%>
		<c:forEach var="i" begin="1" end="3">
		${list[i] }.
		</c:forEach>
		
		<c:forEach var="item" items="${list }" varStatus="idx">
			<div id="div${idx.count }">${idx.count  }. ${item }</div>
		</c:forEach>
		
		<h3>${fn:length(list) }</h3>
		<h3>${fn:replace("A,B,C,D,E" ,  ","  ,  "-") }</h3>
		
		<%--  돈에 관련된 함수 #은 숫자가 없으면 출력이 안되고 0은 숫자가 없으면 0으로 출력 --%>
		<fmt:setLocale value="en_US"/> <%--다국어 페이지 만들때 사용할 수 있는 locale 화폐표시방법 --%>
		<fmt:setLocale value="ko_KR"/>
		<fmt:formatNumber value="500000" type="currency" /> <br>
		<fmt:formatNumber  value="500000" pattern="###,###,###.00"/> <br>

		<jsp:useBean id="today" class="java.util.Date" />
		<div>${today }</div>
		<fmt:formatDate value="${today }" type="date"/>
		<fmt:formatDate value="${today }" type="time"/> <br>
		<fmt:formatDate value="${today }" pattern="yyyy-MM-dd hh:mm:ss"/>


	</body>
</html>