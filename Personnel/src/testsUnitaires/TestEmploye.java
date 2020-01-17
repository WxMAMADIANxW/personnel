package testsUnitaires;



import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;

class TestEmploye {

	

	@Test
	void testEstAdmin() {
	Ligue ligue = new Ligue("La LDC");
	Employe employe = new Employe(ligue,"Aouar","Oussam","mail","pass");
	employe.getLigue().setAdministrateur(employe);
	assertTrue(employe.estAdmin(ligue));
	}

	@Test
	void testEstRoot() {
		Ligue ligue = new Ligue("La LDC");
		Employe employe = new Employe(ligue,"Aouar","Oussam","mail","pass");
		
	}

	
	

	@Test
	void testSetNom() {
		Ligue ligue = new Ligue("La LDC");
		Employe employe = new Employe(ligue,"surname","name","mail","pass");
		String  nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}

	
	
	@Test
	void testSetPrenom() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = new Employe(ligue, "ka","me","ha","me");
		String Eprenom = "Oussam" ;
		employe.setPrenom(Eprenom);
		assertEquals(employe.getPrenom(),Eprenom);
	}

	

	@Test
	void testSetMail() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = new Employe(ligue, "ka","me","ha","me");
		String Email = "Oussam.Aouar@Ol.com";
		employe.setMail(Email);
		assertEquals(employe.getMail(),Email);
	}

	

	@Test
	void testSetPassword() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = new Employe(ligue, "ka","me","ha","me");
		String Emdp = "azerty" ;
		employe.setPassword(Emdp);
		assertTrue(employe.checkPassword(Emdp));
	}

	@Test
	void testGetLigue() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = new Employe(ligue, "ka","me","ha","me");
		assertEquals(employe.getLigue(),ligue);
	}

	@Test
	void testRemove() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = new Employe(ligue, "ka","me","ha","me");
		assertFalse(ligue.getEmployes().contains(employe));
	}

	@Test
	void testCompareTo() {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe john= new Employe(ligue,"john","ney","mare","pass01");
		Employe marie= new Employe(ligue,"marie","hey","mire","pass02");
		assertNotEquals( john.getPrenom().compareTo(marie.getPrenom()),0);
		
		
	}

	@Test
	void testToString() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = new Employe(ligue, "Aouar","Oussam","Mail","password");
		assertEquals(employe.toString(), "Aouar Oussam Mail ("+ligue.toString()+")");
	}

}
