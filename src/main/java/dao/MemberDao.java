package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	// "Y": 사용가능 , "N":사용불가
	public String selectMemberId(String idck) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/m1","root","java1234");
		String sql = "select * from member where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, idck);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			return "N";
		}
		return "Y";
	}
}
