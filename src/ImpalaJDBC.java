import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ImpalaJDBC {
	private static String impala_driver = "org.apache.hive.jdbc.HiveDriver";
	private static String impalaIP = "172.18.0.5";
	private static String default_schema = "default";
	private static int default_port = 21050;
	
	public static Connection getConnection() {
		return getConnection(impalaIP, default_port, default_schema);
	}
	
	public static Connection getConnection(String impalaIP, int port, String schema){
		Connection con = null;
		try {
			Class.forName(impala_driver);
			con = DriverManager.getConnection("jdbc:hive2://" + impalaIP + ":" + port + "/" + schema + ";auth=noSasl");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public Connection getConnection(String impalaIP, String schema){
		return getConnection(impalaIP, default_port, schema);
	}
	
	public static Connection getConnection(String impalaIP){
		return getConnection(impalaIP, default_port, default_schema);
	}
	
	public static void main(String[] args) throws SQLException {
		ImpalaJDBC impalaJDBC = new ImpalaJDBC();
		Connection conn = impalaJDBC.getConnection();
		System.out.println(conn);
		conn.close();
	}

}
