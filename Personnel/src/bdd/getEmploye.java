package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class getEmploye {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		try 
		{
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/personnel?serverTimezone=UTC","root","");
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT idEmp, nomEmp, preEmp FROM employe");
			ResultSetMetaData rsMeta = rs.getMetaData();
			
			//System.out.println("\n*************************************************************");
			
			for(int i = 1; i <= rsMeta.getColumnCount(); i++)
			{
				System.out.println(" " + rsMeta.getColumnName(i).toUpperCase() + " ");
			}
			
			//System.out.println("\n*************************************************************");
				
				while(rs.next()) 
				{
					for (int i = 1; i <= rsMeta.getColumnCount(); i++)
					{
						System.out.println("         " + rs.getObject(i).toString() + "    ");
						System.out.println("\n-------------------------------------------------------------");
					}
				}
				rs.close();
				st.close();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(0);
		}
	}
}