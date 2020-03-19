package bdd;


import java.util.*;



import java.sql.*;
import java.sql.Date;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.Passerelle;
import personnel.SauvegardeImpossible;


public class connexionBdd implements Passerelle{
	private static Connection myConn ;
	
    public static void main(String[] args) throws Exception{
    	
    	
    	myConn = null;
    	
    	try {
    		Properties props = new Properties();
            props.load(new FileInputStream("demo.properties"));
            
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String dburl = props.getProperty("dburl");
            
            myConn = DriverManager.getConnection(dburl, user, password);
            
            System.out.println("Connecté à la BDD");	
    	}
    	 
         catch(SQLException e)
 		{
 			System.out.println(e);
 		}
        
    }
    
    public List<Employe> chercheEmploye(String nom) throws Exception {
		List<Employe> list = new ArrayList<>();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			nom += "%";
			st = myConn.prepareStatement("select * from employe where nomEmp like ?");
			
			st.setString(1, nom);
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				Employe tempEmployee = convertRowToEmploye(rs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			close(st, rs);
		}
	}

    
    
    public List<Employe> getEmploye() throws Exception {
    	List<Employe> list = new ArrayList<Employe>();
    	
    	Statement st = null;
    	ResultSet rs = null;
    	
    	try {
    		st = myConn.createStatement();
    		rs = st.executeQuery("SELECT nomEmp, preEmp, mail FROM employe");
    		
    		while (rs.next()) {
    			Employe tempEmploye = convertRowToEmploye(rs);
    			list.add(tempEmploye);
    		}
    		return list;
    	}
    	finally {
    		st.close();
    		rs.close();
    	}
    }
    
    private Employe convertRowToEmploye(ResultSet rs) throws SQLException {
		
		String nom = rs.getString("nomEmp");
		String prenom = rs.getString("preEmp");
		String mail = rs.getString("mail");
		String password = rs.getString("password");
		LocalDate dateArrive = ((Employe) rs).getDateArrive();
		Ligue ligue = new Ligue("");
		
		Employe tempEmploye = ligue.addEmploye( nom, prenom, mail, password, dateArrive);
		
		return tempEmploye;
	}
    
    private void close(Statement st, ResultSet rs) throws SQLException {
		close(null, st, rs);		
	}
	@Override
	public GestionPersonnel getGestionPersonnel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		
	}

}