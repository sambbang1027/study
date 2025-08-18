<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%-- 
	01. 영역 객체
		 - page (한 페이지 내 사용되는 변수)
		  <  request(페이지 전달이라 여러 페이지 내에서 사용 가능 )
		  < session(브라우저(클라이언트)단위 상태 유지)
		  < application(서블릿 컨테이너가 중단될 때 까지 유지)
  --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
			<h1>Scope</h1>
			<%
				Integer counter = (Integer)application.getAttribute("counter");
				if(counter == null || counter == 0){
					counter = 1;
				}else{
					++counter;
				}
				
				application.setAttribute("counter", counter);
				
				
				
				Integer counter1 = (Integer)session.getAttribute("counter");
				if(counter1 == null || counter1 == 0){
					counter1 = 1;
				}else{
					++counter1;
				}
				
				application.setAttribute("counter", counter1);
				
			%>
			
			<ol>
				<li>총 카운터  : <%=counter %></li>
				<li>지역 카운터  : <%=counter1 %></li>
			</ol>
			
			
		<%
			request.setAttribute("type", "request");
			pageContext.setAttribute("type", "page");
			
		%>
		
		<jsp:forward page="./scope2.jsp"></jsp:forward>
	</body>
</html>