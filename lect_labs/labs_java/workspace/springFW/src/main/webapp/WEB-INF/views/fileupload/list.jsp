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
										<td>${file.fileName }</td>
										<td><fmt:formatNumber value=" ${file.fileSize/1024 }" pattern="###,###,###" />KB</td>
										<td>${file.fileContentType }</td>
										<td>${file.fileUploadDate }</td>
										<td>삭제</td>
								</tr>
							</c:forEach>
						</tbody>
				</table>
		</body>
</html>