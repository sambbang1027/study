package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JdbcTest1 {
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static final String USER = "ace";
	private static final String PASSWORD = "ace";
	
	public static void main(String[] args) {
	
		String insertSQL = 
				"""
				INSERT INTO emp_temp (last_name, salary, job_id, department_id)
				VALUES(?,?,?,?)
				""";
		
		String selectSQL =
				"""
				SELECT department_id, department_name 
				FROM departments
				""";
		
		try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				Statement stm = conn.createStatement();
						ResultSet rs = stm.executeQuery(selectSQL)){
				try(Scanner sc = new Scanner(System.in)){
					System.out.print("사원명 : "); 
					String name = sc.next(); 
					System.out.print("\n 급여 : "); 
					int salary = sc.nextInt();
					System.out.print("\n JobId : "); 
					String jobId = sc.next();
	
					System.out.println("부서정보를 먼저 확인하세요.");
					System.out.println("부서ID \t 부서명");
					
					Set<Integer> dep = new HashSet<>();
					while(rs.next()) {
						System.out.println(rs.getInt("DEPARTMENT_ID")+"\t"+rs.getString("DEPARTMENT_NAME"));
						dep.add(rs.getInt("DEPARTMENT_ID"));
					}
					
					System.out.print("\n 부서ID : "); 
					int departmentId = sc.nextInt();
				
					for(int num : dep) {
						if(dep.contains(departmentId) ){
							System.out.println("사원을 등록합니다.");
							break;
						}else {
							System.out.println("해당 부서가 존재하지 않습니다.");
							break;
						}

					}
					pstmt.setString(1, name);
					pstmt.setInt(2, salary);
					pstmt.setString(3, jobId);
					pstmt.setInt(4,departmentId);
					
					int rowsInserted = pstmt.executeUpdate();
					if( rowsInserted> 0) {
						System.out.println("사원이 등록되었습니다.");
					}else {
						System.out.println("사원 등록에 실패하였습니다.");

					}
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
