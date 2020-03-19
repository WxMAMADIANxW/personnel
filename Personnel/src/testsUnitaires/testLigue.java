package testsUnitaires;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	@Test
	void testCreateLigue() 
	{	
		Ligue ligue = new Ligue(1,"La LDC",1);
		assertEquals("Fl�chettes", ligue.getNom());
	}

	@Test
	void testAddEmploye() 
	{
		Ligue ligue = new Ligue(1,"La LDC",1);
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",null); 
		assertEquals(employe, ligue.getEmployes().first());
		assertEquals(employe.getLigue(),ligue);
	}
	@Test
	void testSetNom()
	{
		Ligue ligue =new Ligue(1,"La LDC",1);
		String nom = "Aouar";
		Employe employe = ligue.addEmploye(nom, "Houssem", "aouar@gmail.com", "aouar",null);
		assertTrue(employe.getNom().contains(nom));
	}
	@Test
	void  testGetAdministrateur()
	{
		Ligue ligue = new Ligue(1,"La LDC",1);
		Ligue autreLigue = new Ligue(2,"Harpon",2);
		Employe employe1 = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "azerty",null);
		Employe employe2 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",null);
		ligue.setAdministrateur(employe1);
		assertEquals(employe1, ligue.getAdministrateur());
		ligue.setAdministrateur(employe2);
		assertNotEquals(employe1, ligue.getAdministrateur());
		assertEquals(employe2, ligue.getAdministrateur());
		
	}
	@Test
	void testRemove()
	{
		GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
		Ligue ligue =new Ligue(1,"La LDC",1);
		gestionPersonnel.getLigues().add(ligue);
		assertTrue(gestionPersonnel.getLigues().contains(ligue));
		ligue.remove();
		assertFalse(gestionPersonnel.getLigues().contains(ligue));
	}
	
	@Test
	void testCompareTo()
	{
		Ligue ligue = new Ligue(1,"La LDC",1);
		Ligue ligue2 = new Ligue(3,"Fortnite",3);
		ligue.getNom().compareTo(ligue2.getNom());
		assertNotEquals(ligue.getNom(), ligue2.getNom());
	}
	
	@Test
	void testToString()
	{
		Ligue ligue =new Ligue(1,"La LDC",1);
		String nom = "Fortnite";
		ligue.setNom(nom);
		assertTrue(ligue.toString().contains("Fortnite"));
	}
	
	void testGetEmployes()
	{
		Ligue ligue = new Ligue(1,"La LDC",1);
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "aouar",null);
		assertTrue(ligue.getEmployes().contains(employe));
	}
	
}
