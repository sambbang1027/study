package jdbc1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class XCI1SelectExample2 {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static final String USER = "ace";
	private static final String PASSWORD = "ace";

	public static void main(String[] args) {
		String selectSQL = 
				"""				
				SELECT
				    name,
				    korean,
				    english,
				    math,
				    philosophy
				FROM
				    grade
				 """;
		
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement(); // DB 참조
			ResultSet rs = stmt.executeQuery(selectSQL)) { 
			
			// 1. execute() DDL을 날리기 / executeQuary() 원본 데이터 검색  /executeUpdate() 원본데이터에 변경이 생길때
			System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 철학 \t 총점 \t 평균");
			System.out.println("------------------------------------------------------");
			while (rs.next()) { // 다음 record 가 존재하는지 확인
				String name = rs.getString("NAME");
				int korean = rs.getInt("KOREAN");
				int english = rs.getInt("ENGLISH");
				int math = rs.getInt("MATH");
				int philosophy = rs.getInt("PHILOSOPHY");
				int sum = korean + english+ math + philosophy;
				int avg = sum/4;
				
				System.out.println( name + " \t "+korean +
								" \t " + english + " \t " + math +
								" \t " + philosophy +"\t "+ sum + " \t "+ avg );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}