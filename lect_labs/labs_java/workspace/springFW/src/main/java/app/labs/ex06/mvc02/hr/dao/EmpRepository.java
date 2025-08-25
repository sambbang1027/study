package app.labs.ex06.mvc02.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import app.labs.ex06.mvc02.hr.model.Emp;



@Repository
public class EmpRepository implements IEmpRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/* RowMapper -> DB의 table row 1개와 empVO를  컬럼명과 
	 * 프로퍼티, 데이터타입을 매칭하는 인터페이스
	 * DB는 snake, java는 camel이고 데이터 타입도 다르기 때문에 매칭이 필요  
	 */
	private class EmpMapper implements RowMapper<Emp>{

		@Override
		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp emp = new Emp();

			emp.setEmployeeId(rs.getInt("EMPLOYEE_ID")); // 이값을 인트로 가져와서 VO 매핑하겠다 
			emp.setFirstName(rs.getString("FIRST_NAME"));
			emp.setLastName(rs.getString("LAST_NAME"));
			emp.setEmail(rs.getString("EMAIL"));
			emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
			emp.setHireDate(rs.getDate("HIRE_DATE"));
			emp.setJobId(rs.getString("JOB_ID"));
			emp.setSalary(rs.getDouble("SALARY"));
			emp.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
			emp.setManagerId(rs.getInt("MANAGER_ID"));
			emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
			
			return emp;
		}
		
	}
	
	
	@Override
	public int getEmpCount() {
		String sql = "SELECT COUNT(*) FROM employees";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getEmpCount(int deptId) {
		String sql = """
							SELECT COUNT(*) 
							FROM employees
							WHERE department_id = ?
							""";
		return jdbcTemplate.queryForObject(sql, Integer.class, deptId); 
		// sql 문 넘기고 integer로 결과값 반환받고, deptId 매개변수 전달 
		//jdbcTemplate -> PSA 라고 한다 
	}

	@Override
	public List<Emp> getEmpList() {
		String sql = "SELECT * FROM employees ORDER BY employee_id DESC";
		return jdbcTemplate.query(sql, new EmpMapper());
	}

	@Override
	public Emp getEmpInfo(int empId) {
		String sql = """
							SELECT * 
							FROM employees
							WHERE employee_id =?
							""";
		return jdbcTemplate.queryForObject(sql, new EmpMapper(),empId);
	}

	@Override
	public void insertEmp(Emp emp) {
		String sql = """
				INSERT INTO employees 
				(employee_id, first_name, last_name, email, phone_number
				, hire_date, job_id, salary, commission_pct, manager_id, department_id )
				VALUES (?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?)
							""";
		jdbcTemplate.update(sql, emp.getEmployeeId(),
									                emp.getFirstName(),
									                emp.getLastName(),
									                emp.getEmail(),
									                emp.getPhoneNumber(),
									                emp.getJobId(),
									                emp.getSalary(),
									                emp.getCommissionPct(),
									                emp.getManagerId(),
									                emp.getDepartmentId());
	}

	@Override
	public void updateEmp(Emp emp) {
			String sql = """
								UPDATE employees
								SET first_name =?, last_name =?, email =?, salary=?
								WHERE employee_id = ?
								""";
			jdbcTemplate.update(sql, emp.getFirstName()
														,emp.getLastName()
														,emp.getEmail()
														,emp.getSalary()
														,emp.getEmployeeId());
	}

	@Override
	public int deleteEmp(int empId, String email) {
			String sql = "DELETE FROM employees WHERE employee_id =? AND email =?";
			return jdbcTemplate.update(sql,empId, email) ;
	}

	@Override
	public void deleteJobHistory(int empId) {
			String sql = "DELETE FROM job_history WHERE employee_id =? ";
			jdbcTemplate.update(sql,empId);
	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		
		String sql = """
							SELECT department_id AS departmentId, department_name AS departmentName
							FROM departments
							""";
				return jdbcTemplate.queryForList(sql); // 자동으로 매핑됨 
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		String sql = """
							SELECT job_id AS jobId , job_title AS jobTitle
							FROM jobs
							""";
				return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		String sql = """
							SELECT DISTINCT e.manager_id AS managerId , e2.first_name AS managerName
							FROM employees e
							JOIN employees e2  on e.manager_id = e2.employee_id
							ORDER BY e.manager_id
							""";
				return jdbcTemplate.queryForList(sql);
	}

}
