import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class TestCircuit {
	
	@Test
	public void testSuppressionCircuit() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionCircuit("Porto-Vecchio"));
	}
	
	@Test
	public void testInsertionCircuit() {
		Assert.assertTrue("Erreur au niveau de l'insertion.", Modele.ajoutCircuit("Porto-Vecchio", "164", "France"));
	}
	
	@Test
	public void testRechercherCircuit() {
		Assert.assertFalse("Erreur au niveau de la recherche.", Modele.rechercherCircuit("Porto-Vecchio"));
	}
	
	@Test
	public void testTailleCircuit() {
		Assert.assertEquals("Erreur au niveau de la taille du circuit.", 1, Modele.affichageCircuit().size());
	}
}