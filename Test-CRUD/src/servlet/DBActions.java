package servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.User;

public class DBActions {

	public static List<User> getAll() throws SQLException {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT id, name, surname, birthdate, creationTimeStamp, age, type FROM crud_users";
		
		Connection conn = ConnHelper.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String surname = resultSet.getString("surname");
			Date bDate = resultSet.getDate("birthdate");
			Timestamp cts = resultSet.getTimestamp("creationTimeStamp");
			int age = resultSet.getInt("age");
			User.eType type = User.charStrToEnum(resultSet.getString("type"));
			
			User user = new User(id, name, surname, bDate, cts, age, type);
			list.add(user);
		}
		
		return list;
	}
}
