package testsUnitaires;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.Employe;
import personnel.Ligue;

class testGestion {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	
	void testAdd() 
	{
		Ligue ligue = new Ligue("Ouais");
		//Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty"); 
		//a(ligue, ligue.getEmployes().first());
		assertEquals(ligue, ligue.getEmployes().first());

	}
	
	
}
