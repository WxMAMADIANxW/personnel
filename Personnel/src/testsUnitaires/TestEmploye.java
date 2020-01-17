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

class TestEmploye {

	

	@Test
	void testEstAdmin() {
	Ligue ligue = new Ligue("La LDC");
	Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null,null);
	employe.getLigue().setAdministrateur(employe);
	assertTrue(employe.estAdmin(ligue));
	}

	@Test
	void testEstRoot() {
		
		
	}

	
	

	@Test
	void testSetNom() {
		Ligue ligue = new Ligue("La LDC");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null,null);
		String  nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}

	
	
	@Test
	void testSetPrenom() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null,null);
		String Eprenom = "Oussam" ;
		employe.setPrenom(Eprenom);
		assertEquals(employe.getPrenom(),Eprenom);
	}

	

	@Test
	void testSetMail() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null,null);
		String Email = "Oussam.Aouar@Ol.com";
		employe.setMail(Email);
		assertEquals(employe.getMail(),Email);
	}

	

	@Test
	void testSetPassword() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null,null);
		String Emdp = "azerty" ;
		employe.setPassword(Emdp);
		assertTrue(employe.checkPassword(Emdp));
	}

	@Test
	void testGetLigue() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null,null);
		assertEquals(employe.getLigue(),ligue);
	}

	@Test
	void testRemove() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null,null);
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
	}

	@Test
	void testCompareTo() {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe john=  ligue.addEmploye("john","ney","mare","pass01",null,null);
		Employe marie= ligue.addEmploye("marie","hey","mire","pass02",null,null);
		assertNotEquals( john.getPrenom().compareTo(marie.getPrenom()),0);
		
		
	}

	@Test
	void testToString() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null,null);
		assertEquals(employe.toString(), "Aouar Oussam Mail ("+ligue.toString()+")");
	}
	
	@Test
	void testGetArrive() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "pass",null,null);
		LocalDate date = LocalDate.of(2020, 01, 21);
		employe.setDateArrive(date);
		assertEquals(employe.getDateArrive(date), date);
	}
}


