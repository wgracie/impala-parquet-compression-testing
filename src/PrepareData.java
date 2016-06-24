
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;


public class PrepareData {
	private static String impalaIP = "172.18.0.5";
	private static String schema = "cardinalitytest";
	private static int default_port = 21050;
	private static Connection conn = ImpalaJDBC.getConnection(impalaIP, default_port, schema);
	public static void createTable() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "create table testperf(nt int, bln boolean, dbl double, tmstmp timestamp, chr char(20), strng string, vrchr varchar);";
        Boolean result = stmt.execute(sql);
        stmt.close();
        System.out.print("createTable result: " + result);
        //conn.close();
	}
	
	public static void insertData() throws SQLException {
		Statement stmt = conn.createStatement();
		for(int i = 0; i < 1000; i++) {
	        int testInt = RandomUtils.nextInt();
	        String testString = RandomStringUtils.randomAlphabetic(20);
	        Boolean testBoolean = RandomUtils.nextBoolean();
	        Double testDouble = RandomUtils.nextDouble();
	        String testTimestamp = "now() + interval " + RandomUtils.nextInt(1000000) + " minutes";
	        stmt.execute(insert("int_same_text", 2147483647));
	        stmt.execute(insert("int_diff_text", testInt));
	        stmt.execute(insert("int_increm_text", -2147483648 + 10000*i));
	        stmt.execute(insert("double_same_text", 1.79769313486231570e+308));
	        stmt.execute(insert("double_diff_text", testDouble));
	        stmt.execute(insert("double_increm_text", 4.94065645841246544e-324d + 10000.001*i));
	        stmt.execute(insert("boolean_same_text", true));
	        stmt.execute(insert("boolean_diff_text", testBoolean));
	        stmt.execute(insert("boolean_increm_text", (i % 2 == 0) ? true : false));
	        stmt.execute(insert("string_same_text", "'abcdefghijklmnopqrst'"));
	        stmt.execute(insert("string_diff_text", "'" + testString + "'"));
	        stmt.execute(insert("string_increm_text", "'abcdefghij" + RandomStringUtils.randomAlphabetic(10) + "'"));
	        stmt.execute(insert("timestamp_same_text", "cast ('2016-06-15 17:11:32.868483000' as timestamp)"));
	        stmt.execute(insert("timestamp_diff_text", testTimestamp));
	        stmt.execute(insert("timestamp_increm_text", "cast ('2016-06-15 17:11:32.868483000' as timestamp) + interval " +  28*i + " minutes"));
	        
		}
        stmt.close();
		//conn.close();
	}
	
	public static void insertStringCaridnalityData(int cardinality) throws SQLException {
		Statement stmt = conn.createStatement();
		String tablename = "string_" + cardinality;
		stmt.execute(dropTable(tablename));
		stmt.execute(createStringTextTable(tablename));
		stmt.execute(setCompressionNone());
		String[] strings = new String[cardinality];
		for(int i = 0; i < cardinality; i++) {
			strings[i] = RandomStringUtils.randomAlphabetic(20);
		}
		for(int i = 0; i < 1000; i++) {
			String value = strings[i%cardinality];
			stmt.execute(insert(tablename, value));
		}
		
		// Create text no compression table
		String target = tablename + "_text_nocompress";
		stmt.execute(createStringTextTable(target));
		stmt.execute(setCompressionNone());
		stmt.execute(insertSelect(target, tablename));
		
		// Create parquet none table and insert data 
		target = tablename + "_parquet_none";
		stmt.execute(createStringParquetTable(target));
		stmt.execute(setCompressionNone());
		stmt.execute(insertSelect(target, tablename));
		
		// Create parquet snapp table and insert data
		target = tablename + "_parquet_snappy";
		stmt.execute(createStringParquetTable(target));
		stmt.execute(setCompressionSnappy());
		stmt.execute(insertSelect(target, tablename));
		
		// Create parquet gzip table and insert data
		target = tablename + "_parquet_gzip";
		stmt.execute(createStringParquetTable(target));
		stmt.execute(setCompressionGzip());
		stmt.execute(insertSelect(target, tablename));
		
		stmt.close();	
		
	}
	
	public static String insert(String tablename, Object value) {
		return "insert into " + tablename + " values ('" + value + "');";
	}
	
	public static String insertSelect(String tablename, String source) {
		return "insert into " + tablename + " select x from " + source + ";";
	}
	
	public static String createStringTextTable(String tablename) {
		return "create table " + tablename + "(x string);";	
	}
	
	public static String createStringParquetTable(String tablename) {
		return "create table " + tablename +"(x string) stored as parquet;";
	}
	
	public static String dropTable(String tablename) {
		return "drop table if exists " + tablename + ";";
	}
	
	public static String setCompressionNone() {
		return "set compression_codec=none;";
	}
	
	public static String setCompressionSnappy() {
		return "set compression_codec=snappy;";
	}
	
	public static String setCompressionGzip() {
		return "set compression_codec=gzip;";
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		insertStringCaridnalityData(1);
		insertStringCaridnalityData(10);
		insertStringCaridnalityData(100);
		insertStringCaridnalityData(500);
		insertStringCaridnalityData(1000);

	}

}
