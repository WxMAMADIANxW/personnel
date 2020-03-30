package jdbc;

public class Credentials {

	private static String driver ="mysql",
			driverClassName = "com.mysql.cj.jdbc.Driver",
			host = "localhost", 
			port ="8889",
			database ="personnel",
			timeZone ="serverTimezone=UTC",
			user = "root",
			password = "root";

	static String getUrl() 
	{
		return "jdbc:" + driver + "://" + host + ":" + port + "/" + database + "?" + timeZone;
	}

	static String getDriverClassName()
	{
		return driverClassName;
	}

	static String getUser() 
	{
		return user;
	}

	static String getPassword() 
	{
		return password;
	}
}
	

