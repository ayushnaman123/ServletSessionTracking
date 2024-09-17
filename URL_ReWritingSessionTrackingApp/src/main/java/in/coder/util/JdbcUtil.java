package in.coder.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	private JdbcUtil() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		FileInputStream fis = new FileInputStream(new File(
				"D:\\ineuron\\PracticeServlet\\URL_ReWritingSessionTrackingApp\\src\\main\\java\\in\\coder\\properties\\Application.properties"));
		Properties properties = new Properties();
		properties.load(fis);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
				properties.getProperty("password"));
		return connection;
	}
}
