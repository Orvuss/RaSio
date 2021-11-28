import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class TestEcurie {
	
	@Test
	public void testSuppressionEcurie() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionEcurie("Depannor's"));
	}
	
	@Test
	public void testInsertionEcurie() {
		Assert.assertTrue("Erreur au niveau de l'insertion.", Modele.ajoutEcurie("Depannor's", "McLaren", "James Hunt"));
	}
	
	@Test
	public void testRechercherEcurie() {
		Assert.assertFalse("Erreur au niveau de la recherche.", Modele.rechercherEcurie("Depannor's"));
	}
	
	@Test
	public void testTailleEcurie() {
		Assert.assertEquals("Erreur au niveau de la taille de l'écurie.", 1, Modele.affichageEcurie().size());
	}
	
	@Test
	public void testEcurieCSV() {
		ConstrEcurie uneEcurie = new ConstrEcurie("Depannor's", "McLaren", "James Hunt");
		String resultat = "";
		resultat += "Depannor's,McLaren,James Hunt";
		Assert.assertNotNull("Erreur au niveau du CSV.", uneEcurie.toCSV());
	}
}