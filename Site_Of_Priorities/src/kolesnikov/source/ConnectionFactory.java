package kolesnikov.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// �������� ����������� � ��
public class ConnectionFactory {

	///////////////////////////////////////////////////
	private String url = "localhost:1521";  // ����� ��
	private String sid = "SiteOfPriori"; // SID ���� ������
	private String user = "sys as sysdba"; // ��� ������������
	private String password = "ARaQLcAQ07"; // ������ ������������
	///////////////////////////////////////////////////
	private static ConnectionFactory object = new ConnectionFactory();	
			
	private ConnectionFactory() {	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	private Connection createConnection() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@" + url + ":" + sid, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connect;
	}
	
	public static Connection getConnection() {
		return object.createConnection();
	}
	
	
}
