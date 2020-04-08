package jdbc;

public class Credentials {

	private static String driver ="mysql",
            driverClassName = "com.mysql.cj.jdbc.Driver",
            host = "localhost", 
            port ="3306",
            database ="personnel",
            user = "root",
            password = "",
            timeZone ="serverTimezone=UTC";
    static String getUrl() 
    {
        return "jdbc:" + driver + "://" + host+":"
    +port+ "/" + database+"?"+timeZone;
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
