import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DataTypeTesting {
	private static int repeat = 10;
	private static Connection conn = ImpalaJDBC.getConnection("localhost");
	public static String testIntSql() {
		return "select count(*) from testperf where nt = 280461550;";

	}
	
	public static String testDoubleSql() {
		return "select count(*) from testperf where dbl = 0.7574971114158894;";

	}
	
	public static String testBooleanSql() {
		return "select count(*) from testperf where bln = true;";

	}
	
	public static String testCharSql() {
		return "select count(*) from testperf where chr = 'kHAYJuypIIbGzoZAgupu';";

	}
	
	public static String testStringSql() {
		return "select count(*) from testperf where strng = 'kHAYJuypIIbGzoZAgupu';";

	}
	
	public static String testVarcharSql() {
		return "select count(*) from testperf where vrchr = 'kHAYJuypIIbGzoZAgupu';";

	}
	
	public static String testTimestampSql() {
		return "select count(*) from testperf where tmstmp = '2016-06-07 07:12:24.900410000';";
	}	
	
	public static void runQuery(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		long start = System.currentTimeMillis();
		for(int i = 0; i < repeat; i++) {
			stmt.execute(sql);
		}
		long end = System.currentTimeMillis();
		long elapsed = end - start;
		stmt.close();
		System.out.println(sql);
		System.out.println("repeat: " + repeat);
		System.out.println("elapsed(ms): " + elapsed);
	}
	public static void main(String[] args) throws SQLException {
		runQuery(testIntSql());
		runQuery(testBooleanSql());
		runQuery(testDoubleSql());
		runQuery(testCharSql());
		runQuery(testStringSql());
		runQuery(testVarcharSql());
		runQuery(testTimestampSql());
		
		
	}

}
