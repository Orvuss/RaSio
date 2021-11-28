import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class TestCourse {
	
	@Test
	public void testSuppressionCourse() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionCourse("Formul1"));
	}
	
	@Test
	public void testInsertionCourse() {
		Assert.assertTrue("Erreur au niveau de l'insertion.", Modele.ajoutCourse("Formul1", "SuperCar", 666));
	}
	
	@Test
	public void testRechercherCourse() {
		Assert.assertFalse("Erreur au niveau de la recherche.", Modele.rechercherCourse("Formul1"));
	}
	
	@Test
	public void testTailleCourse() {
		Assert.assertEquals("Erreur au niveau de la taille de la course.", 1, Modele.affichageCourse().size());
	}
	
	@Test
	public void testCourseXML() {
		ConstrCourse uneCourse = new ConstrCourse("Formul1", "SuperCar", 666);
		String resultat = "";
		resultat += "<course>";
		resultat += "\n\t<nom> Formul1 </nom>";
		resultat += "\n\t<type> SuperCar </type>";
		resultat += "\n\t<nbSpectateur> 666 </nbSpectateur>";
		resultat += "\n</course>";
		Assert.assertNotNull("Erreur au niveau du XML.", uneCourse.toXML());	
	}
}
