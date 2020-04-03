package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import personnel.*;


class testLigue 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{	
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}
	

	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",null); 
		assertEquals(employe, ligue.getEmployes().first());
		assertEquals(employe.getLigue(),ligue);
	}
	
	
	@Test
	void testSetNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		String nom = "Aouar";
		Employe employe = ligue.addEmploye(nom, "Houssem", "aouar@gmail.com", "aouar",null);
		assertTrue(employe.getNom().contains(nom));
	}
	
	
	@Test
	void  testGetAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Ligue autreLigue = gestionPersonnel.addLigue(2,"Liga");
		Employe employe1 = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "azerty",null);
		Employe employe2 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",null);
		ligue.setAdministrateur(employe1);
		assertEquals(employe1, ligue.getAdministrateur());
		ligue.setAdministrateur(employe2);
		assertNotEquals(employe1, ligue.getAdministrateur());
		assertEquals(employe2, ligue.getAdministrateur());
		}
	
	
	@Test
	void testRemove() throws SauvegardeImpossible
	{
		GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		gestionPersonnel.getLigues().add(ligue);
		assertTrue(gestionPersonnel.getLigues().contains(ligue));
		ligue.remove();
		assertFalse(gestionPersonnel.getLigues().contains(ligue));
	}
	
	
	@Test
	void testCompareTo() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Ligue ligue2 = gestionPersonnel.addLigue("Liga");
		ligue.getNom().compareTo(ligue2.getNom());
		assertNotEquals(ligue.getNom(), ligue2.getNom());
	}
	
	
	@Test
	void testToString() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue(1,"Bowling");
		String nom = "Fortnite";
		ligue.setNom(nom);
		assertTrue(ligue.toString().contains("Bowling"));
	}
	
	
	void testGetEmployes() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue(1,"Bowling");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "aouar",null);
		assertTrue(ligue.getEmployes().contains(employe));
	}
	
}
