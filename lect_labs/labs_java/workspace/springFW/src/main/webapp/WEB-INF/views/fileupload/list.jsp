<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
				<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
		</head>
		<body>
		${message }
		<c:url var="actionUrl" value="/upload/updateDir" />			
			<form name="form01" id="form01" action="${actionUrl }" method="post"  >
				<table border="1">
						<thead>
								<tr>
										<th>ID</th>
										<th>경로</th>
										<th>파일명</th>
										<th>크기</th>
										<th>유형</th>
										<th>날짜</th>
										<th>삭제</th>
								</tr>
						</thead>
						<tbody>
							<c:forEach var="file" items="${fileList }">
								<tr>
										<td>
										<label><input type="checkbox" name="fileIds" value="${file.fileId }" />
										${file.fileId }
										</label>
										</td>
										<td>${file.directoryName }</td>
										<td>
												<c:url var="contentUrl" value="/file/${file.fileId }" />			
												<%-- 확장자 --%>
												<c:set var="len" value="${fn:length(file.fileName) }" />
												<c:set var="filetype" value="${fn:toUpperCase( fn:substring(file.fileName, len-4, len)) }" />
												
												<c:choose>
													<c:when test="${(filetype eq '.JPG') or (filetype eq '.JPEG') 
																			or (filetype eq '.PNG') or (filetype eq '.GIF') }">
														<img src="${contentUrl }"  style="width : 200px;"/>
													</c:when>
													<c:otherwise>
														<a href="${contentUrl }" >${file.fileName }</a>
													</c:otherwise>
												</c:choose>
												
										</td>
										<td>
											<fmt:formatNumber value=" ${file.fileSize/1024 }" pattern="###,###,###" />KB
										</td>
										<td>${file.fileContentType }</td>
										<td>
												<fmt:formatDate value="${file.fileUploadDate  }" pattern="yyyy-MM-dd"/>
										</td>
										<td>					
												<c:url var="deleteUrl" value="/upload/delete/${file.fileId }" />			
												<a href="${deleteUrl }" class="delete">삭제</a>
										</td>
								</tr>
							</c:forEach>
						</tbody>
				</table>
				<div>
					<select name="directoryName">
			            	<option value="/">/</option>
				            <option value="/images">/이미지</option>
				            <option value="/data">/자료실</option>
				            <option value="/bigdata">/빅데이터</option>
				            <option value="/common">/공통</option>
			        </select>(으)로 <input type="submit" value="이동">
				</div>
				</form>
				<p>
						<a href='<c:url value="/upload/new"/>'>업로드</a>
						<a href='<c:url value="/upload/"/>'>처음으로</a>
				</p>
				<script>
						// 요소 선택자  
						$('.delete').on('click', function(){
							//	alert($(this).attr('href')); // 클릭된 요소의 href의 attribute값을 알럿으로 띄워라 라는 의미 
								if(confirm('이 작업은 되돌릴 수 없습니다. 파일을 삭제하겠습니까?')){
									return true;
								}else{
									return false;
								}
						});
						
						
						$('#form01').on('submit', function(e){
							e.preventDefault();
							let cnt = $('input[name="fileIds"]:checked').length; // input 태그중 name이 fileids인 것 중 체크된 것만 갯수 세기
							console.log(cnt);
							if(cnt > 0){
									$(this).unbind('submit').submit();
									//e.preventDefault() 때문에 기본 폼 제출 동작을 막아버린다 그래서 
									// 이벤트를 한 번 제거 후 다시 이벤트를 만들어 줘야한다 
							}else{
								alert('이동할 파일을 선택해 주세요');
							}
						});
				</script>
		</body>
</html>