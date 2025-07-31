package jdbc1;

import java.sql.*;

public class XCI5DeleteExample {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static final String USER = "xciusername";
	private static final String PASSWORD = "xcipassword";

	public static void main(String[] args) {
		String deleteSQL = "DELETE XCI_MEMBERS WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
			pstmt.setString(1, "iu");
			int rowsDeleted = pstmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("삭제 되었습니다!");
			} else {
				System.out.println("삭제된 행이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}