package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CateYearDao {
	public ArrayList<String> selectCateLangList(int y) throws Exception {
		ArrayList<String> list = new ArrayList<>();
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/m1","root","java1234");
		String sql = "select lang from cate_lang where y = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, y);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			list.add(rs.getString("lang")); // 언어 문자 리스트
		}
		return list;
	}
	
	public ArrayList<Integer> selectCateYearList() throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/m1","root","java1234");
		String sql = "select y from cate_year";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			list.add(rs.getInt("y")); // 2021, 2022, 2023
		}
		return list;
	}
}
