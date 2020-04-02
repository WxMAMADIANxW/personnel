package testsUnitaires;


import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;

class TestEmploye {

	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();

	@Test
	void testEstAdmin() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe Admin= ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null);
		Employe employe= ligue.addEmploye("Lambda", "employe", "mail", "azerty", null);
		Admin.getLigue().setAdministrateur(Admin);
		assertTrue(Admin.estAdmin(ligue));
		assertFalse(employe.estAdmin(ligue));
	}
	

	@Test
	void testEstRoot() throws SauvegardeImpossible {
		GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe Root = gestionPersonnel.getRoot();
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null);
		assertTrue(Root.estRoot());	
		assertFalse(employe.estRoot());
	}
	

	@Test
	void testSetNom() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null);
		String  nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}

	
	
	@Test
	void testSetPrenom() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null);
		String Eprenom = "Oussam" ;
		employe.setPrenom(Eprenom);
		assertEquals(employe.getPrenom(),Eprenom);
	}

	

	@Test
	void testSetMail() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null);
		String Email = "Oussam.Aouar@Ol.com";
		employe.setMail(Email);
		assertEquals(employe.getMail(),Email);
	}

	

	@Test
	void testSetPassword() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null);
		String Emdp = "azerty" ;
		employe.setPassword(Emdp);
		assertTrue(employe.checkPassword(Emdp));
	}

	
	@Test
	void testGetLigue() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null);
		assertEquals(employe.getLigue(),ligue);
		
	}
	

	@Test
	void testRemove() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null);
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
		assertNull(employe.getLigue());
	}
	

	@Test
	void testCompareTo() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe john=  ligue.addEmploye("john","ney","mare","pass01",null);
		Employe marie= ligue.addEmploye("marie","hey","mire","pass02",null);
		assertTrue( john.compareTo(marie)<0);
	}
	

	@Test
	void testToString() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null);
		assertTrue(employe.toString().contains("Houssem"));
	}
	
	
	@Test
	void testGetArrive() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		LocalDate dateArrive = LocalDate.of(2020, 01, 01);
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass", dateArrive);
		assertEquals(employe.getDateArrive(), dateArrive);
	}
	
	
	@Test
	void testSetArrive() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		LocalDate dateArrive = LocalDate.of(2020, 01, 01);
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass", dateArrive);
		assertEquals(employe.getDateArrive(), dateArrive);
	}
		
	@Test
	void testGetDepart() throws SauvegardeImpossible {
		Ligue ligue = gestionPersonnel.addLigue("Bowling");
		LocalDate dateArrive = LocalDate.of(2020, 01, 01);
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",dateArrive);
		LocalDate date = LocalDate.of(2020, 01, 21);
		employe.setDateDepart(date);
		assertEquals(employe.getDateDepart(), date);
	}
}


