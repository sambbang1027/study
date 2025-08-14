<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Ajax 계산기</h3>
		<form name="form1" id="form1" action="." method="post" >
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
		<h3 id="result"></h3>
 	<script>
 		$('#form1').on("submit", function(e){
			e.preventDefault();
			$.post('${pageContext.request.contextPath}/CalcAPIServlet',
						$('#form1').serialize(), function(){
						 /* 객체를 통째로 넘기고 싶을  때 객체 직렬화 한다. */
						console.log("처리중입니다.");
			}).done(function(data){
				$('#result').text(data.result);
				console.log("처리 완료되었습니다.");

			});
		}) 
	</script> 

	</body>
</html>