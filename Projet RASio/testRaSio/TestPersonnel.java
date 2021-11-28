import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class TestPersonnel {
	
	@Test
	public void testSuppressionPersonnel() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionPersonnel("Aime", "Enzo"));
	}
	
	@Test
	public void testInsertionPersonnel() {
		Assert.assertTrue("Erreur au niveau de l'insertion.", Modele.ajoutPersonnel("Aime", "Enzo", "Jesaispas", "Courcouronnes", "91080"));
	}
	
	@Test
	public void testRechercherPersonnel() {
		Assert.assertFalse("Erreur au niveau de la recherche.", Modele.rechercherPersonnel("Aime"));
	}
	
	@Test
	public void testTaillePersonnel() {
		Assert.assertEquals("Erreur au niveau de la taille de l'écurie.", 1, Modele.affichagePersonnel().size());
	}
	
	@Test
	public void testPersonnelJSON() {
		ConstrPersonnel unPersonnel = new ConstrPersonnel("Aime", "Enzo", "Jesaispas", "Courcouronnes", "91080");
		String result = "";
        result += "\n\t{";
        result += "\n\t\t'nom' : 'Aime',";
        result += "\n\t\t'prenom' : 'Enzo',";
        result += "\n\t\t'adresse' : 'jesaispas',";
        result += "\n\t\t'ville' : 'Courcouronnes',";
        result += "\n\t\t'cp' : '91080'";
        result += "\n\t},";
		Assert.assertNotNull("Erreur au niveau du JSON.", unPersonnel.toJSON());
	}
}