package testsUnitaires;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.Employe;
import personnel.Ligue;

class TestEmploye {

	@Test
	void testEmploye() {
		fail("Not yet implemented");
	}

	@Test
	void testEstAdmin() {
		fail("Not yet implemented");
	}

	@Test
	void testEstRoot() {
		fail("Not yet implemented");
	}

	
	

	@Test
	void testSetNom() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = new Employe(ligue, "ka","me","ha","me");
		String Enom ="Aouar" ;
		employe.setNom(Enom);
		assertEquals(employe.getNom(),Enom);
		
		
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
	void testGetMail() {
	
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
	void testCheckPassword() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPassword() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLigue() {
		fail("Not yet implemented");
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
