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
				<h1>사원정보 입력</h1>\
				<form action="./insert" method="post">
				<table border="1">
					<tr>
						<th>EMPLOYEE_ID</th>
						<td><input type="number" name="employeeId" max="99999" required /></td>
					</tr>
					<tr>
						<th>FIRST_NAME</th>
						<td><input type="text" name="firstName" maxlength ="15" placeholder="성을 입력하세요" /></td>
					</tr>
					<tr>
						<th>LAST_NAME</th>
						<td><input type="text" name="lastName"  maxlength ="15" placeholder="이름을 입력하세요"/></td>
					</tr>
					<tr>
						<th>EMAIL</th>
						<td><input type="email" name="email" /></td>
					</tr>
					<tr>
						<th>PHONE_NUMBER</th>
						<td><input type="number" name="phoneNumber" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" /></td>
					</tr>
					<tr>
						<th>HIRE_DATE</th>
						<td><input type="date" name="hireDate" min="2025-08-25" max="2025-09-02" required  /></td>
					</tr>
					<tr>
						<th>JOB_ID</th>
						<td>
								<select name="jobId" >
										<c:forEach var="job" items="${ jobList }">
												<option value="${job.jobId }">${job.jobTitle }</option>
										</c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<th>SALARY</th>
						<td><input type="number" name="salary" min="0"  max="999999" value = "0" /></td>
					</tr>
					<tr>
						<th>COMMISSION_PCT</th>
						<td><input type="number" name="commissionPct" min="0" max="1" step="0.1" value = "0" onkeypress="return false" /></td>			
					</tr>
					<tr>
						<th>MANAGER_ID</th>
						<td>
								<select name="managerId" >
										<c:forEach var="manager" items="${ managerList}">
												<option value="${manager.managerId }">${manager.managerName }</option>
										</c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<th>DEPARTMENT_ID</th>
						<td>
								<select name="departmentId" >
										<c:forEach var="dept" items="${ deptList}">
												<option value="${dept.departmentId }">${dept.departmentName }</option>
										</c:forEach>
								</select>
						</td>
					</tr>
					<tr>
							<th></th>
							<td>
									<button type="submit">사원등록</button>
									<button type="reset">초기화</button>
							</td>	
					</tr>
				</table>
			</form>
					
		</body>
</html>