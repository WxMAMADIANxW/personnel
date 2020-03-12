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
		Ligue ligue = new Ligue("Fl�chettes");
		assertEquals("Fl�chettes", ligue.getNom());
	}

	@Test
	void testAddEmploye() 
	{
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",null); 
		assertEquals(employe, ligue.getEmployes().first());
		assertEquals(employe.getLigue(),ligue);
	}
	@Test
	void testSetNom()
	{
		Ligue ligue = new Ligue("Fortnite");
		String nom = "Aouar";
		Employe employe = ligue.addEmploye(nom, "Houssem", "aouar@gmail.com", "aouar",null);
		assertTrue(employe.getNom().contains(nom));
	}
	@Test
	void  testGetAdministrateur()
	{
		Ligue ligue = new Ligue("Fl�chettes");
		Ligue autreLigue = new Ligue("Harpon");
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
		Ligue ligue = new Ligue("Fl�chettes");
		gestionPersonnel.getLigues().add(ligue);
		assertTrue(gestionPersonnel.getLigues().contains(ligue));
		ligue.remove();

	}
	
	@Test
	void testCompareTo()
	{
		Ligue ligue = new Ligue("Fl�chettes");
		Ligue ligue2 = new Ligue("Fortnite");
		ligue.getNom().compareTo(ligue2.getNom());
		assertNotEquals(ligue.getNom(), ligue2.getNom());
	}
	
	@Test
	void testToString()
	{
		Ligue ligue = new Ligue("Fortnite");
		String nom = "Fortnite";
		ligue.setNom(nom);
		assertTrue(ligue.toString().contains("Fortnite"));
	}
	
	void testGetEmployes()
	{
		Ligue ligue = new Ligue("Fortnite");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "aouar",null);
		assertTrue(ligue.getEmployes().contains(employe));
	}
	
}
